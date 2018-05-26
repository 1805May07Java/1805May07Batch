create table ERS_USER_ROLES
(
  USER_ROLE_ID number,
  USER_ROLE varchar(50)
);

create table ERS_USERS
(
  ERS_USERS_ID number,
  ERS_USERNAME varchar2(50),
  ERS_PASSWORD varchar2(50),
  USER_FIRST_NAME varchar2(50),
  USER_LAST_NAME varchar2(50),
  USER_EMAIL varchar2(50)
);

create table ERS_REIMBURSEMENT_TYPE
(
  REIMB_TYPE_ID number,
  REIMB_TYPE varchar2(50)
);

create table ERS_REIMBURSEMENT_STATUS
(
  REIMB_STATUS_ID number primary key,
  REIMB_STATUS varchar2(10)
);

create table ERS_REIMBURSEMENT
(
  REIMB_AMOUNT_ID number primary key,
  REIMB_AMOUNT number,
  REIMB_SUBMITTED timestamp(50),
  REIMB_RESOLVED timestamp(50),
  REIMB_DESCRIPTION varchar2(250),
  REIMB_RECEIPT BLOB
);
