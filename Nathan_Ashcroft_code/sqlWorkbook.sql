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
INSERT INTO genre VALUES (29, 'PopRock');

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

--Problem 2.7 DELETE

--DELETE * FROM invoice WHERE customerid = (select customerid WHERE firstname = 'Robert' AND lastname = 'Walter');

DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';


--In Class Examples

--Scalar function (lower)
Select * from artist Where lower(name) like 'a%';
select name from artist where length(name) < 10;

--Agrogate functions
select max(albumid) from album;
select count(*) from artist;
select avg(total) from invoice;
select min(total) from invoice;
select max(total) from invoice;



select * from track where albumid = 1;
select * from track;
