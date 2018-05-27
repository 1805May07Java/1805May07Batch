--1.0 Setting up Oracle Chinook 
  --In this section you will begin the process of working with the Oracle 
  --Chinook database 
  --Task – Open the Chinook_Oracle.sql file and execute the scripts within. 
--2.0 SQL Queries 
  --In this section you will be performing various queries against the Oracle Chinook database. 
--2.1 SELECT Tasks
  --Select all records from the Employee table.
  SELECT * FROM EMPLOYEE;
  -- Select all records from the Employee table where last name is King. 
  SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
  -- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
  SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY Tasks 
  -- Select all albums in Album table and sort result set in descending order by title. 
  SELECT * FROM ALBUM ORDER BY TITLE DESC;
  -- Select first name from Customer and sort result set in ascending order by city 
  SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
--2.3 INSERT INTO Tasks
  --Insert two new records into Genre table 
  INSERT INTO GENRE(GENREID, NAME) VALUES (26, 'Hello');
  INSERT INTO GENRE(GENREID, NAME) VALUES (27, 'World');
  SELECT * FROM GENRE;
  --Insert two new records into Employee table 
  INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'Arbuckle', 'Jon');
  INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALuES (10, 'Kissinger', 'Henry');
  SELECT * FROM EMPLOYEE;
  --Insert two new records into Customer table 
  INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (60, 'Emi', 'Dor', 'FaSoLa@SiDo.com');
  INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (61, 'Roosevelt', 'Eleanor', 'FirstLady@WhiteHouse.gov');
  SELECT * FROM CUSTOMER;
--2.4 UPDATE Tasks
    --Update Aaron Mitchell in Customer table to Robert Walter 
    UPDATE Customer SET FIRSTNAME = 'Robert',LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
    --Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
    UPDATE Artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
    
--2.5 LIKE Tasks
    -- Select all invoices with a billing address like “T%” 
    SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN Tasks
    --Select all invoices that have a total between 15 and 50 
    SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
    --Select all employees hired between 1st of June 2003 and 1st of March 2004 
    SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('1-JUN-2003') AND TO_DATE('1-MAR-2004');
--2.7 DELETE Tasks
    --Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
    INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (0, 'N/A', 'N/A', 'N/A');
    UPDATE invoice SET customerID = 0 WHERE customerID = 32;
    DELETE Customer WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--3.0 SQL Functions 
  --In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database 
--3.1 System Defined Functions Tasks
    --Create a function that returns the current time.
    CREATE OR REPLACE FUNCTION getTime
    RETURN varchar
    IS cur_time varchar(24);
    BEGIN
      select to_char(CURRENT_TIMESTAMP, 'hh:mi:ss AM')
      INTO cur_time
      from dual;
      return cur_time;
    END;
    /
    SELECT getTime FROM DUAL;
    --Create a function that returns the length of a mediatype from the mediatype table 
    CREATE OR REPLACE FUNCTION getMediaLength(mID IN NUMBER)
    RETURN NUMBER
    IS mLength NUMBER;
       hold VARCHAR(255);
    
    BEGIN
       SELECT NAME 
       INTO hold
       FROM MEDIATYPE 
       WHERE MEDIATYPEID=mID;
       
       SELECT LENGTH(hold)
       INTO mLength
       FROM DUAL;
       
       return mLength;
    END;
    /
    SELECT GETMEDIALENGTH(2) FROM DUAL;
    /
--3.2 System Defined Aggregate Functions Tasks
    --Create a function that returns the average total of all invoices 
    CREATE OR REPLACE FUNCTION AvgTotInvoice
    RETURN NUMBER
    IS avgVal NUMBER;
    
    BEGIN
       SELECT ROUND(AVG(TOTAL), 2) 
       INTO avgVal 
       FROM INVOICE;
       
       return avgVal;
    END;
    /
    SELECT AvgTotInvoice FROM DUAL;
    
    --Create a function that returns the most expensive track 
    CREATE OR REPLACE FUNCTION PriceyTrack
    RETURN varchar
    AS pricey varchar(255);
    
    BEGIN
      SELECT TRACKID 
      INTO pricey 
      FROM (
        SELECT * FROM TRACK 
        ORDER BY UNITPRICE DESC
      ) 
      WHERE ROWNUM = 1;
      return pricey;
    END;
    /
    SELECT * FROM TRACK WHERE TRACKID=PriceyTrack;
