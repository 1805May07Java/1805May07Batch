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
DELETE FROM INVOICE
  WHERE CUSTOMERID = (
    SELECT CUSTOMERID FROM CUSTOMER
    WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'
  );
DELETE FROM CUSTOMER
  WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';


/*
 * 3.0 - SQL Functions
 */
-- 3.1 - System Defined Funtions
-- Return the current timestamp
CREATE OR REPLACE FUNCTION getCurrentTime RETURN TIMESTAMP
IS
  ctime TIMESTAMP;
BEGIN
  SELECT CURRENT_TIMESTAMP INTO ctime FROM DUAL;
  RETURN ctime;
END;
/
SELECT getCurrentTime FROM DUAL;
/

-- Return length of mediatype by ID
CREATE OR REPLACE FUNCTION getMediaTypeLength(mid IN NUMBER)
RETURN NUMBER
IS
  len NUMBER;
BEGIN
  SELECT LENGTH(NAME) INTO len FROM MEDIATYPE
  WHERE MEDIATYPEID = mid;
  RETURN len;
END;
/
SELECT getMediaTypeLength(1) FROM DUAL;
/

-- 3.2 - System Defined Aggregate Functions
-- Return average of invoices
CREATE OR REPLACE FUNCTION getInvoiceAvg RETURN NUMBER
IS
  average NUMBER(10, 2);
BEGIN
  SELECT AVG(TOTAL) INTO average FROM INVOICE;
  RETURN average;
END;
/
SELECT getInvoiceAvg FROM DUAL;
/

-- Get most expensive track record
CREATE OR REPLACE FUNCTION mostExpTrack RETURN SYS_REFCURSOR
IS
  maxpr Number(10, 2);
  t_cursor SYS_REFCURSOR;
BEGIN
  SELECT MAX(UNITPRICE) INTO maxpr FROM TRACK;
  OPEN t_cursor FOR
  SELECT * FROM TRACK
  WHERE UNITPRICE >= maxpr;
  RETURN t_cursor;
END;
/
SELECT mostExpTrack FROM DUAL;

-- 3.3 - User Defined Functions
-- Returns the average of all invoicelines
CREATE OR REPLACE FUNCTION getInvoiceLineAvg RETURN NUMBER
IS
  average NUMBER(10, 2);
BEGIN
  SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE;
  RETURN average;
END;
/
SELECT getInvoiceLineAvg FROM DUAL;
/

-- 3.4 - User Defined Table Valued Functions
-- Return all employee records born after 1968
CREATE OR REPLACE FUNCTION getAllAfter68 RETURN SYS_REFCURSOR
IS
  e_cursor SYS_REFCURSOR;
BEGIN
  OPEN e_cursor FOR
  SELECT * FROM EMPLOYEE
  WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN e_cursor;
END;
/
SELECT getAllAfter68 FROM DUAL;
/


/*
 * 4.0 - Stored Procedures
 */
-- 4.1 - Basic Stored Procedure
-- Selects first and last names of all employees
CREATE OR REPLACE PROCEDURE getAllNames(e_cursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN e_cursor FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

-- 4.2 - Stored Procedure Input Parameters
-- Updates employee information
CREATE OR REPLACE PROCEDURE updateName(eid IN NUMBER, fname IN VARCHAR2, lname IN VARCHAR2)
AS
BEGIN
  UPDATE EMPLOYEE
  SET FIRSTNAME = fname, LASTNAME = lname
  WHERE EMPLOYEEID = eid;
END;
/

-- Get all managers for an employee
CREATE OR REPLACE PROCEDURE getManagers(eid IN NUMBER, e_cursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN e_cursor FOR
  SELECT * FROM EMPLOYEE
  WHERE EMPLOYEEID = (
    SELECT REPORTSTO FROM EMPLOYEE
    WHERE EMPLOYEEID = eid
  );
END;
/

-- 4.3 - Stored Procedure Output Parameters
-- Returns the name and company of a customer
CREATE OR REPLACE PROCEDURE customerInfo(cid IN NUMBER, c_cursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN c_cursor FOR
  SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
  WHERE CUSTOMERID = cid;
END;
/


/*
 * 5.0 - Transactions
 */
-- Transaction that deletes an invoice given the ID
CREATE OR REPLACE PROCEDURE deleteTransaction(iid IN NUMBER)
AS
BEGIN
  DELETE FROM INVOICELINE WHERE INVOICEID = iid;
  DELETE FROM INVOICE WHERE INVOICEID = iid;
  COMMIT;
END;
/

-- Transaction that stores a new customer record
CREATE OR REPLACE PROCEDURE insertCustomer(
  fname IN VARCHAR2,
  lname IN VARCHAR2,
  e_mail IN VARCHAR2
)
AS
BEGIN
  INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL)
  VALUES (fname, lname, e_mail);
  COMMIT;
END;
/

/*
 * 6.0 - Triggers
 */
-- 6.1 - AFTER/FOR
-- After insert trigger on employee table
CREATE OR REPLACE TRIGGER employeeInsert
AFTER INSERT
ON EMPLOYEE
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Inserted new employee record.');
END;
/

-- After update trigger on album table
CREATE OR REPLACE TRIGGER albumUpdate
AFTER UPDATE
ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Album record updated.');
END;
/

-- After delete trigger on customer table
CREATE OR REPLACE TRIGGER customerDelete
AFTER DELETE
ON CUSTOMER
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Deleted the customer record.');
END;
/


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
