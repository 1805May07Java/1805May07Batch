/*
David SQL Workbook
*/

/* 2.1 SELECT */
-- Select all records from the Employee table.
select * from EMPLOYEE;

-- Select all records from the Employee table where last name is King.
select * from EMPLOYEE where LASTNAME = 'King';

-- – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from EMPLOYEE where FIRSTNAME = 'Andrew' and REPORTSTO is null;

/* 2.2 ORDER BY */
-- Select all albums in Album table and sort result set in descending order by title. 
select * from ALBUM order by TITLE desc;

-- Select first name from Customer and sort result set in ascending order by city
select FIRSTNAME from CUSTOMER order by CITY asc;

/* 2.3 INSERT INTO */
-- Insert two new records into Genre table

insert into GENRE values (26, 'Disco');
insert into GENRE values (27, 'Psychedelic Rock');

-- Insert two new records into Employee table
insert into EMPLOYEE values (9, 'Lichaa', 'David', 'Full Stack Developer', 1, TO_DATE('1995-7-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-07 00:00:00','yyyy-mm-dd hh24:mi:ss'), '4841 Meadowlark Ln', 'Waldorf', 'MD', 'USA', '20603', '+1 (301) 357-5880', '+1 (301) 555-0101', 
'davidlichaa@gmail.com');

insert into EMPLOYEE values (10, 'James', 'LeBron', 'Athletic Consultant', 1, TO_DATE('1984-12-30 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-07 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1 Center Ct', 'Cleveland', 'OH', 'USA', '44115', '+1 (216) 420-2000', '+1 (216) 420-2000', 
'ljames@cavs.com');

-- Insert two new records into Customer table

INSERT INTO Customer values (59, 'Tom', 'Brady', 'New England Patriots', '1 Patriot Pl', 'Foxborough', 'USA', '02035', '+1 (508) 543-8200', '+55 (12) 3923-5566', 'tbrady@patriots.com', 3);
INSERT INTO Customer values (60, 'Alexander', 'Ovechkin', 'Washington Capitals', '601 F St NW', 'Washington DC', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);

/* 2.4 UPDATE */

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET firstname = 'Aaron', lastname = 'Mitchell' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET name = 'CCR' where name = 'Creedence Clearwater Revival';

/* 2.5 LIKE */
-- Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

/* 2.6 BETWEEN */
-- Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between TO_DATE('2003-5-1 ','yyyy-mm-dd ') and TO_DATE('2004-3-1', 'yyyy-mm-dd');

/* 2.7 DELETE */
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints
-- that rely on this, find out how to resolve them).
delete from customer where firstname = 'Robert' and lastname = 'Walter';

/* 3.1 SYSTEM DEFINED FUNCTIONS */
-- Create a function that returns the current time.
create or replace function get_time
RETURN varchar2 is
  time_now varchar2(256);
begin
select sysdate into time_now from dual;
return time_now;
end;
/

declare 
time_now varchar2(256);
begin
time_now := get_time();
dbms_output.put_line(time_now);
end;
/
-- create a function that returns the length of a mediatype from the mediatype table
create or replace function get_mediatype_length (id_in in number)
return number is
  leng number(10);
begin 
  select length(NAME) into leng from mediatype where mediatypeid = id_in;
  return leng;
  end;
  
/
begin 
  dbms_output.put_line(get_mediatype_length(2));
end;
/
/* 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS */
-- Create a function that returns the average total of all invoices

create or replace function get_average_invoice_total 
  return decimal is
  average decimal(20);
begin
 select avg(total) into average from invoice;
 return average;
end;
/

begin
  dbms_output.put_line(get_average_invoice_total);
end;
/

-- Create a function that returns the most expensive track
create or replace function get_max_track_price
  return decimal is
  most_exp decimal(30);
begin
  select max(total) into most_exp from invoice;
  return most_exp;
end;
/

begin 
  dbms_output.put_line(get_max_track_price);
end;
/ 
select max(total) from invoice;

/* 3.3 USER DEFINED FUNCTIONS */
-- Create a function that returns the average price of invoiceline items in the invoiceline table

create or replace function get_average_invoiceline
  return decimal is
  avg_voiceline decimal(20);
begin
  select avg(unitprice) into avg_voiceline from invoiceline;
  return avg_voiceline;
end;
/

begin
  dbms_output.put_line(get_average_invoiceline);
end;
/

select avg(unitprice) from invoiceline;
/
/* 4.1 BASIC STORED PROCEDURE */
create or replace procedure select_names
  (employees out sys_refcursor)
is
begin
open employees for
  select firstname, lastname from employee;
end;
/


/* 4.2 STORED PROCEDURE INPUT PARAMETERS */
--  Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure update_emp(
  e_id in number, new_name in varchar2)
  is
  begin
    update employee set firstname = new_name where
    employeeid = e_id;
  end;
  /
-- Create a stored procedure that returns the managers of an employee.
create or replace procedure managers_of_emp(
  e_id in number, managers out sys_refcursor)
  is
  begin
  open managers for
  select reportsto from employee where employeeid = e_id;
  end;
