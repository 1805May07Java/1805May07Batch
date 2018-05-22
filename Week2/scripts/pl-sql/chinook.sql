--STORED PROCEDURES 
/* Block of code we can execute
   0 or more IN and OUT parameters
   Can execute full DML and TCL commands
*/
CREATE OR REPLACE PROCEDURE helloWorld
AS
BEGIN
  dbms_output.put_line('HELLO DB WORLD!');
END;

/
execute helloWorld;
/
--- get artist by id procedure
CREATE OR REPLACE PROCEDURE get_artist_by_id(
      art_id IN NUMBER,
      art_name OUT VARCHAR2)
  IS
  BEGIN
    SELECT name INTO art_name FROM artist WHERE artistid = art_id;
  END;
  
  /
  
  declare 
    art_name varchar2(100);
  begin 
    get_artist_by_id(50, art_name);
      dbms_output.put_line('name: ' ||  art_name);
    end; 
    /
    
    -- a peek into explicit cursors; here we will return all artists in a cursor 
  create or replace procedure get_all_artists(
      cursorParam OUT SYS_REFCURSOR)
    is
    begin
      open cursorParam for select * from artist;
    end;
    /
    
    
    --- functions 
    /* Functions are blocks of code we can execute that must return 1 value
   They may take in 0 or more parameters
   Invoke statements using ()
   Can only use DQL(SELECT) statements, not INSERT, UPDATE, or DELETE
*/
  
  -- get total number of artists
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
  retrieval of records. An index creates an entry for each value
  that appears in the indexed columns
  */
create index artist_name_index 
on artist(name);