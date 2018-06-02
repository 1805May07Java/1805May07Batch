/*
Kevin Madison
SQL: Workbook
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
from invoice
where total between 15 and 50;

--Question 2.6: Select all employees hired between 1st of June 2003 and 1st of March 2004
select *
from employee
where hiredate between '1-JUN-03' and '1-MAR-04';


--Question 2.7:Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
delete from invoice
  where customerid = (
  select customerid
  from customer
  where firstname = 'robert' and lastname = 'walter'
  );
  delete from customer
  where firstname='robert' and lastname='walter';

--TODO: FIX THIS QUESTION
--Question 3.1:  Create a function that returns the current time. 
create or replace function returnTime return timestamp
is 
  thisTime timestamp;
begin 
SELECT TO_CHAR
    (SYSDATE, ' HH24:MI:SS') "NOW"
    INTO thisTime
     FROM DUAL;
     
     return thisTime;
end;
 /
 select returnTime from dual;
 /

--Question 3.1: create a function that returns the length of a mediatype from the mediatype table 
create or replace function getMediatypeLength(
  mid in number
)
return number
is
  len number;
begin
  select length(name) into len 
  from mediatype
  where mediatypeid = mid;
  return len;
end;
/
select getMediatypeLength(4) from dual;

--Question 3.2:  Create a function that returns the average total of all invoices 
create or replace function getInvoice
return number
is
  avg number(10,2);
begin
  select avg(total) into avg
  from invoice;
  return avg;
end;
/
select getInvoice from dual;
/

--Question 3.2: Create a function that returns the most expensive track 


--Question 3.3: Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function getInvoiceAvg return number
is
  average number(10,2);
begin
  select avg(unitprice) into average
  from invoiceline;
  return average;
end;
/
select getInvoiceAvg from dual;
/

--Question 3.4: Create a function that returns all employees who are born after 1968. 


--Question 4.1:  Create a stored procedure that selects the first and last names of all the employees
create or replace procedure getNames(cursor1 out sys_refcursor)
as
begin
  open cursor1 for
  select firstname, lastname
  from employee;
end;
/

--Question 4.2: Create a stored procedure that updates the personal information of an employee. 
create or replace procedure updatePerson(
empid in number, 
fn in varchar2,
ln in varchar2
)
as
begin
  update employee
  set firstname = fn, lastname = ln
  where employeeid = empid;
end;
/

--Question 4.2:  Create a stored procedure that returns the managers of an employee. 
create or replace procedure getManagers(
empid in number,
cursor1 out sys_refcursor
)
as
begin
  open cursor1 for
  select * from employee
  where employeeid = (
    select reportsto
    from employee
    where employeeid = empid
  );
end;
/

--Question 4.3: Create a stored procedure that returns the name and company of a customer. 
create or replace procedure customerinfo(
cusid in number,
cursor1 out sys_refcursor
)
as
begin
  open cursor1 for
  select * 
  from customer
  where customerid = cusid;
end;
/


--Question 5.0: Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure deleteInvoice(
  invid in number
)
as
begin
  delete from invoiceline
  where invoiceid = invid;
  
  delete from invoice
  where invoiceid = invid;
  commit;
end;
/

--Question 5.0: Create a transaction nested within a stored procedure that inserts a new record in the Customer table 
create or replace procedure insertCustomer(
  fn in varchar2,
  ln in varchar2,
  cus_email in varchar2
)
as
begin
  insert into customer (firstname, lastname, email) values (fn, ln, cus_email);
  commit;
end;
/

--Question 6.1: Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger insertEmployee
after insert
on employee
for each row
begin
  dbms_output.put_line('new employee inserted');
end;
/

--Question 6.1: Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger updateAlbum
after update
on album
for each row
begin
  dbms_output.put_line('album updated');
end;
/

--Question 6.1: Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger deleteCustomer
after delete
on customer
for each row
begin
  dbms_output.put_line('customer deleted');
end;
/

--Question 7.1:  Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
select c.firstname, c.lastname, i.invoiceid
from customer c inner join invoice i
on c.customerid = i.customerid
order by c.lastname asc;

--TODO returns null values for some reason....
--Question 7.2: Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c full outer join invoice i
on c.customerid = i.invoiceid;

--Question 7.3: Create a right join that joins album and artist specifying artist name and title. 
select art.name, alb.title
from artist art right join album alb
on art.artistid = alb.artistid
order by art.name asc;

--Question 7.4: Create a cross join that joins album and artist and sorts by artist name in ascending order. 
select art.name, alb.title
from album alb
cross join artist art
order by art.name asc;

--Question 7.5: Perform a self-join on the employee table, joining on the reportsto column.
select x.firstname, x.lastname
from employee x, employee y
where x.reportsto = y.reportsto
order by lastname asc;

--Question 7.6: Create an inner join between all tables in the chinook database.
