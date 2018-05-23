/*Nicholas Offutt SQL Workbook
Week 2 Homework
*/

/*Task 2.1 Select
Task – Select all records from the Employee table. 
Task – Select all records from the Employee table where last name is King. 
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
*/
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew' and REPORTSTO is NULL;


/*Task 2.2 Order By
Task – Select all albums in Album table and sort result set in descending order by title. 
Task – Select first name from Customer and sort result set in ascending order by city 
*/ 
select * from album order by TITLE desc;
select firstname from CUSTOMER order by city asc;


/*Task 2.3  INSERT INTO 
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table ,
Task – Insert two new records into Customer table 
*/
insert into genre values (26, 'Swing');
insert into genre values (27, 'Rockabilly');

insert into employee values (9, 'Smith', 'James', 'Sales Support Agent', 2, '10-OCT-67', '16-MAY-18', '159 Aldwell E', 'Calgary', 'AB', 'Canada', 'T2P 5M5',' +1 (403) 264-3034', '+1 (202) 111-5555', 'james@chinookcorp.com');
insert into employee values (10, 'Holmes', 'Shirly', 'Sales Support Agent', 2, '10-MAY-34', '16-MAY-18', '221 B Baker', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 264-1614', '+1 (505) 222-6666', 'shirly@chinookcorp.com');

insert into customer values (60, 'Sam', 'Brown', NULL, '8657 W Halibut', 'Reavee', NULL, 'Aliahan', '7022', '+99 (245) 467-8034', NULL, 'Halibut@snailware.com', 9);
insert into customer values (61, 'Zoma', 'Drinker of Despair', NULL, '666 Evil Palace', 'Nailmark', NULL, 'Ruin', '7022', '+99 (666) 666-6666', NULL, 'Zoma@devilware.com', 10);


/*Task 2.4  UPDATE 
Task – Update Aaron Mitchell in Customer table to Robert Walter 
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
*/
update customer set firstname = 'Robert', lastname = 'Walter' Where firstname = 'Aaron' And lastname = 'Mitchell';
update artist set NAME = 'CCR' where name = 'Creedence Clearwater Revival';


/*Task 2.5 LIKE
Task – Select all invoices with a billing address like “T%” 
*/

select * from invoice where billingaddress like 'T%';

/*Task 2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50 
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
*/

select * from invoice where total between 15 and 20;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

/*Task 2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). 
*/
delete from customer where firstname = 'Robert' and lastname = 'Walter';


/*Task 3.1 System Defined Functions 
Task – Create a function that returns the current time. 
Task – create a function that returns the length of a mediatype from the mediatype table 
*/
select SYSTIMESTAMP FROM DUAL;

select Length(mediatype.name),NAME from mediatype;

/*Task 3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track 
*/
SELECT AVG(total) "Average Total" from invoice;

SELECT MAX(Unitprice) from track;


/*Task 3.3 User Defined Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
*/
create or replace function avg_invoiceline
  return number
  as
  average number;
begin
  select avg(unitprice) into average from invoiceline;
  return average;
end;
/

/*Task 3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968. 
*/

create or replace function all_before68
return SYS_REFCURSOR
as
my_cursor SYS_REFCURSOR;
begin open my_cursor for select Firstname from EMPLOYEE where BIRTHDATE > 31-DEC-68;
return my_cursor;
end;
/

/*4.1 Basic Stored Procedure 
Task – Create a stored procedure that selects the first and last names of all the employees. 
*/

create or replace procedure first_last (cursorParam OUT SYS_REFCURSOR)
as
  begin
  open cursorParam for select FIRSTNAME, LASTNAME from EMPLOYEE;
  return cursorParam;
  end;
/



/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee. 
Task – Create a stored procedure that returns the managers of an employee. 
*/
CREATE OR REPLACE PROCEDURE update_emp 
(
  ID IN NUMBER 
, LASTNAME IN VARCHAR2 
, FIRSTNAME IN VARCHAR2 
, TITLE IN VARCHAR2 
, REPORTSTO IN NUMBER 
, BIRTHDATE IN DATE 
, HIREDATE IN DATE 
, ADDRESS IN VARCHAR2 
, CITY IN VARCHAR2 
, STATE IN VARCHAR2 
, COUNTRY IN VARCHAR2 
, POSTALCODE IN VARCHAR2 
, PHONE IN VARCHAR2 
, FAX IN VARCHAR2 
, EMAIL IN VARCHAR2 
) AS 
BEGIN
  update employee set LASTNAME = LASTNAME, FIRSTNAME = FIRSTNAME, TITLE = TITLE, 
  REPORTSTO = REPORTSTO, BIRTHDATE = BIRTHDATE, HIREDATE = HIREDATE, ADDRESS = ADDRESS, 
  CITY = CITY, STATE = STATE, COUNTRY = COUNTRY, POSTALCODE = POSTALCODE, PHONE = PHONE, FAX = FAX, EMAIL = EMAIL where employeeid = id;
END;
/

create or replace procedure reports
(reportsto In number,
LASTNAME OUT varchar2)
as
begin select LASTNAME into LASTNAME from EMPLOYEE where employeeid = reportsto;
end;
/



/*4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer. 
*/
create or replace procedure customer_info(custid in number ,cursorParam Out SYS_REFCURSOR)
as
begin
  open cursorParam for select FirstNAME, LASTNAME, COmpany from customer where customerid = custid;
  end;
  /


/*5.0 Transactions 
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). 
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table 
*/

set Transaction invoice_del



/*6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

create sequence emp_seq
start with 9;

create or replace trigger emp_ins
after insert on employee
for each row
begin
select emp_seq.nextVal into :new.employeeid from dual;
end;
/

create or replace trigger alb_up
after update on album
for each row
begin
end;
/

create or replace trigger cust_del
after delete on customer
for each row 
begin
end;
/


/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
select customer.firstname, customer.lastname, invoice.invoiceid from customer inner join invoice on customer.customerid = invoice.customerid;


/*7.2 OUTER/Left join 
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
*/
select cust.customerid, cust.firstname, cust.lastname, inv.invoiceid, inv.total
from customer cust
left outer join invoice inv on cust.customerid = inv.customerid; 

/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title. 
*/
select artist.name, album.title
from artist
right outer join album on artist.artistid = album.artistid;

/*7.4 CROSS 
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. 
*/
select * from artist cross join album
order by artist.name; 

/*7.5 SELF 
Task – Perform a self-join on the employee table, joining on the reportsto column. 
*/
SELECT e1.lastname as Manager, e2.lastname as Employee
from employee e1
inner join employee e2 on e1.employeeid = e2.reportsto;

/*7.6 Complicated Join assignment 
Task- Create an inner join between all tables in the chinook database. 
*/
--create view JoinsView as
select tr.name as Track, al.title as Album, art.name as Artist, gr.name as Genre, 
pl.name as Playlist, mt.name as "Media Type", inl.unitprice as Cost, inv.billingaddress as Address, 
cus.firstname as "First", cus.lastname as "Last", emp.firstname as Representative
from album al
inner join artist art on art.artistid = al.artistid
inner join track tr on tr.albumid = al.albumid
inner join genre gr on tr.genreid = gr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on pl.playlistid = plt.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join invoiceline inl on inl.trackid = tr.trackid
inner join invoice inv on inv.invoiceid = inl.invoiceid
inner join customer cus on cus.customerid = inv.customerid
inner join employee emp on emp.employeeid = cus.supportrepid;









