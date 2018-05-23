
-- 2.1 SELECT
select * from employee
select * from employee where lastname = 'King'
select * from employee  where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
select * from album order by title desc
select firstname from customer order by city asc

-- 2.3 INSERT INTO 
insert into genre values (4, 'Vidya gaems');
insert into genre values (14, 'Movies');

-- 2.4 UPDATE
update customer 
set firstname = 'Robert', lastname='Walker'
where firstname='Aaron' and lastname='Mitchell';


select max(total) from invoice;
select name from artist where length(name) < 10;

select albumid, title from album
where artistid = (select artistid from artist where name='Foo Fighters');

select * from track;

-- when subqueries return more than one entity, use IN to signify that the id is "IN" this set of results.
select * from genre
where genreid in (select genreid from genre where name like 'R%');

--select album.title as 'album', artist.name as 'artist' from album join artist on artist.artistid = album.ARTISTID;

select al.title as album, art.name as artist, tr.name as track
from album al
inner join artist art on art.artistid = al.artistid
inner join track tr on tr.albumid = al.albumid;

select *
from album
join artist on artist.artistid = album.artistid
join track on track.albumid = album.albumid
join genre on genre.genreid = track.genreid
join mediatype on track.MEDIATYPEID = mediatype.MEDIATYPEID
join playlisttrack on playlisttrack.TRACKID = track.TRACKID
join playlist on playlist.PLAYLISTID = playlisttrack.PLAYLISTID
join invoiceline on invoiceline.TRACKID = track.trackid
join invoice on invoiceline.INVOICEID = invoice.invoiceid
join customer on invoice.CUSTOMERID = invoice.CUSTOMERID
join employee on customer.SUPPORTREPID = employee.EMPLOYEEID;

-- Dual - dummy table in oracle sql; exists to maintain select syntax when reading stored entity
select * from dual;

select g.name as genre,count(tr.name) as track
from track tr
  inner join genre g
  on tr.genreid = g.genreid
group by g.name having count(tr.name) > 30
order by g.name asc;

select * from artist natural join album;
select * from artist inner join album on artist.ARTISTID = album.ALBUMID;

select * from customer where state = 'CA'
UNION ALL
select * from customer where country='Brazil';

select * from invoiceline where unitprice>.99
INTERSECT
select * from invoiceline where trackid < 3000;


select max(artistid) from artist;

create sequence artist_seq 
start with 276 
increment by 1;

CREATE OR REPLACE TRIGGER artist_trigger
BEFORE INSERT ON artist
FOR EACH ROW
BEGIN
  SELECT artist_seq.NEXTVAL
  INTO   :new.artistid
  FROM   dual;
END;
/

select * from artist order by artistid desc;

update artist set name='not real' where artistid=277;

create or replace procedure helloWorld
as
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello db world');
end;
/

exec helloWorld;

create or replace procedure get_artist_by_id (
  art_id in number,
  art_name out varchar2)
is
begin
  select name into art_name from artist where artistid = art_id;
end;
/

-- functions need to return something
create or replace function get_num_artists
  return number
is
  total number;
begin
  select count(*) into total from artist;
  return total;
end;
/

select get_num_artists() from dual;

/*
 An index is a performance-tuning method of allowing faster
 retrieval of records. An index creates an entry for each value'
 that appears in the indexed columns
*/
create index artist_name_index
on artist(name);

