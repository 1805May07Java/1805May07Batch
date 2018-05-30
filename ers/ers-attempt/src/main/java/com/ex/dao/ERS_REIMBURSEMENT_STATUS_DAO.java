package com.ex.dao;

import java.sql.Statement; // beans?
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ex.pojo.ERS_REIMBURSEMENT_STATUS;
import com.ex.run.App;
import com.ex.util.ConnectionFactory;

public class ERS_REIMBURSEMENT_STATUS_DAO {
	final static Logger logger = Logger.getLogger(App.class);

	public ERS_REIMBURSEMENT_STATUS getERS_REIMBURSEMENT_STATUS(int id) {
		
			ERS_REIMBURSEMENT_STATUS localERS_REIMBURSEMENT_STATUS = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "select * from ERS_REIMBURSEMENT_STATUS where REIMB_STATUS_ID = ?";
							
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); // problem
			conn.commit();
			rs.next();
			String reimb_status = rs.getString(1);
			localERS_REIMBURSEMENT_STATUS = new ERS_REIMBURSEMENT_STATUS(id, reimb_status);
			System.out.println(reimb_status);
			System.out.println("connection possibly made");
			logger.info("connection possibly made");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return localERS_REIMBURSEMENT_STATUS;
	}
}

		
