/************************************************************
*           Nathan Ashcroft                                 *
*************************************************************/

--Problem 2.1 SELECT

SELECT * FROM Employee;
SELECT * FROM Employee WHERE LASTNAME = 'King';
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS null;

--Problem 2.2 ORDER BY

SELECT  * FROM album ORDER BY TITLE DESC;
SELECT firstname FROM Customer ORDER BY city;

--Problem 2.3 Insert Into

INSERT INTO genre(GENREID, NAME) VALUES (26, 'PunkPop');
INSERT INTO genre VALUES (27, 'PopRock');

INSERT INTO employee VALUES (9, 'Ashcroft', 'Nathan', 'God','', 
TO_DATE('1984-10-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-7 00:00:00','yyyy-mm-dd hh24:mi:ss'),
'3263 N Mountainview', 'Chewelah', 'WA', 'USA', 99109, 9512015019, 9512016019, 'n.ashcroft42@gmail.com');

INSERT INTO employee VALUES (10, 'Ashcroft', 'LeeAnne', 'God','', 
TO_DATE('1984-10-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-7 00:00:00','yyyy-mm-dd hh24:mi:ss'),
'3263 N Mountainview', 'Chewelah', 'WA', 'USA', 99109, 9512015019, 9512016019, 'n.ashcroft42@gmail.com');

INSERT INTO Customer VALUES (60, 'Nathan', 'Ashcroft', 'Revature', 'N Mountainview rd, 3263',
'Chewelah', 'WA', 'USA', '99109', '9512015019', '+9512015019', 'n.ashcroft42@gmail.com', 1);

INSERT INTO Customer VALUES (61, 'LeeAnne', 'Ashcroft', 'Revature', 'N Mountainview rd, 3263',
'Chewelah', 'WA', 'USA', '99109', '9512015019', '+9512015019', 'n.ashcroft42@gmail.com', 1);

--Problem 2.4 UPDATE

UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--Problem 2.5 LIKE

Select * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--Problem 2.6 Between

Select * FROM invoice  WHERE TOTAL BETWEEN 15 AND 50;
Select * FROM EMPLOYEE WHERE HIREDATE BETWEEN to_date('01-JUN-03','DD-MON-YY') AND to_date('01-MAR-04','DD-MON-YY');

--Problem 2.9 Delete
delete from (
  select *
  from   Customer join
         invoice      on (Customer.CUSTOMERID = invoice.CUSTOMERID) join
         INVOICELINE on (INVOICELINE.INVOICEID = invoice.INVOICEID)
  where  Customer.FIRSTNAME = 'Robert' AND lastname='Walter');
  
  delete from (
  select *
  from   Customer join
         invoice      on (Customer.CUSTOMERID = invoice.CUSTOMERID) 
  where  Customer.FIRSTNAME = 'Robert' AND lastname='Walter');

Delete from Customer where firstname='Robert' AND lastname='Walter';

--Problem 3.1 System Defined Functions
CREATE OR REPLACE FUNCTION gettimestmp
return TIMESTAMP
is len TIMESTAMP;
begin
select LOCALTIMESTAMP into len from dual;
return len;
end; /

CREATE OR REPLACE FUNCTION getlength
return number
is x number;
begin 
select LENGTH('mediatype')into x from mediatype;
return x;
end; /

--Problem 3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION getavg
return number
is x number;
begin 
select avg(total) into x from invoice;
return x;
end; /

CREATE OR REPLACE FUNCTION getmax
return number
is x number;
begin 
select max(unitprice) into x from track;
return x;
end; /

--Problem 3.3 User Defined Functions
CREATE OR REPLACE FUNCTION getavgunit
return number
is x number;
begin 
select avg(unitprice) into x from invoiceline;
return x;
end; /

--Problem 3.4  User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION getDB
return SYS_REFCURSOR 
as my_cursor SYS_REFCURSOR;
begin
open my_cursor for SELECT * FROM employee WHERE to_number (to_char( employee.birthdate, 'YYYY')) > 1968; 
return my_cursor;
end getDB; /

