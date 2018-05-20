package com.bk.service;

import com.bk.dao.DAO;
import com.bk.pojos.Access;

public class Portal extends Access implements indicator {
boolean isLogin(){
	if(status){
		return true;
	} else {
	    return false;
	}
};
int Logout(){
	
	return INACTIVE;
};

public Access Login(String usr, String psswrd) {
	DAO dataAccessTable = new DAO();
	Access usrAccess = dataAccessTable.getAccessByPass(usr, psswrd);
	if(usrAccess.getId() != -1) {
		usrAccess.setStatus(true);
	}
	return usrAccess;

}

}
