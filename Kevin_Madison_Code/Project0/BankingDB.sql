/*************************************************************
Kevin Madison
Project 0: Banking Assignment
*************************************************************/

/************************************************************
* Drop Tables if they already exist
*************************************************************/
Drop Table Account_Type cascade CONSTRAINTS;
Drop Table Bank_Account cascade CONSTRAINTS;
Drop Table Person cascade CONSTRAINTS;


/************************************************************
* Create Tables
*************************************************************/
CREATE TABLE Person
(
  person_id number(10) not null,
  firstname varchar(20),
  lastname varchar(20),
  username varchar(30),
  password varchar(30),
  CONSTRAINT PK_Person PRIMARY KEY (person_id)
);

CREATE TABLE Account_Type(
  type_id number(10) NOT NULL,
  type varchar(20),
  CONSTRAINT PK_AccountType PRIMARY KEY (type_id)
);

CREATE TABLE Bank_Account
(
  account_id number(10)Not Null,
  balance number(20,2),
  bank_type number(10),
  owner_id number(10),
  CONSTRAINT PK_Account PRIMARY KEY (account_id),
  CONSTRAINT FK_Account_AccountType FOREIGN KEY(bank_type) REFERENCES Account_Type(type_id),
  CONSTRAINT FK_Account_Owner FOREIGN KEY(owner_id) REFERENCES Person(person_id)
);
/*******************************************************
/ PL/SQL Statements
/*******************************************************/

--SEQUENCES
create sequence person_seq
start with 1
increment by 1;

create sequence account_seq
start with 1
increment by 1;

--TRIGGERS
create or replace trigger person_seq_trigger 
before insert on person
for each row
begin
  --where the trigger resides
  select person_seq.nextVal into :new.person_id from dual;
end;
/

create or replace trigger account_seq_trigger 
before insert on bank_account
for each row
begin
  select account_seq.nextVal into :new.account_id from dual;
end;
/
/*******************************************************
/ Procedures and Functions
/*******************************************************/
create or replace procedure update_balance
  (
  temp_id in Number, 
  new_balance in Number
  ) 
  AS 
  Begin
    Update bank_account 
    set balance = new_balance
    where account_id = temp_id;
  End update_balance;
/



/*******************************************************
/ Insert Bank Types and Default Accounts
/*******************************************************/

INSERT INTO Account_Type(type_id, type) VALUES (1, 'Credit');
INSERT INTO Account_Type(type_id, type) VALUES (2, 'Saving');
INSERT INTO Account_Type(type_id, type) VALUES (3, 'Checking');


INSERT INTO Person( firstname, lastname, username, password) VALUES
  ( 'Kevin','Madison','admin','pass');

select  * from person;

  
INSERT INTO Bank_Account(balance, bank_type, owner_id) VALUES (999.00, 1, 81);

select * from bank_account;
select * from account_type;


insert into bank_account(balance, bank_type, owner_id) VALUES (20.00, 1, 81);

select * from Bank_Account where owner_id = 107 and bank_type = 1;

commit;