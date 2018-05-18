CREATE USER FIRST_DB 
IDENTIFIED BY p4ssw0rd;

GRANT DBA TO FIRST_DB 
WITH ADMIN OPTION;


-- or 
CREATE USER test -- username
IDENTIFIED BY p4ssw0rd; -- password

GRANT connect to test;
GRANT resource to test;

-- in order to create a new user, run this from the master connection on your db
