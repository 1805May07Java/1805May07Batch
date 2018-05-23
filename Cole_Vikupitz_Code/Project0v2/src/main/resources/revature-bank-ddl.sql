/*
 * revature-bank-ddl.sql
 * Author: Cole Vikupitz
 *
 * The DDL script for intializing the banking database used in project 0.
 */


/*
 * Drops the database if it already exists in system
 */
DROP USER bank_admin CASCADE;


/*
 * Create the user/database & credentials
 */
CREATE USER bank_admin
IDENTIFIED BY f9344b8fa2b8bd2f
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/*
 * Grant privileges to the new user
 */
GRANT CONNECT TO bank_admin;
GRANT RESOURCE TO bank_admin;
GRANT CREATE SESSION TO bank_admin;
GRANT CREATE TABLE TO bank_admin;
GRANT CREATE VIEW TO bank_admin;

conn bank_admin/f9344b8fa2b8bd2f


/*
 * Defines and creates the tables
 */
CREATE TABLE Account_Type (
    
    AccountTypeId NUMBER PRIMARY KEY,
    AccountType VARCHAR2(20) NOT NULL
);

CREATE TABLE User_Profile (

    UserId NUMBER PRIMARY KEY,
    FirstName VARCHAR2(25) NOT NULL,
    LastName VARCHAR2(25) NOT NULL,
    Username VARCHAR2(25) NOT NULL UNIQUE,
    Password_ VARCHAR2(25) NOT NULL
);

CREATE TABLE Account (

    AccountId NUMBER PRIMARY KEY,
    AccountUser_FK NUMBER NOT NULL,
    AccountType_FK NUMBER NOT NULL,
    AccountBalance NUMBER(20, 2) DEFAULT 0,
    FOREIGN KEY(AccountUser_FK) REFERENCES User_Profile(UserId),
    FOREIGN KEY(AccountType_FK) REFERENCES Account_Type(AccountTypeId)
);


/*
 * Add the account types into the table
 */
INSERT INTO Account_Type VALUES (1, 'Credit');
INSERT INTO Account_Type VALUES (2, 'Savings');
INSERT INTO Account_Type VALUES (3, 'Checking');


/*
 * Create sequence(s); used for primary keys for new records
 */
CREATE SEQUENCE USER_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ACCOUNT_SEQ
START WITH 100
INCREMENT BY 1;


/*
 * Create all triggers the database will use
 */
CREATE OR REPLACE TRIGGER USER_SEQ_TRIGGER
BEFORE INSERT ON User_Profile
FOR EACH ROW
BEGIN
  SELECT USER_SEQ.NEXTVAL INTO :new.UserId FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ACCOUNT_SEQ_TRIGGER
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  SELECT ACCOUNT_SEQ.NEXTVAL INTO :new.AccountId FROM DUAL;
END;
/


/*
 * Create stored procedures/functions
 */
CREATE OR REPLACE PROCEDURE updateBalance(aid IN NUMBER, nbalance IN NUMBER)
AS
BEGIN
	UPDATE Account
	SET AccountBalance = nbalance
	WHERE AccountId = aid;
END;
/

/*
 * Commit all changes, exit
 */
COMMIT;
EXIT;
