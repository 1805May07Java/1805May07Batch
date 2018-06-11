package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.proxy.annotation.Pre;
import pojos.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementDao {

    public ArrayList<Reimbursement> getAll() {
        ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
        try (Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            String query = "select reim.submitted_time, u.firstname, u.lastname, status.status, typ.reimb_type," +
                    "reim.description, reim.amount, us.lastname," +
                    "reim.resolved_time, reim.reimb_id, reim.reimb_resolver, reim.status_id " +
                    "from users u " +
                    "inner join reimbursement reim on u.user_id = reim.reimb_author " +
                    "inner join reimbursement_status status on status.status_id = reim.status_id " +
                    "inner join reimbursement_type typ on reim.reimb_type_id = typ.reimb_type_id " +
                    "left outer join users us on reim.reimb_resolver = us.user_id " +
                    "order by reim.submitted_time asc";
//            String query = "select reim.r, amount,  from reimbursement";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                Reimbursement temp = new Reimbursement(rs.getDouble(7),
                        rs.getTimestamp(1), //submit time
                        rs.getTimestamp(9), //resolve time
                        rs.getString(6), //description
                        rs.getString(2), //firstname
                        rs.getString(3), //lastname
                        rs.getString(8), //resolver lastname
                        rs.getString(4), //status
                        rs.getString(5), //reimb type
                        rs.getInt(10), //reimb id
                        rs.getInt(11), //resolver id
                        rs.getInt(12)); //status id

                data.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<Reimbursement> getById(int id) {
        ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
        try (Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            String query = "select status.status, typ.reimb_type, reim.description, " +
                    "reim.amount, reim.submitted_time, us.lastname, " +
                    "reim.resolved_time " +
                    "from users u " +
                    "inner join reimbursement reim on u.user_id = reim.reimb_author " +
                    "inner join reimbursement_status status on status.status_id = reim.status_id " +
                    "inner join reimbursement_type typ on reim.reimb_type_id = typ.reimb_type_id " +
                    "left outer join users us on reim.reimb_resolver = us.user_id " +
                    "where u.user_id = ? " +
                    "order by reim.submitted_time desc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Reimbursement temp = new Reimbursement(rs.getDouble(4),
                        rs.getTimestamp(5),
                        rs.getTimestamp(7),
                        rs.getString(3),
                        rs.getString(6),
                        rs.getString(1),
                        rs.getString(2));
                data.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<Reimbursement> getByStatus(int status){
        ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
        try (Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            String query = "select reim.submitted_time, u.firstname, u.lastname, status.status, typ.reimb_type," +
                    "reim.description, reim.amount, us.lastname," +
                    "reim.resolved_time, reim.reimb_id, reim.reimb_resolver, reim.status_id " +
                    "from users u " +
                    "inner join reimbursement reim on u.user_id = reim.reimb_author " +
                    "inner join reimbursement_status status on status.status_id = reim.status_id " +
                    "inner join reimbursement_type typ on reim.reimb_type_id = typ.reimb_type_id " +
                    "left outer join users us on reim.reimb_resolver = us.user_id " +
                    "where reim.status_id = ? " +
                    "order by reim.submitted_time asc";
//            String query = "select reim.r, amount,  from reimbursement";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Reimbursement temp = new Reimbursement(rs.getDouble(7),
                        rs.getTimestamp(1), //submit time
                        rs.getTimestamp(9), //resolve time
                        rs.getString(6), //description
                        rs.getString(2), //firstname
                        rs.getString(3), //lastname
                        rs.getString(8), //resolver lastname
                        rs.getString(4), //status
                        rs.getString(5), //reimb type
                        rs.getInt(10), //reimb id
                        rs.getInt(11), //resolver id
                        rs.getInt(12)); //status id

                data.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public void addReimbursement(int id, double amount, String description, int type_id) {
        System.out.println("addReimbursement (dao) called.");
        try (Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            String query = "insert into reimbursement(amount, submitted_time, description, reimb_author, status_id, reimb_type_id) " +
                    "values(?, current_timestamp, ?, ?, 1, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setString(2, description);
            ps.setInt(3, id);
            ps.setInt(4, type_id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateReimbursement(int id, int status_id, int resolver_id){
        try(Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String query = "update reimbursement set status_id = ?, resolved_time = current_timestamp, reimb_resolver = ? where reimb_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, status_id);
            ps.setInt(2, resolver_id);
            ps.setInt(3, id);
            ps.executeUpdate();
            conn.commit();
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public Reimbursement getByReimbId(int id){
        Reimbursement result = new Reimbursement();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String query = "select * from reimbursement where reimb_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                result.setId(rs.getInt("REIMB_ID"));
                result.setStatus_id(rs.getInt("STATUS_ID"));
                result.setResolver_id(rs.getInt("REIMB_RESOLVER"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

