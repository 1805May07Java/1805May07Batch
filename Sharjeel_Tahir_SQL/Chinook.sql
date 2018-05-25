


-- select all records from employee table
select * from employee;
-- select all records from employee table where lastname is King
select * from employee where lastname = 'king';

--– Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
select * from employee where firstname = 'andrew' and reportsto IS null;

-- Select all albums in Album table and sort result set in descending order by title
select * from album order by title DESC;

--– Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city ASC;

-- Insert two new records into Genre table
select * from genre;
insert into genre (genreid, name) values (26, 'Trance');
insert into genre (genreid, name) values (27, 'xyz genre');

-- Insert two new records into Employee table
select * from employee;
insert into employee values (9, 'Kings', 'Michael', 'Salesman', 2, '06-Mar-89', '17-Dec-08', '688 31 Av', 'London', 'AB', 'Canada', 'T3B 0D8', '+1 (403) 453 2342', '+1 (403) 324 3424', 'xyz@chinookcorp.com');

-- Insert two new records into Customer table
select * from customer;
insert into customer values (60, 'dio', 'tay', 'ruby', '307 raeburn street', 'london', 'virginia', 'United Kingdom', 20100, '+1 (234) 234 2342', '+1 (323) 234 2342', 'afd@chinook.com', 5);

-- Update Aaron Mitchell in Customer table to Robert Walter
select * from customer;
update customer set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron';

--– Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from artist;
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

-- Select all invoices with a billing address like “T%”
select * from invoice;
select * from invoice where billingaddress like 'T%';

-- Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-4';

-- Delete a record in Customer table where the name is Robert Walter
select * from customer;
Delete from customer where firstname = 'Robert' and lastname = 'Walter';

-- Create a function that returns the current time
select to_char(CURRENT_TIMESTAMP, 'HH24:MI:SS') into l_systime from dual;

-- Create a function that returns the current time
create or replace function getSystime2
return char 
is
    l_systime TIMESTAMP;
begin
    select CURRENT_TIMESTAMP into l_systime from dual;
    return l_systime;
end;
/
SET SERVEROUTPUT ON;
begin
    dbms_output.put_line(getSystime2());
end;
/

select * from mediatype;

create or replace function mediatypelen (m_id IN number)
return int
is  
    mtypelen number;
begin
    select length(name) into mtypelen from mediatype where mediatypeid = m_id;
    return mtypelen;
end;
/
begin
    dbms_output.put_line(mediatypelen(3));
end;
/

select * from employee;


-- Create a function that returns the average total of all invoices
select * from invoice;

create or replace function avg_of_invoice
return float
is
    total_rows int;
    inv_total float;
begin
    select count(total) into total_rows from invoice;
    select sum(total) into inv_total from invoice;
    return inv_total/total_rows;
end;
/

begin
    dbms_output.put_line(avg_of_invoice);
end;
/

select max(unitprice) as largestprice from track;

/
-- Create a function that returns the most expensive track
create or replace function expTrack
return float
is
    largestprice float;
begin
    select max(unitprice) into largestprice from track;
    return largestprice;
end;
/
begin
    dbms_output.put_line(expTrack());
end;
/

select * from employee;
-- Create an after insert trigger on the employee table fired after a new record is inserted into th
create or replace trigger ins_employee
before insert on employee
for each row
enable   
begin
    select max(employee.employeeid) into :new.employeeid from employee;
    :new.employeeid := :new.employeeid + 1;
    DBMS_OUTPUT.PUT_LINE('You just entered a line');
end;
/
select * from employee;

begin
    insert into employee (lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) values ('Kings', 'Michael', 'Salesman', 2, '06-Mar-89', '17-Dec-08', '688 31 Av', 'London', 'AB', 'Canada', 'T3B 0D8', '+1 (403) 453 2342', '+1 (403) 324 3424', 'xyz@chinookcorp.com');  
end;
/


-- Create a stored procedure that selects the first and last names of all the employees
create or replace procedure get_all_artists
is 
    f_name varchar2(30);
    CURSOR all_name is select firstname from employee;
begin
    open all_name;
    Loop
        fetch all_name into f_name;
        dbms_output.put_line(f_name);
        exit when all_name%notfound;
    End Loop;
    close all_name;
end;
/
exec get_all_artists;
/

select * from customer;
select * from invoice;

-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
select customer.firstname, invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.customerid;


-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total

select * from album;
select * from artist;

-- Create a right join that joins album and artist specifying artist name and title




































select * from artist where name like 'A%' or name like 'B%';



-- Intro to functions
/* There are two kinds of functions
Aggregate - Functions that operate on multiple rows of data
Scalar - Functions that operate on single values
*/
-- scalar functions. take one record as input, "scale" or change it in some way, get one record as output
select name from artist where upper(name) like 'A %';
select name from artist where lower(name) like 't_e%';
select name from artist where length(name) < 10;
select name from artist where lower(name) like '%s';


-- aggregate functions, perform function on entire column/set of data --
select max(albumid) from album;
select count(*) from artist;
select avg(total) from invoice;
select min(total) from invoice;
select max(total) from invoice;

