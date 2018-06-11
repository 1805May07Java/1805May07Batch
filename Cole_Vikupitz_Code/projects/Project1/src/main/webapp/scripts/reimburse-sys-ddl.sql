/*
 * reimburse-sys-ddl.sql
 * Author: Cole Vikupitz
 *
 * The DDL script for intializing the reimbursement database used in project 1.
 *
 */


/*
 * Drops the database if it already exists in system
 */
DROP USER sys_admin CASCADE;


/*
 * Create the user/database & credentials
 */
CREATE USER sys_admin
IDENTIFIED BY cbf01bf8dc0189f68416
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;


/*
 * Grant privileges to the new user
 */
GRANT CONNECT TO sys_admin;
GRANT RESOURCE TO sys_admin;
GRANT CREATE SESSION TO sys_admin;
GRANT CREATE TABLE TO sys_admin;
GRANT CREATE VIEW TO sys_admin;

conn sys_admin/cbf01bf8dc0189f68416


/*
 * Defines and creates the tables
 */
CREATE TABLE User_Role (
    
    UserRoleId          NUMBER PRIMARY KEY,
    UserRoleName        VARCHAR2(16) NOT NULL
);

CREATE TABLE Status (
    
    StatusId            NUMBER PRIMARY KEY,
    StatusTitle         VARCHAR2(16) NOT NULL
);

CREATE TABLE Reimb_Type (

    ReimbTypeId         NUMBER PRIMARY KEY,
    ReimbTypeTitle      VARCHAR2(16)
);

CREATE TABLE Users (
    
    UserId              NUMBER PRIMARY KEY,
    FirstName           VARCHAR2(32) NOT NULL,
    LastName            VARCHAR2(32) NOT NULL,
    Email               VARCHAR2(128) NOT NULL,
    Password_           VARCHAR2(32) NOT NULL,
    UserRole_FK         NUMBER NOT NULL,
    FOREIGN KEY (UserRole_FK) REFERENCES User_Role(UserRoleId)
);

CREATE TABLE Reimbursement (

    ReimbId             NUMBER PRIMARY KEY,
    Amount              NUMBER(16, 2) NOT NULL,
    Status_FK           NUMBER NOT NULL,
    Reimb_Type_FK       NUMBER NOT NULL,
    SubmittedBy_FK      NUMBER NOT NULL,
    ReviewedBy_FK       NUMBER,
    SubmittedAt         DATE,
    ReviewedAt          DATE,
    Description         VARCHAR(1000),
    FOREIGN KEY (Status_FK) REFERENCES Status(StatusId),
    FOREIGN KEY (Reimb_Type_FK) REFERENCES Reimb_Type(ReimbTypeId),
    FOREIGN KEY (SubmittedBy_FK) REFERENCES Users(UserId),
    forEIGN KEY (ReviewedBy_FK) REFERENCES Users(UserId)
);


/*
 * Add the user role(s) into the table
 */
INSERT INTO User_Role VALUES (1, 'Employee');
INSERT INTO User_Role VALUES (2, 'Finance Manager');
 
 
/*
 * Add the status type(s) into the table
 */
INSERT INTO Status VALUES (1, 'Pending');
INSERT INTO Status VALUES (2, 'Approved');
INSERT INTO Status VALUES (3, 'Denied');
 

/*
 * Add the reimbursement type(s) into the table
 */
INSERT INTO Reimb_Type VALUES (1, 'Lodging');
INSERT INTO Reimb_Type VALUES (2, 'Food');
INSERT INTO Reimb_Type VALUES (3, 'Travel');
INSERT INTO Reimb_Type VALUES (4, 'Training');
INSERT INTO Reimb_Type VALUES (5, 'Education');
INSERT INTO Reimb_Type VALUES (6, 'Supplies');
INSERT INTO Reimb_Type VALUES (7, 'Medical');
INSERT INTO Reimb_Type VALUES (8, 'Other');
 
 
/*
 * Create & initialize any/all sequence(s)
 */
CREATE SEQUENCE USER_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE REIMB_SEQ
START WITH 1
INCREMENT BY 1;
/
 
 
/*
 * Create all triggers the database will use
 */
CREATE OR REPLACE TRIGGER USER_SEQ_TRIGGER
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN
  SELECT USER_SEQ.NEXTVAL INTO :new.UserId FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER REIMB_SEQ_TRIGGER
BEFORE INSERT ON Reimbursement
FOR EACH ROW
BEGIN
  SELECT REIMB_SEQ.NEXTVAL INTO :new.ReimbId FROM DUAL;
END;
/
 
 
/*
 * Create any stored procedures/functions
 */
CREATE OR REPLACE PROCEDURE newRequest(
    amt IN NUMBER,      -- The amount
    ty IN NUMBER,       -- The type
    smid IN NUMBER,     -- Submitted by FK
    des IN VARCHAR2     -- Description
)
AS
BEGIN
    INSERT INTO Reimbursement
    (Amount, Status_FK, Reimb_Type_FK, SubmittedBy_FK, SubmittedAt, Description)
    VALUES
    (amt, 1, ty, smid, SYSDATE, des);
END;
/

CREATE OR REPLACE PROCEDURE updateRequest(
    rid IN NUMBER,  -- Reviewer's ID
    st IN NUMBER,   -- The updated status
    pid IN NUMBER   -- ID of request to update
)
AS
BEGIN
    UPDATE Reimbursement
    SET Status_FK = st,
        ReviewedBy_FK = rid,
        ReviewedAt = SYSDATE
    WHERE ReimbId = pid;
END;
/

 
/*
 * Commit all changes, exit
 */
COMMIT;
EXIT;

