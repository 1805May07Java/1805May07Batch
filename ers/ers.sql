create table ERS_USER_ROLES
(
  ERS_USER_ROLE_ID number primary key,
  USER_ROLE varchar(10)
);

create sequence ERS_USER_ROLES_SEQ;

create or replace trigger ERS_USER_ROLE_ID
before insert on ERS_USER_ROLES
for each row
begin
    select ERS_USER_ROLES_SEQ.nextval
    into :new.ERS_USER_ROLE_ID
    from dual;
end;
/

create table ERS_REIMBURSEMENT_TYPE
(
  REIMB_TYPE_ID number primary key,
  REIMB_TYPE varchar2(10)
);

create sequence ERS_REIMBURSEMENT_TYPE_SEQ;

create or replace trigger REIMB_TYPE_ID
before insert on ERS_REIMBURSEMENT_TYPE
for each row
begin
    select ERS_REIMBURSEMENT_TYPE_SEQ.nextval
    into :new.REIMB_TYPE_ID
    from dual;
end;
/

create table ERS_REIMBURSEMENT_STATUS
(
  REIMB_STATUS_ID number primary key,
  REIMB_STATUS varchar2(10)
);

create or replace trigger REIMB_STATUS_ID
before insert on ERS_REIMBURSEMENT_STATUS
for each row
begin
    select ERS_REIMBURSEMENT_STATUS_SEQ.nextval
    into :new.REIMB_STATUS_ID
    from dual;
end;
/

create table ERS_USERS
(
  ERS_USERS_ID number primary key,
  ERS_USERNAME varchar2(50) unique,
  ERS_PASSWORD varchar2(50),
  USER_FIRST_NAME varchar2(100),
  USER_LAST_NAME varchar2(100),
  USER_EMAIL varchar2(100) unique,
  USER_ROLE_ID number references ERS_USER_ROLES(ERS_USER_ROLE_ID)
);

create sequence ERS_REIMBURSEMENT_STATUS_SEQ; -- MUST BE LESS THAN 30 CHARACTERS

insert into ERS_REIMBURSEMENT_STATUS values(1,'Pending');
insert into ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) values ('Approved');
insert into ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) values ('Denied');

create table ERS_REIMBURSEMENT
(
  REIMB_ID number primary key,
  REIMB_AMOUNT number,
  REIMB_SUBMITTED timestamp,
  REIMB_RESOLVED timestamp,
  REIMB_DESCRIPTION varchar2(250),
  REIMB_RECEIPT BLOB,
  REIMB_AUTHOR number references ERS_USERS(ERS_USERS_ID),
  REIMB_RESOLVER number references ERS_USERS(ERS_USERS_ID),
  REIMB_STATUS_ID number references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
  REIMB_TYPE_ID number references ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);

create sequence REIMB_ID_SEQUENCE;

create or replace trigger REIMB_ID_ON_INSERT
before insert on ERS_REIMBURSEMENT
for each row
begin
    select REIMB_ID_SEQUENCE.nextval
    into :new.REIMB_ID
    from dual;
end;
/
