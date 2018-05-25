--Task – Select all records from the Employee table. 
select * from employee;
--Task – Select all records from the Employee table where last name is King. 
select * from employee where lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
select * from employee where firstname = 'Andrew' AND reportsto IS NULL;
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city 
select firstname from customer order by city;
--Task – Insert two new records into Genre table 
insert into genre (genreid, name) VALUES(26, 'Experimental');
insert into genre (genreid, name) VALUES(27, 'Ambience');
--Task – Insert two new records into Employee table 
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
  VALUES(9, 'Ly', 'Calvin', 'Software Developer', null, '15-NOV-1992', '1-JAN-2018', 'test_address', 'Brooklyn', 'NY', 'United States', '11111', '+1 (123) 456 7890', '123456789','test@testmail.com');
insert into employee VALUES (10, 'Test2', 'Test1');
--Task – Insert two new records into Customer table 
insert into customer(CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES
  (60, 'Calvin', 'Ly', 'test@testmail.com');
insert into customer VALUES (61, 'Test1', 'Test2', 'test@testmail.com');
--Task – Update Aaron Mitchell in Customer table to Robert Walter 
update customer set firstname ='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
update artist set name = 'CCR' where name='Creedence Clearwater Revival';
--Task – Select all invoices with a billing address like “T%” 
select * from invoice where billingaddress LIKE 'T%';
--Task – Select all invoices that have a total between 15 and 50 
select * from invoice where total between 15 AND 30;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
select * from employee where hiredate between '1-JUN-2003' AND '1-MAR-2004';
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). 
