-- Stored Procedures

CREATE OR REPLACE PROCEDURE helloWorld
AS
BEGIN
  dbms_output.put_line('Hello Nathan. You are SO AMAZING!!!!!!!!');
end;/

--get artist by id
CREATE OR REPLACE PROCEDURE get_artist_by_id(
  art_id IN number,
  art_name OUT varchar2)
IS
Begin
  select name into art_name from artist where artistid = art_id;
end;/

--a peek into explicit cursers here we will return all artists in a curser
CREATE OR REPLACE PROCEDURE get_all_artists(
  cursorParam OUT SYS_REFCURSOR)
  is
  begin
   open cursorparam for select * from artist;
  end;/
  
declare art_name varchar2(100);
begin
get_artist_by_id(50, art_name);
DBMS_OUTPUT.PUT_line('name: ' || art_name);
end;/

execute helloWorld; /

--functions

--get total number of artists
CREATE OR REPLACE FUNCTION get_num_artists
  return number
is
  total number;
begin
  select count(*) into total from artist;
  return total;
end;/

select get_num_artists() from duel;

/*
An index is a preformance-tuning method of allowing faster retrieval of reccords. 
*/
create index artist_name_index
on artist(name);