
CREATE TABLE Users (
  user_id integer not null,
  is_Admin integer default 0,
  email varchar2(25) not null unique,
  firstname varchar2(25) not null,
  lastname varchar2(25) not null,
  pass varchar2(25) not null,
  primary key (user_id)
);

CREATE TABLE Accounts (
  acc_id integer,
  acc_type number(1),
  balance decimal(10,2) default 0,
  primary key (acc_id)
);

CREATE TABLE Accounts_Users (
    user_id int NOT NULL,
    acc_id int NOT NULL,
    CONSTRAINT PK_Accounts_Users PRIMARY KEY (user_ID, acc_id),
    FOREIGN KEY (User_ID) REFERENCES Users (user_ID) ON DELETE CASCADE,
    FOREIGN KEY (Acc_ID) REFERENCES Accounts (acc_id) ON DELETE CASCADE
);

--resetting data
drop table accounts_users;

truncate table users;

truncate table accounts;

CREATE TABLE Accounts_Users (
    user_id int NOT NULL,
    acc_id int NOT NULL,
    CONSTRAINT PK_Accounts_Users PRIMARY KEY (user_ID, acc_id),
    FOREIGN KEY (User_ID) REFERENCES Users (user_ID) ON DELETE CASCADE,
    FOREIGN KEY (Acc_ID) REFERENCES Accounts (acc_id) ON DELETE CASCADE
);

drop sequence user_id_seq;

create sequence user_id_seq
start with 1
increment by 1;

drop sequence acc_id_seq;

create sequence acc_id_seq
start with 1
increment by 1;

--test data
call new_user('avons394@gmail.com', 'Alex', 'vonStuelpnagel', 'p4ssw0rd', 0);

call new_user('lvons394@gmail.com', 'Lalex', 'vonStuelpnagel', 'p4ssw0rd', 1);

call new_user('bvons394@gmail.com', 'Balex', 'vonStuelpnagel', 'p4ssw0rd', 2);

--f user is test from java
DELETE FROM users WHERE firstname = 'f';
commit;

---------------------------------------------------------------------------------
--sequences
create sequence user_id_seq
start with 1
increment by 1;
/
create or replace trigger user_id_seq_trigger
before insert on users -- when is it happening
for each row -- how often
begin
    -- where meat of trigger resides
    select user_id_seq.nextVal into :new.user_id from dual;
end;
/

create sequence acc_id_seq
start with 1
increment by 1;
/
create or replace trigger acc_id_seq_trigger
before insert on accounts -- when is it happening
for each row -- how often
begin
    -- where meat of trigger resides
    select acc_id_seq.nextVal into :new.acc_id from dual;
end;
/
------------------------------------------------------------------------------------------
--procedures

--on create user, create account and link in juction table accounts_users
CREATE OR REPLACE PROCEDURE new_user(email varchar2, firstname varchar2, lastname varchar2, pass varchar2)
AS
BEGIN
  INSERT INTO users(email, firstname, lastname, pass) VALUES(email, FIRSTNAME, LASTNAME, PASS);
  insert into ACCOUNTS(acc_type) values (0);
  insert into ACCOUNTS_USERS values(user_id_seq.currval, acc_id_seq.currval);
  COMMIT;
END;

CREATE OR REPLACE PROCEDURE new_account(userid number, accountType number)
AS
BEGIN
  insert into ACCOUNTS(acc_type) values (accountType);
  insert into ACCOUNTS_USERS values(userid, acc_id_seq.currval);
  COMMIT;
END;


