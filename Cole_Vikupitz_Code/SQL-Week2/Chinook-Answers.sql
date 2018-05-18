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
--SELECT CURRENT_TIMESTAMP FROM dual;


-- 3.2 - System Defined Aggregate Functions
--SELECT AVG(TOTAL) FROM INVOICE;
--SELECT MAX(UNITPRICE) FROM TRACK;

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
SELECT art.NAME, alb.TITLE FROM ALBUM alb
  CROSS JOIN ARTIST art
  ORDER BY art.NAME ASC;

-- 7.5 - SELF
SELECT A.LASTNAME, A.FIRSTNAME FROM EMPLOYEE A, EMPLOYEE B
  WHERE A.REPORTSTO = B.REPORTSTO
  ORDER BY LASTNAME ASC;

-- 7.6 - Complicated Join assignment

/*
create view joinsview as 
select al.TITLE as  album, art.NAME as artist, tr.name as track, g.NAME as genre, pl.NAME as playlist, inv.TOTAL
from album al
join artist art on art.artistid = al.artistid
join track tr on tr.ALBUMID = al.ALBUMID
join genre g on g.GENREID = tr.GENREID
join PLAYLISTTRACK plt on plt.TRACKID = tr.trackid
join playlist pl on pl.PLAYLISTID = plt.PLAYLISTID
join invoiceline inl on inl.TRACKID = tr.TRACKID
join invoice inv on inl.INVOICEID = inv.INVOICEID
join mediatype mt on mt.MEDIATYPEID = tr.MEDIATYPEID
join customer cust on cust.CUSTOMERID = inv.CUSTOMERID
join EMPLOYEE emp on emp.EMPLOYEEID = cust.SUPPORTREPID
where tr.trackid < 10;
*/
