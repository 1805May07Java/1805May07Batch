insert into bankuser(firstname, lastname, username, credential) values('Krystal', 'Lubi', 'klubi', 'zotzot');
commit;

insert into useraccount(balance, acct_id, user_id) values(27000.52, 1, 11374);
commit;

select * from bankuser where username = 'solrock92';

select count(*) from useraccount where user_id = 11374;

--for getAcctBal (all)
select acct_table.acct_name, useraccount.balance from useraccount inner join acct_table on useraccount.acct_id = acct_table.ACCT_ID where useraccount.USER_ID = 11374 order by acct_table.ACCT_ID asc;

select balance from useraccount where user_id = 11374 and acct_id = 1;

select count(*) from bankuser where username = 'solrock92' and credential = 'kobe';

select user_id from bankuser where username = 'solrock92';

update useraccount set balance = 1600.69 where user_id = 11001 and acct_id = 1;

update bankuser set credential = 'zootzoot' where user_id = 11374;