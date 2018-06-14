package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BANK_USERS")
public class User {
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(sequenceName="B_U_ID", allocationSize=1, name="b_u_id")
	@GeneratedValue(generator="b_u_id", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;

}
