--scalar functions. take one record as input, "scale" or change it in some way, get one record as ouput
select * from artist where lower(name) like 'a%'; 
select name from artist where length(name) <10;
select name from artist where lower(name) like '%s';

-- aggregate functions, perform function on entire column/set of data
select max(albumid) from album;
select count(*) from artist;
select avg(total) from invoice;
select max(total) from invoice;

--Nested Queries
select albumid, title
from album
where artistid =
(select artistid from artist where name = 'Foo Fighters'); -- allows you to search all albums with foo fighters artist id without needing to know artist id.

select name as "Track Name" 
from track 
where genreid in            -- use 'in' instead of = to use subqueries that return multiple results
(select genreid from genre where name like 'R%');

--DUAL -- dummy table in oracle swl; isists to maintain SELECT syntax when reading stored entity
select sysdate from dual;

--JOINS
  -- returns number of tracks in a genre
  select count(track.name), genre.name
  from track
  inner join genre
  on track.genreid = genre.genreid
  group by genre.name
  order by genre.name;

  -- inner join
  select al.title, art.name
  from album al  -- alias album table as al
  inner join artist art -- alias artist table as art
  on art.artistid = al.artistid;
  
  -- three way join
  select tr.name as track, al.title as album, art.name as artist, g.name as genre, mt.name as mediatype, pl.name as playlist, emp.lastname
  from album al  -- alias album table as al
  inner join artist art on art.artistid = al.artistid -- alias artist table as art -
  inner join track tr on tr.albumid = al.albumid
  inner join genre g on g.genreid = tr.genreid
  inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
  inner join playlisttrack pt on pt.trackid = tr.trackid
  inner join playlist pl on pl.playlistid = pt.playlistid
  inner join invoiceline ivl on ivl.trackid = tr.trackid
  inner join invoice iv on iv.INVOICEID = ivl.INVOICEID
  inner join customer cus on cus.CUSTOMERID = iv.CUSTOMERID
  inner join employee emp on emp.EMPLOYEEID = cus.SUPPORTREPID
  order by tr.name asc;
  
-- SET OPERATIONS
/*Used to combine result set (must have the same columns)
Union - all unique rows
union all - all rows including duplicates
intersect - what the 2 result sets hae in common
minus - what result set S has that result set B does not
*/

-- get from github...



--2.1 SELECT
--Task – Select all records from the Employee table.
select * from employee
--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King'
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and reportsto is null
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc
--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
insert into genre values (26, 'Chillhop');
insert into genre values (27, 'Emo');
--Task – Insert two new records into Employee table
insert into employee values (9, 'santos', 'miguel', 'Master', 1, '20-JUL-92', '07-MAY-18', '9931 N. Baird Ave.', 'Fresno', 'CA', 'USA', '93720', '(559)801-6028', 'n/a', 'diqo92@gmail.com');
insert into employee values (10, 'lubi', 'krystal', 'Queen', 9, '20-APR-94', '07-MAY-18', '986 E Kenosha Ave', 'Fresno', 'CA', 'USA', '93720', '(559)313-0961', null , 'klubi@uci.edu');
--Task – Insert two new records into Customer table
insert into customer values (60, 'Mike', 'Santos', 'Caltrans', '9931 n baird ave', 'fresno', 'ca', 'usa', '93720', '5592732788', 'n/a', 'migli2@yaho.com', 3);
insert into customer values (61, 'Fe', 'Santos', 'community', '9931 n baird ave', 'fresno', 'va', 'usa', '93720', '5592731049', 'n/a', 'fepot@gmail.com', 2);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron' and lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
delete from invoiceline where invoiceid in (select * from invoice where customerid = 32);
delete from invoice where customerid = 32;
delete from customer where customerid = 32;

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace function get_time_now
  return date
is
  now date;
begin
  --alter session set time_zone = '-4:0';
  --alter session set nls_date_format = 'HH24:MI';
  select current_date into now from dual;
  return now;
end;
/
select get_time_now() from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select to_char(avg(total), 99.99) as average from invoice;
/*create or replace function get_avg_invoice
  return number
is
  avg_inv number;
begin
  select to_char(avg(total), 99.99) into avg_inv from invoice;
  return avg_inv;
end;
/
select get_avg_invoice() as average from dual;*/
--Task – Create a function that returns the most expensive track
select name, unitprice from track where unitprice = (select max(unitprice) from track);

/*create or replace function exp_track
  return varchar2(200)
is
  
  res varchar2(200);
begin
  select name into res from track where unitprice = (select max(unitprice) from track);
  return res;
end;
/*/
--3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avg_price
  return number
is 
  res number;
begin
  select to_char(avg(unitprice), 99.99) into res from invoiceline;
  return res;
end;
/
select avg_price() from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname from customer where customerid = 
(select customerid from invoice where total = 
(select max(total) from invoice));

select customer.firstname, customer.lastname, track.name from customer 
inner join invoice on customer.customerid = invoice.customerid 
inner join invoiceline on invoice.invoiceid = invoiceline.invoiceid 
inner join track on invoiceline.trackid = track.trackid 
order by customer.firstname, customer.lastname asc;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from customer
full outer join invoice on customer.customerid = invoice.customerid 
order by customer.firstname asc;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.