--Problem 4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE getnames(
  cursorParam OUT SYS_REFCURSOR)
  is
  begin
   open cursorParam for select firstname, lastname from employee;
  end; /

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE updateEmp(
	   emp_id IN number, lname IN VARCHAR2,
     fname IN VARCHAR2, tit IN VARCHAR2,
     repto IN number, db IN date, hd IN date,
     addr IN VARCHAR2, cit IN VARCHAR2,
     st IN VARCHAR2, ctry IN VARCHAR2,
     zip IN VARCHAR2, pho IN VARCHAR2,
     fx IN VARCHAR2, eml IN VARCHAR2)
IS
BEGIN
  UPDATE EMPLOYEE SET LASTNAME=lname,
                      FIRSTNAME=fname,
                      TITLE=tit,
                      REPORTSTO=repto,
                      BIRTHDATE=db,
                      HIREDATE=hd,
                      ADDRESS=addr,
                      CITY=cit,
                      STATE=st,
                      COUNTRY=ctry,
                      POSTALCODE=zip,
                      PHONE=pho,
                      FAX=fx,
                      EMAIL=eml
                      WHERE EMPLOYEEID=emp_id;
  COMMIT;
END; /

CREATE OR REPLACE PROCEDURE EmpMan(
	   emp_id IN number, man OUT number)
IS
BEGIN
select reportsto into man from employee where employeeid=emp_id;
end;  /


--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE custInfo(
	   cust_id IN number, n OUT number, com OUT NUMBER)
IS
BEGIN
select firstname into n from CUSTOMER where CUSTOMERID=cust_id;
select company into n from CUSTOMER where CUSTOMERID=cust_id;
end;  /

--5.0 Transactions
CREATE OR REPLACE PROCEDURE delInvoice(invoice_id IN number)
IS
BEGIN
delete from (
  select *
  from   invoice join
         invoiceline      on (invoice.invoiceID = invoiceline.invoiceID) 
  where  invoice.invoiceid = invoice_id);
  
  delete from invoice where invoice.invoiceid = invoice_id;
  commit;
end;  /
  
CREATE OR REPLACE PROCEDURE updteCust(
                CUSTID IN number,
                fname IN VARCHAR2,
                lname IN VARCHAR2,
                COMP IN VARCHAR2,
                ADDr IN VARCHAR2,
                CIT IN VARCHAR2,
                STAT IN VARCHAR2,
                Ctry IN VARCHAR2,
                zip IN VARCHAR2,
                Pn IN VARCHAR2,
                Fx IN VARCHAR2,
                Eml IN VARCHAR2,
                SUPID IN VARCHAR2)
IS
BEGIN
insert into customer values (CUSTID, fname, lname, COMP, ADDr, CIT, STAT, Ctry, zip, Pn, Fx, Eml, SUPID);
commit;
end; /

--6.1 AFTER/FOR
create or replace trigger fired_trigger
AFTER INSERT on employee
for each row
Begin
  if (1 = 1) then
DBMS_OUTPUT.put_line('do Something with employee');
else
DBMS_OUTPUT.put_line('do Something else with employee');
end if;
end;  /

create or replace trigger fired_trigger_album
AFTER INSERT on album
for each row
Begin
  if (1 = 1) then
DBMS_OUTPUT.put_line('do Something with album');
else
DBMS_OUTPUT.put_line('do Something else with album');
end if;
end;  /

create or replace trigger del_trigger_cust
AFTER Delete on customer
for each row
Begin
DBMS_OUTPUT.put_line('customer deleted succsessfully');
end;  /

--7.1 INNER Join
select customer.FIRSTNAME as Name, invoice.INVOICEID as orders
from customer
inner join invoice
on customer.CUSTOMERID = invoice.CUSTOMERID;

--7.2 OUTER Join
select c. customerid as id, c.FIRSTNAME, c.lastname, i.INVOICEID as orders, i.total
from customer c
full outer join invoice i
on c.CUSTOMERID = i.CUSTOMERID;

--7.3 RIGHT join
SELECT artist.NAME,  album.TITLE
FROM album
RIGHT JOIN artist ON album.ARTISTID = artist.ARTISTID;

--7.4 CROSS Join
SELECT * 
FROM album 
CROSS JOIN artist 
Order by artist.NAME ASC;


