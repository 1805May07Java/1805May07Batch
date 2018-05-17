CREATE USER test -- username
IDENTIFIED BY p4ssw0rd; -- password

GRANT connect to test;
GRANT resource to test;

-- in order to create a new user, run this from the master connection on your db
