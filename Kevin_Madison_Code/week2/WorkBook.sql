/*
Kevin  SQL: Workbook

*/

--Question 2.1: Select all records from the Employee table.
select * 
from Employee;

--Question 2.1: Select all records from the Employee table where last name is King. 
select * 
from Employee 
where LASTNAME = 'King';

--Question 2.1: Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
select *
from Employee
where FIRSTNAME = 'Andrew' and REPORTSTO IS NULL;

--Question 2.2: Select all albums in Album table and sort result set in descending order by title. 
select *
from Album
order by title desc;

--Question 2.2: Select first name from Customer and sort result set in ascending order by city 
select firstname
from Customer
order by city asc;

--Question 2.3: Insert two new records into Genre table 
INSERT INTO Genre (GenreId, Name) VALUES (26, 'KPop');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Soft Rock');

--Question 2.3: Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Bob', 'Bob', 'Janitor', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'bob@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Oppsie', 'Daisey', 'CEO', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');

  
--Question 2.3:Insert two new records into Customer table 
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Bob', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'Tom', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

--Question 2.4: Update Aaron Mitchell in Customer table to Robert Walter 
update customer
  set firstname = 'Robert',
    lastname = 'Walter'
  where firstname = 'Aaron' and lastname = 'Mitchell';

--Question 2.4: Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update Artist
  set name = 'CCR'
  where name = 'Creedence Clearwater Revival';

--Question 2.5:  Select all invoices with a billing address like “T%” 
select *
from invoices
where "T%" like billing_address;

--Question 2.6: Select all invoices that have a total between 15 and 50 
select *
from invoices
where total between 15 and 50;

--Question 2.6: Select all employees hired between 1st of June 2003 and 1st of March 2004
--select *
--from employees
--where hired between ;


--Question 2.7:Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)



