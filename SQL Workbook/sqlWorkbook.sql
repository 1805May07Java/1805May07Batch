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

--Problem 3.1 System Defined Functions
CREATE OR REPLACE FUNCTION med_tyle_length
return number
is len number;
begin
select CURRENT_TIMESTAMP into len from dual;
return len;
end; /

select LENGTH('mediatype')from mediatype;
--Problem 3.2 System Defined Aggregate Functions
select avg(total) from invoice;
select max(unitprice) from track;

--Problem 3.3 User Defined Functions
select avg(unitprice) from invoiceline;

--Problem 3.4  User Defined Table Valued Functions
select * from employees where birthdate > to_date('01-JAN-1968','DD-MON-YY');

Task – Create a function that returns all employees who are born after 1968.

