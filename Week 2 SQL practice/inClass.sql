/************************************************************
*           Nathan Ashcroft                                 *
*************************************************************/

--In Class Examples
select * from track where albumid = 1;
select * from genre;


--Scalar function (lower)
Select * from artist Where lower(name) like 'a%';
select name from artist where lower(name) like 't_e%';
select name from artist where length(name) < 10;

--Agrogate functions
select max(albumid) from album;
select count(*) from artist;
select avg(total) from invoice;
select min(total) from invoice;
select max(total) from invoice;

--Nested queries
Select albumid, title from album
where artistid = (select artistid from artist where name = 'Foo Fighters');

--IN signifies a set of results
select name as "Track Name" from track where genreid in (select GENREID from genre where name like 'R%');


--Joins
--inner join
Select * from album;

select al.title as Album, art.NAME as Artist
from album  al
inner join artist  art
on art.artistid= al.ARTISTID;

select tr.name as Track, al.title as Album, art.NAME as Artist, g.name as genre,
il.name as "Invoice Line"
from album  al
join artist  art on art.artistid= al.ARTISTID
join track tr on tr.ALBUMID = al.ALBUMID
join genre g on g.GENREID = tr.GENREID;
--join PLAYLISTTRACK pit on pit.TRACKID = 
--join playlist pl on pl.playlistid = pit.playlistid

select * 
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
order by tr.name;

--dual -- dummy table in oricle excists to maintain select syntax when reading stored entity
select sysdate from dual;


select count(tr.name) as track, g.name as genre
from track tr
inner join genre g
on tr.genreid = g.genreid
group by g.NAME
--having count(tr.name) > 100
order by g.name;


--natral join
select * from artist natural join album;
select * from artist inner join album on artist.ARTISTID = album.ARTISTID;

-- cross join - cartesian product of two tables
select * from artist, album;

-- natural join -- where Oracle SQL attempts to match based on column names
select * from artist natural join album;
select * from artist inner join album on artist.ARTISTID = album.ARTISTID;

-- self join -- joining columns from same table, here we join the reports to column with the manager column
select  e1.lastname as "MANAGER", e2.lastname as "EMPLOYEE"
from employee e1 
inner join employee e2 on e1.reportsto = e2.employeeid;

-- Set operations
/* Used to combine result set (must have the same columns)
union -all unique rows
union all - all rows including dups
intersect - what the 2 results sets have in common
minus - what result set A has that set B does not
*/


select * from customer where firstname like 'L%';
select * from CUSTOMER where state = 'CA';
select * from CUSTOMER where COUNTRY = 'Brazil';
select * from CUSTOMER where state = 'CA' union select * from CUSTOMER where COUNTRY = 'Brazil';
select * from customer where firstname like 'L%' union select * from CUSTOMER where COUNTRY = 'Brazil';

--intersect / minus
select * from invoiveline where unitprice > .99;
select * from INVOICELINE where trackid < 3000;
select * from invoiceline where unitprice > .99 minus select * from invoiceline where trackid  < 3000; 

Select * from artist where artistid = 10;


select max(artistid) from artist;


--Autoincrement
create sequence artist_sec
start with 276
increment by 1;

create or replace trigger artist_seq_trigger
BEFORE INSERT on artist
for each row
Begin
select artist_sec.nextVal into :new.artistid from dual;
end;


select * from artist where artistid = 277;
update artist SET name= 'bfs' where artistid = 277;







