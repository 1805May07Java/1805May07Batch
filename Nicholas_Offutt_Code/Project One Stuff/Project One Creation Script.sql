--Schema


--Reimbursement status lookup table
create table ERS_REIMBURSEMENT_STATUS
(
	REIMB_STATUS_ID number primary key,
	REIMB_STATUS varchar2(10) not null
);

--Reimbursement type lookup table
create table ERS_REIMBURSMENT_TYPE
(
	REIMB_TYPE_ID number primary key,
	REIMB_TYPE varchar2(10) not null
);

--role lookup table
create table ERS_USER_ROLES
(
	USER_ROLE_ID number primary key,
	USER_ROLE varchar2(10) not null
);


--USER TABLE
create table ERS_USER
(
	ERS_USER_ID number primary key,
	ERS_USER_NAME varchar2(50) unique,
	ERS_PASSWORD varchar2(50) not null,
	FIRST_NAME varchar2(100) not null,
	LAST_NAME varchar2(100) not null,
	USER_EMAIL varchar2(150) unique not null,
	USER_ROLE_ID number not null,
	constraint USER_ROLE_ID foreign key (ERS_USER_ROLES) references ERS_USER_ROLES(USER_ROLE_ID)
);

--table fro the reimbursements themselves
create table ERS_REIMBURSEMENT
(
	REIMB_ID number primary key not null,
	REIMB_AMOUNT number not null,
	REIMB_SUBMITTED TIMESTAMP not null,
	REIMB_RESOLVED TIMESTAMP,
	REIMB_DESCRIPTION varchar2(250),
	REIMB_RECEIPT BLOB,
	REIMB_AUTHOR number not null,
	REIMB_RESOLVER number not null,
	REIMB_STATUS_ID number not null,
	REIMB_TYPE_ID number not null,
	constraint REIMB_AUTHOR foreign key (ERS_USER) references ERS_USER(ERS_USER_ID),
	REIMB_RESOLVER foreign key (ERS_USER) references ERS_USER(ERS_USER_ID),
	REIMB_STATUS_ID foreign key (ERS_REIMBURSEMENT_STATUS) references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
	REIMB_TYPE_ID foreign key (ERS_REIMBURSMENT_TYPE) references ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID)
);


create sequence reim_status;
create sequence reim_type;
create sequence reim_role;
create sequence reim_user;
create sequence reim_reims;

create or replace trigger incre_status
before insert on ERS_REIMBURSEMENT_STATUS
for each row 
begin
select reim_status.nextVal into :new.REIMB_STATUS_ID from dual;
end;
/
create or replace trigger incre_type
before insert on ERS_REIMBURSMENT_TYPE
for each row 
begin
select reim_type.nextVal into :new.REIMB_TYPE_ID from dual;
end;
/
create or replace trigger incre_role
before insert on ERS_USER_ROLES
for each row 
begin
select reim_role.nextVal into :new.USER_ROLE_ID from dual;
end;
/
create or replace trigger incre_user
before insert on ERS_USER
for each row 
begin
select reim_user.nextVal into :new.ERS_USER_ID from dual;
end;
/
create or replace trigger incre_reims
before insert on 
for each row ERS_REIMBURSEMENT
begin
select reim_reims.nextVal into :new.REIMB_ID from dual;
end;
/