select * from album;

--NESTED QUERIES

-- find Foo fighters' albums 
select albumid, title
from album 
where artistid = 
(select artistid from artist where name = 'Foo Fighters');

-- when subquery returns more than one entity, use IN to signify that the id is "IN" this set of results
select name as "Track Name"
from track 
where genreid IN (select genreid from genre where name like 'R%');


select count(*) from track;

select * from genre;

-- DUAL -- dummy table in Oracle SQL; exists to maintain SELECT syntax when reading stored entity 
select sysdate from dual;

-----------------------------------------------------------------------J O I N S ------------------------------------------------------------------------------------------
-- INNER JOIN - Only returns rows where a match was found
select album.title, track.name
from album
inner join track 
on album.albumid = track.albumid;

select g.name as genre, count(tr.name) as track
from track tr
inner join genre g 
on tr.GENREID = g.GENREID
group by g.name
--having count(tr.name) > 100  -- having can only be used with group by 
order by g.name;

-- Group by and having
select count(firstname), company from customer group by company;

-- group by and where
select count(firstname), company from customer where Company='Google Inc.' group by company;

select count(albumid) as "# of Albums", name
  from (select album.albumid, artist.artistid, artist.name from album join artist on album.artistid = artist.artistid)
  where artistid > 5
  group by name
  having count(albumid) > 1
  order by "# of Albums";

--Full Outer Join - Returns all rows regardless of match
select emp.firstname as "employee", man.firstname as "manager"
from employee emp full outer join employee man on emp.reportsto=man.employeeid;

--Left Outer Join - Returns all rows from left table regardless of match
select emp.firstname as "employee", man.firstname as "manager"
from employee emp left outer join employee man on emp.reportsto=man.employeeid;

--Right Outer Join - Returns all rows from right table regardless of match
select emp.firstname as "employee", man.firstname as "manager"
from employee emp right outer join employee man on emp.reportsto=man.employeeid;

-- View - "virtual table" effectively stores a common query as an object in your db
select * from joinsview;

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



commit;

select avg(unitprice) from invoiceline;

-- cross join - cartesian product of two tables
select * from artist, album;

-- natural join -- where Oracle SQL attempts to match based on column names
select * from artist natural join album;
select * from artist inner join album on artist.ARTISTID = album.ARTISTID;

-- self join -- joining columns from same table, here we join the reports to column with the manager column
select  e1.lastname as "MANAGER", e2.lastname as "EMPLOYEE"
from employee e1 
inner join employee e2 on e1.reportsto = e2.employeeid;

------ SET OPERATIONS
/* Used to combine result set (must have the same columns)
    Union - all unique rows
    Union all - all rows, including duplicates
    intersect - what the 2 result sets have in common 
    minus - what result set A has that result set B does not 
*/

-- UNION & UNION ALL 
select * From customer where firstname like 'L%'; -- ID - 1, 2, 45, 47, 57
select * from Customer where state = 'CA'; -- Customer id 16, 19, 20
select * from customer where country = 'Brazil'; -- ID - 1, 10, 11, 12, 13
select * from Customer where state = 'CA' UNION select * from customer where country = 'Brazil';
select * From customer where firstname like 'L%' union all select * from customer where country = 'Brazil';

-- INTERSECT / MINUS
select * from invoiceline where unitprice > .99;
select * from invoiceline where trackid  < 3000;
select * from invoiceline where unitprice > .99 minus select * from invoiceline where trackid  < 3000; 



select max(artistid) from artist;




create sequence artist_seq
start with 276
increment by 1;
/
create or replace trigger artist_seq_trigger
before insert on artist -- when is it happening
for each row -- how often
begin
    -- where meat of trigger resides
    select artist_seq.nextVal into :new.artistid from dual;
end;
/

select * from artist where artistid = 278;

update artist set name = 'Genesis' where artistid = 278;




insert into artist (NAME) values ('Beyonce');
select * from artist order by artistid desc;

commit;





/*
-- lower(name) brings everything to lowercase 
select name from artist where lower(name) like 'A%';
--select name from artist where lower(name) like '
select name from artist where length(name) < 10;
-- aggregate functions, perform function on entire column/set of data
select max(albumid) from album;
select count(*) from artist;
select avg(total) from invoice;
select min(total) from invoice;
select max(total) from invoice;

select albumid, title 
from album 
where artistid = 
(select artistid from artist where name ='Foo Fighters');

select name as "Track Name" from track
where genreid = (select genreid from genre where name='Rock');

select name as "Track Name"
from track
where genreid IN (select genreid from genre where name like 'R%');

select genreid from genre where name like 'R%';

--select * from track
--select * from genre
select * from album;

--INNER JOIN
select al.title as Album, art.NAME as Artist, tr.name as Track
from album al
inner join artist art on art.artistid = al.artistid
inner join track tr on tr.ALBUMID=al.ALBUMID;

*/




--------------------------------------JOIN----------------------------------------