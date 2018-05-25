package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public void newAccount(Account account, User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String account_insert = "insert into accounts (TYPE, BALANCE) values (?,?)";
            String returnedCol[] = { "ACCOUNT_ID" };
            PreparedStatement ps1 = conn.prepareStatement(account_insert, returnedCol);
            ps1.setInt(1, account.getAccountType());
            ps1.setDouble(2, account.getBalance());
            int affectedrows = ps1.executeUpdate();
            if(affectedrows!=0) {
                ResultSet pk = ps1.getGeneratedKeys();
                if (pk.next()) {
                    account.setAccountId((pk.getInt(1)));
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }
            conn.commit();
            conn.close();
            insertToJunction(account,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertToJunction(Account account, User user){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String junctiontable_insert = "insert into useraccountsjunction (USER_ID, ACCOUNT_ID) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(junctiontable_insert);
            ps.setInt(1, user.getId());
            ps.setInt(2, account.getAccountId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getBalance(Account userAccount) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String query = "select balance from accounts where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userAccount.getAccountId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void updateBalance(Account userAccount) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String query = "update accounts set balance = ? where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, userAccount.getBalance());
            ps.setInt(2,userAccount.getAccountId());

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBalanceProc(Account userAccount){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String query = "{call updateBalance(?,?)}";

            CallableStatement cs = conn.prepareCall(query);
            cs.setDouble(1,userAccount.getBalance());
            cs.setInt(2,userAccount.getAccountId());
            cs.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Account> findAccounts(User user) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String query =
                    "select * from accounts where account_id IN(" +
                    "select account_id from users inner join useraccountsjunction on useraccountsjunction.user_id = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,user.getId());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Account temp = new Account();
                temp.setAccountId(rs.getInt(1));
                temp.setBalance(rs.getDouble(2));
                temp.setAccountType(rs.getInt(3));
                accounts.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
