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
--- DOES NOT WORK!

/*
 * 3.0 - SQL Functions
 */
-- 3.1 - System Defined Funtions
SELECT CURRENT_TIMESTAMP FROM dual;


-- 3.2 - System Defined Aggregate Functions
SELECT AVG(TOTAL) FROM INVOICE;
SELECT MAX(UNITPRICE) FROM TRACK;

-- 3.3 - User Defined Functions


-- 3.4 - User Defined Table Valued Functions

/*
 * 4.0 - Stored Procedures
 */
-- 4.1 - Basic Stored Procedure
-- 4.2 - Stored Procedure Input Parameters
-- 4.3 - Stored Procedure Output Parameters

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
-- 7.5 - SELF
-- 7.6 - Complicated Join assignment
