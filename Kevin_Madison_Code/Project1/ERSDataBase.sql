/*
Kevin Madison
Revature Associate
*/
drop table ers_reimbursement cascade constraints;
drop table ers_reimbursement_status cascade constraints;
drop table ers_reimbursement_type cascade constraints;
drop table ers_users cascade constraints;
drop table ers_user_roles cascade constraints;


create table ers_reimbursement_status(
  reimb_status_id number not null,
  reimb_status varchar2(10) not null,
  CONSTRAINT reimb_status_pk PRIMARY KEY (reimb_status_id)
)

create table ers_reimbursement_type(
  reimb_type_id number not null,
  reimb_type varchar2(10) not null,
  CONSTRAINT reimb_type_pk PRIMARY KEY (reimb_type_id)
)

create table ers_user_roles(
  ers_user_role_id number not null,
  user_role varchar2(10) not null,
  CONSTRAINT ers_user_roles_pk PRIMARY KEY  (ers_user_role_id)
)

create table ers_reimbursement(
  reimb_id number not null,
  reimb_amount number not null,
  reimb_submitted timestamp not null,
  reimb_resolved timestamp,
  reimb_description varchar2(250),
  reimb_author number not null,
  reimb_resolver number,
  reimb_status_id number not null,
  reimb_type_id number not null,
  CONSTRAINT ers_reimbursement_pk PRIMARY KEY (reimb_id)
)

create table ers_users(
  ers_user_id number not null,
  ers_username varchar2(50) not null,
  ers_password varchar2(50) not null,
  user_first_name varchar2(100) not null,
  user_last_name varchar2(100) not null,
  user_email varchar2(150) not null,
  user_role_id number not null,
  CONSTRAINT ers_user_pk PRIMARY KEY (ers_user_id)
)




-- Add Foreign Keys


ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_author
    FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_user_id);
    
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_reslvr
    FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_user_id);

ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_status_fk
    FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id);
    
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_type_fk
    FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id);
    
ALTER TABLE ers_users ADD CONSTRAINT user_roles_fk
    FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id);
    
ALTER TABLE ers_users ADD CONSTRAINT ers_user_UNv1
    UNIQUE (ers_username, user_email);


--Sequence/Triggers/Procedures/Functions
   
--SEQUENCES
create sequence user_seq
start with 1
increment by 1;

create sequence reimb_seq
start with 99
increment by 7;

--TRIGGERS
create or replace trigger user_seq_trigger 
before insert on ers_users
for each row
begin
  --where the trigger resides
  select user_seq.nextVal into :new.ers_user_id from dual;
end;
/

create or replace trigger reimb_seq_trigger 
before insert on ers_reimbursement
for each row
begin
  select reimb_seq.nextVal into :new.reimb_id from dual;
end;
/
  
    
/***********************************************
/ Add Default Data
***********************************************/
insert into ers_reimbursement_type(reimb_type_id, reimb_type) values(1, 'lodging');
insert into ers_reimbursement_type(reimb_type_id, reimb_type) values(2, 'travel');
insert into ers_reimbursement_type(reimb_type_id, reimb_type) values(3, 'food');
insert into ers_reimbursement_type(reimb_type_id, reimb_type) values(4, 'other');

insert into ers_user_roles(ERS_USER_ROLE_ID, USER_ROLE) values (1, 'employee');
insert into ers_user_roles(ERS_USER_ROLE_ID, USER_ROLE) values (2, 'manager');
    
insert into ers_reimbursement_status(reimb_status_id, reimb_status) values (1, 'pending');
insert into ers_reimbursement_status(reimb_status_id, reimb_status) values (2, 'approved');
insert into ers_reimbursement_status(reimb_status_id, reimb_status) values (3, 'denied');
    
insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values('admin','pass','kevin','jumbo', 'kevindoesnotsmell@gmail.com', 2);  
insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values('employee','pass','kevin','madison', 'kevinsmells@gmail.com', 1);
insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values('employee2','pass','Mike','Bryant', 'mikeactuallysmells@gmail.com', 1);

insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
  values(20, sysdate, 'default description', 85, 1, 1);
  
  insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
  values(100, sysdate, 'default description', 85, 2, 2);
  
  insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
  values(150, sysdate, 'default description', 85, 3, 3);


/**********************************************
/ TESTING
/*********************************************/


select ers_password from ers_users where ers_username = 'admin';

--update an existing reimbursment data
update ers_reimbursement
set reimb_resolved = sysdate,
reimb_resolver = 62,
reimb_status_id = 2
where reimb_id = 1;

update ers_reimbursement set reimb_resolved = sysdate, reimb_resolver = 61, reimb_status_id = 2 where reimb_id = 1;

update ers_users set ers_username = 'employee1', ers_password = 'pass', user_first_name = 'John', user_last_name = 'Dude', user_email = 'kevinsmellsnice@gmail.com' where ers_user_id = 85;