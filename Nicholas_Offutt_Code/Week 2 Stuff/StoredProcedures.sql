--Stored Procedures

CREATE OR REPLACE PROCEDURE helloWorld
AS
BEGIN
dbms_output.put_line('Hello DB World');
end;
/

execute helloWorld;


--get artist by id

create or replace procedure get_artist_by_id(
  art_id IN number,
  art_name Out varchar2)
AS
begin
select name into art_name from artist where artistid = art_id;
end;
/

declare
  art_name varchar2(100);
begin
  get_artist_by_id(50,art_name);
  dbms_output.put_line('Name: '|| art_name);
 end;
 /

create or replace procedure all_artists(cursorParam Out SYS_REFCURSOR)
as
begin
  open cursorParam for select * from artist;
  end;
  /

create or replace function get_num_artists
 return number
 is 
  total number;
begin
select COUNT(*) into total from artist;
return total;
end;
/


select get_num_artists from dual;
