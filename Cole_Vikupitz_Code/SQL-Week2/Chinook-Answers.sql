/*
 * Chinook.sql
 * Author: Cole Vikupitz
 *
 * Answers for Revature Associate SQL Workbook
 */


/*
 * 2.0 - SQL Queries
 */
-- 2.1 - SELECT
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE
  WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE
  WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

-- 2.2 - ORDER BY
SELECT * FROM ALBUM
  ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER
  ORDER BY FIRSTNAME ASC;

-- 2.3 - INSERT INTO
INSERT INTO GENRE VALUES (26, 'Action');
INSERT INTO GENRE VALUES (27, 'Tragedy');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, EMAIL)
  VALUES (9, 'Lincoln', 'Abraham', 'Banker', 'g.washington@gmail.com');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, EMAIL)
  VALUES (10, 'Washington', 'George', 'Consultant', 'abe.lincoln@gmail.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
  VALUES (60, 'Abraham', 'Lincoln', 'g.washington@gmail.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
  VALUES (61, 'George', 'Washington', 'abe.lincoln@gmail.com');

-- 2.4 - UPDATE
UPDATE CUSTOMER
  SET FIRSTNAME='Robert', LASTNAME='Walter'
  WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST
  SET NAME='CCR'
  WHERE NAME='Creedence Clearwater Revival';

-- 2.5 - LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 - BETWEEN
SELECT * FROM INVOICE
  WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE
  WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';

-- 2.7 - DELETE
DELETE FROM CUSTOMER
  WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

/*
 * 3.0 - SQL Functions
 */
-- 3.1 - System Defined Funtions
-- Return the current timestamp
SELECT CURRENT_TIMESTAMP FROM DUAL;

-- Return length of mediatype by ID
SELECT LENGTH(MEDIATYPEID) FROM MEDIATYPE
  WHERE MEDIATYPEID = 1;

-- 3.2 - System Defined Aggregate Functions
-- Get average of invoices
SELECT AVG(INVOICE.TOTAL) FROM INVOICE;

-- Get most expensive track record
SELECT MAX(UNITPRICE) FROM TRACK;

-- 3.3 - User Defined Functions
-- Returns the average of all invoices
CREATE OR REPLACE FUNCTION getInvoiceAverage RETURN FLOAT
IS
  average FLOAT;
BEGIN
  SELECT AVG(INVOICE.TOTAL) INTO average FROM INVOICE;
  RETURN average;
END;
/
-- Test the function
SELECT getInvoiceAverage FROM DUAL;
/

-- 3.4 - User Defined Table Valued Functions
-- Return all employee records born after 1968
CREATE OR REPLACE PROCEDURE getAllAfter1968(
  cursorParam OUT SYS_REFCURSOR
) IS
BEGIN
  OPEN cursorParam FOR
  SELECT * FROM EMPLOYEE
  WHERE BIRTHDATE >= '12-31-1968';
END;

/


/*
 * 4.0 - Stored Procedures
 */
-- 4.1 - Basic Stored Procedure
-- Selects first and last names of all employees
CREATE OR REPLACE PROCEDURE getAllNames(
  cursorParam OUT SYS_REFCURSOR
) IS
BEGIN
  OPEN cursorParam FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

/

-- 4.2 - Stored Procedure Input Parameters
-- Updates employee information
CREATE OR REPLACE PROCEDURE updateEmployee(
  e_id IN NUMBER,
  fname IN VARCHAR2,
  lname IN VARCHAR2
) IS
BEGIN
  UPDATE EMPLOYEE
  SET FIRSTNAME = fname, LASTNAME = lname
  WHERE EMPLOYEEID = e_id;
END;

/

-- Get all managers for an employee
CREATE OR REPLACE PROCEDURE getManagers(
  cursorParam OUT SYS_REFCURSOR,
  e_id IN NUMBER
) IS
BEGIN
  OPEN cursorParam FOR SELECT * FROM EMPLOYEE
  WHERE REPORTSTO = c_id;
END;

/

-- 4.3 - Stored Procedure Output Parameters
-- Selects first and last names of all employees
CREATE OR REPLACE PROCEDURE getNameCompany(
  cursorParam OUT SYS_REFCURSOR,
  c_id IN NUMBER
) IS
BEGIN
  OPEN cursorParam FOR SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
  WHERE CUSTOMERID = c_id;
END;
/

/*
 * 5.0 - Transactions
 */


/*
 * 6.0 - Triggers
 */
-- 6.1 - AFTER/FOR


/*
 * 7.0 - Joins
 */
-- 7.1 - INNER
SELECT cst.FIRSTNAME, cst.LASTNAME, inv.INVOICEID
  FROM CUSTOMER cst INNER JOIN INVOICE inv
  ON cst.CUSTOMERID = inv.CUSTOMERID
  ORDER BY cst.LASTNAME ASC;

-- 7.2 - OUTER
SELECT cst.CUSTOMERID, cst.FIRSTNAME, cst.LASTNAME, inv.INVOICEID, inv.TOTAL
  FROM CUSTOMER cst FULL OUTER JOIN INVOICE inv
  ON cst.CUSTOMERID = inv.INVOICEID;

-- 7.3 - RIGHT
SELECT ats.NAME, alb.TITLE
  FROM ARTIST ats RIGHT JOIN ALBUM alb
  ON ats.ARTISTID = alb.ARTISTID
  ORDER BY ats.NAME ASC;

-- 7.4 - CROSS
SELECT art.NAME, alb.TITLE FROM ALBUM alb
  CROSS JOIN ARTIST art
  ORDER BY art.NAME ASC;

-- 7.5 - SELF
SELECT A.LASTNAME, A.FIRSTNAME FROM EMPLOYEE A, EMPLOYEE B
  WHERE A.REPORTSTO = B.REPORTSTO
  ORDER BY LASTNAME ASC;

-- 7.6 - Complicated Join assignment
CREATE VIEW joinsview AS 
SELECT al.TITLE AS album, art.NAME AS artist,
  tr.name AS track, g.NAME AS genre, pl.NAME AS playlist, inv.TOTAL
  FROM ALBUM al
JOIN ARTIST art ON art.artistid = al.artistid
JOIN TRACK tr ON tr.ALBUMID = al.ALBUMID
JOIN GENRE g ON g.GENREID = tr.GENREID
JOIN PLAYLISTTRACK plt ON plt.TRACKID = tr.trackid
JOIN PLAYLIST pl ON pl.PLAYLISTID = plt.PLAYLISTID
JOIN INVOICELINE inl ON inl.TRACKID = tr.TRACKID
JOIN INVOICE inv ON inl.INVOICEID = inv.INVOICEID
JOIN MEDIATYPE mt ON mt.MEDIATYPEID = tr.MEDIATYPEID
JOIN CUSTOMER cust ON cust.CUSTOMERID = inv.CUSTOMERID
JOIN EMPLOYEE emp ON emp.EMPLOYEEID = cust.SUPPORTREPID;
/