--3.3 User Defined Functions Task

    SELECT Invoice.TOTAL FROM InvoiceLine JOIN Invoice ON InvoiceLine.INVOICEID = Invoice.INVOICEID;
    --Create a function that returns the average price of invoiceline items in the invoiceline table 
    CREATE OR REPLACE FUNCTION AvgTotInvoiceLine
    RETURN NUMBER
    IS avgVal NUMBER;
    
    BEGIN
       SELECT 
          ROUND(AVG(Invoice.Total), 2) 
       INTO avgVal 
       FROM InvoiceLine
       JOIN Invoice
       ON InvoiceLine.InvoiceID = Invoice.InvoiceID;
       
       return avgVal;
    END;
    /
    SELECT AvgTotInvoiceLine FROM DUAL;
--3.4 User Defined Table Valued Functions Task
    --Create a function that returns all employees who are born after 1968.  
    CREATE OR REPLACE FUNCTION retrieve_employees
    RETURN SYS_REFCURSOR
    IS e_cursor SYS_REFCURSOR;
    
    BEGIN
      open e_cursor FOR SELECT * FROM employee WHERE birthdate > TO_DATE('12/31/1968', 'mm/dd/yyyy');
      return e_cursor;
    END;
    
--4.0 Stored Procedures  I
  --In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters. 
--4.1 Basic Stored Procedure Task
    --Create a stored procedure that selects the first and last names of all the employees. 
    CREATE OR REPLACE PROCEDURE retrieve_names(fn_cursor OUT SYS_REFCURSOR)
    AS
    BEGIN
      open fn_cursor FOR SELECT firstname, lastname FROM employee;
    END;
    /
--4.2 Stored Procedure Input Parameters Tasks
    --Create a stored procedure that updates the personal information of an employee. 
    SELECT * FROM EMPLOYEE;
    UPDATE EMPLOYEE SET birthdate = TO_DATE('01/01/2011', 'mm/dd/yyyy') where employeeid = 1;
    
    CREATE OR REPLACE PROCEDURE update_employee(eID IN NUMBER, cName IN VARCHAR2, up IN VARCHAR2, message OUT VARCHAR2)
    IS sqlText varchar(255);

    --!!!IMPORTANT NOTE: UP SHOULD BE SET AS LITERAL ON CALLER SIDE!!! 
    --!!!BEFORE THIS FUNCTION IS CALLED TO PREVENT SQL INJECTION   !!!
    BEGIN
      IF cName IN ('employeeid', 'lastname', 'firstname', 'title', 
      'reportsto', 'birthdate', 'hirdate', 'address', 'city', 'state', 
      'country', 'postalcode', 'phone', 'fax', 'email')
        THEN  sqlText := 'UPDATE EMPLOYEE SET ' + cName + ' = ' + up 
                         + ' WHERE EMPLOYEEID = ' + eID;
              EXECUTE IMMEDIATE(sqlText);
              message := 'success';
      ELSIF cName IN ('birthdate', 'hiredate')
        THEN sqlText := 'UPDATE EMPLOYEE SET ' + cName + ' = ' + 
                         TO_DATE(up, 'mm/dd/yyyy') + ' WHERE EMPLOYEEID = ' + eID;
             EXECUTE IMMEDIATE(sqlText);
             message := 'success';
      ELSE message := 'error'; 
      END IF;
    END;
    /
    --Create a stored procedure that returns the managers of an employee. 
    
    SELECT * FROM employee;
    
    SELECT * FROM employee eA, employee eB WHERE eA.employeeid = eB.reportsto;
    
    CREATE OR REPLACE PROCEDURE retrieve_managers(fn_cursor OUT SYS_REFCURSOR)
    AS
    BEGIN
      UPDATE EMPLOYEE SET REPORTSTO = NULL WHERE EMPLOYEEID = REPORTSTO;
      open fn_cursor FOR     
        SELECT * 
        FROM employee
        START WITH employeeid = 3
        CONNECT BY NOCYCLE PRIOR reportsto = employeeid;
      UPDATE EMPLOYEE SET REPORTSTO = EMPLOYEEID WHERE REPORTSTO = null;
    END;
    /
