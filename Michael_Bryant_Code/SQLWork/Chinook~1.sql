/***************************************
*                                      *
*    Michael Bryant || SQL Worksheet   *
*                                      *
***************************************/


/**********SELECT FROM *****************
***************************************/

Select * from Customer;

Select * from Employee Where LastName = 'King';

Select * from Employee Where FirstName = 'Andrew' And Reportsto Is null;

/************ORDER BY*******************
***************************************/

SELECT * FROM ALBUM ORDER BY title DESC;

SELECT FirstName FROM Customer ORDER BY City ASC;

/************INSERT INTO***************
***************************************/

Insert into Genre(Genreid, Name)
VALUES (26, 'Blue Grass');

Insert into EMPLOYEE(EMPLOYEEID, Lastname, FirstName, Title,REPORTSTO,Birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (9, 'Bryant', 'Michael', 'Duke', null, null,null, '20 salt lake rd.', 'Fawn', 'PA', 'USA', '17321', '717 873 5311', null, 'mebryant@millersville.edu');

Insert into CUSTOMER(CustomerID, firstname, LASTNAME, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Michael', 'Bryant', '20 salt lake rd.', 'Fawn Grove', 'PA', 'USA', '17321', '+1 717 873 5311', NULL, 'mbryant36@gmail.com', NULL );

/**************UPDATE******************
***************************************/

UPDATE Customer
SET Firstname = 'Robert', Lastname = 'Walter' 
WHERE Firstname = 'Aaron' AND Lastname ='Mitchell';

UPDATE artist
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--SCALAR FUNCTIONS: take one record as input, "scale" or change it in some way, get one record as output
select name from artist where upper(name) like 'A%';
select name from artist where lower(name) like 't_e%';
select name from artist where length(name) < 10;
select name from artist where lower(name) like '%s';

--AGGREGATE FUNCTIONS: preform function on entire column/set of data -
select max(total) from invoice;
select count(*) from artist;
select avg(total) from invoice;
select min(total) from invoice;


--NESTED QUERIES

--find foo fighters albums
select albumid, title
from album
where artistID=
(select artistid from artist where name='Foo Fighters');

--find all rock songs inside of track table
select * from track
where GENREID =
(select genreid from genre where name = 'R%');

--Prints out tracks that have a R genre
select name as "Track Name"
from track
where genreid IN (select genreid from genre where name like 'R%');

--DUAL- dummy table in Oracle SQL; exists to maintain SELECT syntax when reading stored entity
select sysdate from dual;



----------------------JOINS----------------------------
--INNER JOIN
SELECT * FROM track;

select g.name as genre, tr.name as track
from track tr
inner join genre g
on g.GENREID = tr.GENREID
order by g.name;

select album.title, artist.NAME
from album
inner join artist
on artist.ARTISTID = album.ARTISTID
Order by album.TITLE ASC;

select al.TITLE as Album, art.NAME as artist
from album al
inner join artist art
on art.artistid = al.artistid
order by al.title;

select tr.name as track,il.INVOICELINEID, al.title as album, art.name as artist, g.name as genre, cu.CUSTOMERID
from album al
inner join artist art on art.artistid = al.ARTISTID
inner join track tr on tr.Albumid = al.albumid
inner join genre g on g.genreid = tr. genreid
inner join playlisttrack pit on pit.TRACKID = tr.TRACKID
inner join playlist pi on pi.playlistid = pit.playlistid
inner join mediatype mt on mt.mediatypeid = tr.MEDIATYPEID
inner join invoiceline il on il.trackid = tr.trackid
inner join invoice iv on iv.INVOICEID = il.INVOICEID
inner join customer cu on cu.CUSTOMERID = iv.CUSTOMERID;






