CREATE TABLE customer
(
    userid NUMBER NOT NULL,
    fname VARCHAR2(160) NOT NULL,
    lname VARCHAR2(160) NOT NULL,
    username VARCHAR2(160) NOT NULL,
    password VARCHAR2(160) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY  (userid)
);

CREATE TABLE accounttype
(
    accounttypeid NUMBER NOT NULL,
    accounttype VARCHAR2(160) NOT NULL,
    CONSTRAINT PK_accounttype PRIMARY KEY (accounttypeid)
);

CREATE TABLE account
(
    accountid NUMBER NOT NULL,
    accounttype NUMBER NOT NULL,
    userid NUMBER NOT NULL,
    balance NUMBER NOT NULL,
    CONSTRAINT PK_account PRIMARY KEY  (accountid),
    CONSTRAINT FK_accountuser FOREIGN KEY (userid) REFERENCES customer (userid),
    CONSTRAINT FK_accounttype FOREIGN KEY (accounttype) REFERENCES accounttype (accounttypeid)
);

create sequence customer_sec
start with 1
increment by 1;

create or replace trigger customer_seq_trigger
BEFORE INSERT on customer
for each row
Begin
select customer_sec.nextVal into :new.userid from dual;
end;

SELECT accounttype FROM accounttype WHERE accounttypeid = 1;
Select * from account;

insert into customer(FNAME, LNAME, username, password) VALUES('Nathan', 'Ashcroft', 'nashcroft42', 'test123');
insert into account(ACCOUNTTYPE, USERID, BALANCE) Values(3, 1, 15.91);

Select * from account WHERE accountid = 1001;

UPDATE account SET balance = 1000.71 WHERE accountid = 1001;

Select * from account WHERE userid = 1;

insert into customer(FNAME, LNAME, username, password) VALUES('LeeAnne', 'Ashcroft', 'test', 'test123');

SELECT * from CUSTOMER WHERE USERNAME = 'nashcroft42';

Select * from account WHERE userid = 1;

Select * from account WHERE USERID = 1;

CREATE OR REPLACE PROCEDURE getusers(
  cursorParam OUT SYS_REFCURSOR)
  is
  begin
   open cursorParam for select * from customer;
  end;
  
  select * from customer;
  
  execute getusers();

