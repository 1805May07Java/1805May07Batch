package com.ex.run;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.ex.service.ERS_REIMBURSEMENT_STATUS_Service;
import com.ex.service.ERS_USERS_Service;

//The real application uses a web front end. 
//This class is for testing.
public class App {
	final static Logger logger = Logger.getLogger(App.class);
	static ERS_USERS_Service eus = new ERS_USERS_Service();
	static ERS_REIMBURSEMENT_STATUS_Service erss = new ERS_REIMBURSEMENT_STATUS_Service();

	public static void main(String[] args) {
		System.out.println("in main");
		System.out.println(ERS_USERS_Service.test());
		System.out.println(ERS_REIMBURSEMENT_STATUS_Service.test());
		logger.error("test");
		BasicConfigurator.configure();
		logger.info("This is logger info");
	}
}
