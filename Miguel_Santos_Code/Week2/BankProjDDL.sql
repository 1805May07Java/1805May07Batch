create table bankuser
(
  user_id number(10) primary key,
  firstname varchar2(15) not null,
  lastname varchar2(16) not null,
  username varchar2(16) unique not null,
  credential varchar2(32) not null
);

create table useraccount
(
  acct_num number(10) primary key,
  balance number(11,2),
  acct_id number(1) not null,
  user_id number(10),
  constraint fk_acct_user foreign key (user_id) references bankuser(user_id),
  constraint fk_acct_type foreign key (acct_id) references acct_table(acct_id)
);

create table acct_table
(
  acct_id number(1) primary key,
  acct_name varchar2(15)
);

insert into acct_table(acct_id, acct_name) values(1, 'Savings');
insert into acct_table(acct_id, acct_name) values(2, 'Checkings');
insert into acct_table(acct_id, acct_name) values(3, 'Credit');

/*create table user_account
(
  user_id number(10),
  acct_num number(10),
  constraint user_acct_pk primary key (user_id, acct_num),
  constraint fk_user foreign key (user_id) references bankuser (user_id),
  constraint fk_acct foreign key (acct_num) references useraccount (acct_num)
);*/

--SEQUENCES--

create sequence bankuser_seq
start with 11001
increment by 373;

create sequence useracct_seq
start with 100
increment by 27;

--TRIGGERS--
create or replace trigger bankuser_seq_trigger
before insert on bankuser
for each row
begin
  select bankuser_seq.nextval into :new.user_id from dual;
end;
/
create or replace trigger useracct_seq_trigger
before insert on useraccount
for each row
begin
  select useracct_seq.nextval into :new.acct_num from dual;
end;
/

--STORED PROC---
create or replace procedure update_user_pw(usrid in number, usrpw in varchar2)
is
begin
  update bankuser set credential = usrpw where user_id = usrid;
end;
/