--4.3 Stored Procedure Output Parameters Tasks
    --Create a stored procedure that returns the name and company of a customer. 
    CREATE OR REPLACE PROCEDURE return_detail(c_fname OUT VARCHAR, c_lname OUT VARCHAR, c_company OUT VARCHAR, c_id IN NUMBER)
    AS
    BEGIN
      SELECT FIRSTNAME, LASTNAME, COMPANY
      INTO c_fname, c_lname, c_company
      FROM customer
      WHERE customerID = c_id;
    END;
--5.0 Transactions Tasks 
  --In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
  --Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
  
  --Create a transaction nested within a stored procedure that inserts a new record in the Customer table  
    
--6.0 Triggers 
  --In this section you will create various kinds of triggers that work when certain DML statements are executed on a table. 
--6.1 AFTER/FOR Tasks
  --Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
  CREATE OR REPLACE TRIGGER insert_record
  AFTER INSERT ON employee
  DECLARE
    x NUMBER;
  BEGIN
    x := 1;
  END;
  /
  --Create an after update trigger on the album table that fires after a row is inserted in the table 
  CREATE OR REPLACE TRIGGER update_record
  AFTER UPDATE ON employee
  DECLARE
    x NUMBER;
  BEGIN
    x := 2;
  END;
  /
  -- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
  CREATE OR REPLACE TRIGGER delete_record
  AFTER DELETE ON employee
  DECLARE
    x NUMBER;
  BEGIN
    x := 3;
  END;
--7.0 JOINS 
  --In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins. 
--7.1 INNER Task 
  --Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
  SELECT customer.firstname, customer.lastname, invoice.invoiceID
  FROM customer
  INNER JOIN invoice
  ON customer.customerID = invoice.customerID;
  
--7.2 OUTER Task 
  --Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
  SELECT customer.customerID, customer.firstname, customer.lastname, invoice.invoiceID, invoice.total
  FROM customer
  FULL OUTER JOIN invoice
  ON customer.customerID = invoice.customerID;
  
--7.3 RIGHT Task 
  --Create a right join that joins album and artist specifying artist name and title. 
  SELECT artist.name, album.title
  FROM album
  RIGHT JOIN artist
  ON album.artistID = artist.artistID;
--7.4 CROSS Task 
  --Create a cross join that joins album and artist and sorts by artist name in ascending order. 
  SELECT *
  FROM album 
  CROSS JOIN artist 
  ORDER BY artist.name ASC;
--7.5 SELF Task 
  --Perform a self-join on the employee table, joining on the reportsto column.
  SELECT a.employeeID, a.lastName, a.firstName, a.title, a.reportsTo, b.firstName, b.lastName
  FROM employee a, employee b
  WHERE a.reportsTo = b.employeeID
  ORDER BY employeeID;
--7.6 Complicated Join assignment 
  --Create an inner join between all tables in the chinook database. 
  SELECT playListTrack.trackID AS trackID, track.name AS song, album.title AS album, playlist.name AS playlist, artist.name AS artist, 
         mediatype.name AS media, genre.name AS genre, invoiceline.quantity AS quantity, invoice.invoiceDate AS OrderDate, 
         customer.firstname AS customerName, employee.title AS customerSupport 
  FROM track
  INNER JOIN album ON album.ALBUMID = track.ALBUMID
  INNER JOIN artist ON artist.ARTISTID = album.ARTISTID
  INNER JOIN playlistTrack ON playlistTrack.TRACKID = track.TRACKID
  INNER JOIN playlist ON playlist.PLAYLISTID = playlistTrack.PLAYLISTID
  INNER JOIN mediaType ON mediaType.MEDIATYPEID = track.MEDIATYPEID
  INNER JOIN genre ON genre.GENREID = track.GENREID
  INNER JOIN invoiceLine ON invoiceLine.TRACKID = track.TRACKID
  INNER JOIN invoice ON invoice.INVOICEID = invoiceLine.INVOICEID
  INNER JOIN customer ON customer.CUSTOMERID = invoice.INVOICEID
  INNER JOIN employee ON customer.SUPPORTREPID = employee.EMPLOYEEID;
--9.0 Administration Task
  --In this section you will be creating backup files of your database. After you create the backup file you will also restore the database. 
  --Create a .bak file for the Chinook database  
 