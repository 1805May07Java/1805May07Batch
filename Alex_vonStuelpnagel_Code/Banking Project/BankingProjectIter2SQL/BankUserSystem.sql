CREATE TABLE Users (
  userid integer not null,
  isAdmin integer default 0,
  email varchar2(25) not null,
  firstname varchar2(25) not null,
  lastname varchar2(25) not null,
  pass varchar2(25) not null,
  primary key (userid)
);

CREATE TABLE Accounts (
  acc_id integer,
  acc_type integer,
  balance decimal(10,2) default 0,
  primary key (acc_id)
);

CREATE TABLE Accounts_Users (
    userid int NOT NULL,
    acc_id int NOT NULL,
    CONSTRAINT PK_Accounts_Users PRIMARY KEY (userID, acc_id),
    FOREIGN KEY (UserID) REFERENCES Users (userID),
    FOREIGN KEY (Acc_ID) REFERENCES Accounts (acc_id)
);
/

insert into Users (userid, email, firstname, lastname, pass)
values (0, 'avons394@gmail.com', 'Alex', 'vonStuelpnagel', 'p4ssw0rd');

insert into Accounts (acc_id, acc_type)
values (0, 1);

commit;

select value from v$parameter where name='service_names';