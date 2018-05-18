SET SERVEROUTPUT ON;
/* 1.Select all records from the Employee table */
/*2.1 SELECT */
--Select all records from the Employee table.
SELECT * FROM EMPLOYEE ;
--Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME LIKE '%King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME LIKE 'Andrew' AND REPORTSTO is NULL;
/*2.2 ORDER BY*/
--Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC; 
--Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER ORDER by CITY ASC;

/*2.3 INSERT INTO*/
--Insert two new records into Genre table
INSERT INTO GENRE ( GENREID, NAME) VALUES (26,'Funk');
--Insert two new records into Employee table
INSERT INTO EMPLOYEE ( EMPLOYEEID, LASTNAME,FIRSTNAME)  VALUES  
                     (9,'Fred','Smith');
INSERT INTO EMPLOYEE ( EMPLOYEEID, LASTNAME,FIRSTNAME)  VALUES  
                     (10,'Willma','Jones');                 
--Insert two new records into Customer table
INSERT INTO  CUSTOMER  (CUSTOMERID,FIRSTNAME,LASTNAME,SUPPORTREPID)  
VALUES (60,"Ed","Hawkins",8);
INSERT INTO  CUSTOMER  (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL)  
VALUES (61,"Tom","Brown","Tom.Brown@gjghj.com" );

--Update Aaron Mitchell in Customer table to Robert Walter
Update Customer SET FIRSTNAME='Robert',LASTNAME='Walter' where FIRSTNAME='Aaron'  ;
Select * From Customer where CUSTOMERID=32;
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
Select * FROM ARTIST where NAME='Creedence Clearwater Revival';
Update Artist SET NAME='CCR' where NAME='Creedence Clearwater Revival';
Select * FROM ARTIST where ARTISTID=76;
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
Select * FROM INVOICE where BILLINGADDRESS like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
Select Count(TOTAL) FROM INVOICE Where TOTAL>15 and TOTAL<50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
Select *  FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-JUN-03','DD-MON-YY') AND TO_DATE('01-MAR-04','DD-MON-YY');
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
Select Sysdate from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
Select LENGTH(NAME) from MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select AVG(TOTAL) FROM INVOICE;
--Task – Create a function that returns the most expensive track
select MAX(UNITPRICE) From TRACK;
--3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select Avg(UNITPRICE) from INVOICELINE Group BY INVOICEID ;  
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  EID NUMBER;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO EID,FIRSTNAME, LASTNAME;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME);
  END LOOP;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace PROCEDURE EMPLOYEE_INFO(JUSTIN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN JUSTIN_CURSOR FOR SELECT EMPLOYEEID,FIRSTNAME, LASTNAME,EMAIL FROM EMPLOYEE;
END;
/
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  EID NUMBER;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
  EMAIL VARCHAR2(60);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO EID,FIRSTNAME, LASTNAME, EMAIL;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME|| ',' || EMAIL);
  END LOOP;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
 
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database
 