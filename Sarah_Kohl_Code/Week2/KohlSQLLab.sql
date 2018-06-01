/*SQL Lab
Author: Sarah Kohl
Revature LLC
*/

--2.1--
SELECT * FROM employee; 

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2--
SELECT * FROM album ORDER BY title DESC;

SELECT firstname FROM customer ORDER BY city;

--2.3--
INSERT INTO genre VALUES (26, 'Vaporwave');
INSERT INTO genre VALUES (27, 'City Pop');

INSERT INTO employee VALUES(9, 'Miyagi','Nariyoshi', 'Sensei', NULL, DATE '1925-06-09', DATE '2011-10-15', 'Somewhere', 'Reseda', 'CA', 'USA', 'T5K 2N1','+1 (392) 293-3913', '+1 (392) 292-1039', 'waxonw@xoff.com');
INSERT INTO employee VALUES(10, 'LaRusso','Daniel', 'Student', 9, DATE '1970-03-20', DATE '1984-10-31', 'South Seas Drive', 'Reseda', 'CA', 'USA', 'T5K 2N1','+1 (392) 293-3913', '+1 (392) 292-1039', 'danny@larussoauto.net');

INSERT INTO customer VALUES(60,'McFly', 'Marty', 'Hill Valley High School', '313 Player Ln', 'Hill Valley', 'CA', 'USA', '93029', '+1 (321) 391-3039', '+1 301-3948', 'thisishe@vy.com', 3);
INSERT INTO customer VALUES(61, 'Brown', 'Doc', 'Inventor', '313 Player Ln', 'Hill Valley', 'CA', 'USA', '93029', '+1 (321) 391-3039', '+1 301-3948', 'gre@tscott.com', 3);

--2.4--
UPDATE customer set firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist  set name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5--
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6--
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7--
DELETE FROM invoiceline WHERE EXISTS (SELECT invoice.billingaddress FROM invoice INNER JOIN invoiceline ON customerid = 32);
DELETE FROM invoice WHERE customerid = 32;
DELETE customer WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.1--
CREATE OR REPLACE FUNCTION get_time
    RETURN VARCHAR2 
    IS
    mytime varchar(8);
    BEGIN
        SELECT TO_CHAR(LOCALTIMESTAMP, 'HH:MI:SS') INTO mytime FROM DUAL;
        RETURN mytime;
    END;
    /
    
CREATE OR REPLACE FUNCTION get_mediatype_length(myrow in NUMBER)
    
    RETURN NUMBER 
    IS
    mylength NUMBER(3);
    BEGIN
        SELECT LENGTH(name) INTO mylength FROM mediatype WHERE mediatypeid = myrow;
        RETURN mylength;
    END;
/
--BEGIN
--DBMS_output.put_line(get_mediatype_length(1));
--END;
--/
--3.2--
CREATE OR REPLACE FUNCTION average_invoice_total 
          RETURN NUMBER
          IS
              avginv NUMBER(10,2);
          BEGIN
              SELECT AVG(total) INTO avginv FROM invoice;
              RETURN avginv;
          END;      
/

BEGIN
DBMS_output.put_line( average_invoice_total() );
END;
/
--3.3--

--7.1--
SELECT CONCAT(CONCAT(customer.firstname, ' '), customer.lastname) AS "Customer Name", invoice.invoiceid AS "Invoice #" FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid ;

--7.2--
SELECT customer.customerid as "Customer ID", customer.firstname as "First", customer.lastname as "Last", invoice.invoiceid as "Invoice ID", invoice.total as "Total"  FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3--
SELECT artist.name as "Name", album.title as "Title" FROM album RIGHT JOIN artist on album.artistid = artist.artistid;

--7.4--
SELECT  artist.name as "Name", album.title as "Title" FROM artist CROSS JOIN album ORDER BY artist.name;

--7.5--
SELECT e1.lastname as "Employee", e2.lastname as "Supervisor" FROM employee e1, employee e2 WHERE e1.reportsto = e2.employeeid;