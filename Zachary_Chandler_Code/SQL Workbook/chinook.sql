/* Zachary Chandler SQL Workbook */

/* 2.1 */
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew' and REPORTSTO is NULL;

/* 2.2 */
select * from album order by title desc;
select firstname from customer order by city asc;

/* 2.3 */
insert into genre values(26, 'Speedcore');
insert into genre values(27, 'Low Fidelity Hip Hop');

delete from genre where genreid = 26;
delete from genre where genreid = 27;

insert into employee (employeeid, firstname, lastname) values (2193171, 'George', 'Washington');
insert into employee (employeeid, firstname, lastname) values (2193172, 'Abraham', 'Lincon');

delete from employee where employeeid = 2193171;
delete from employee where employeeid = 2193172;

insert into customer (customerid, firstname, lastname, email) values (2193171, 'George', 'Washington', 'george.washington@gmail.com');
insert into customer (customerid, firstname, lastname, email) values (2193172, 'Abraham', 'Lincon', 'abe.lincon@gmail.com');

delete from customer where customerid = 2193171;
delete from customer where customerid = 2193172;

/* 2.4 */
update customer 
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

update customer 
set firstname = 'Aaron', lastname = 'Mitchell'
where firstname = 'Robert' and lastname = 'Walter';

update artist 
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

update artist 
set name = 'Creedence Clearwater Revival'
where name = 'CCR';

/* 2.5 */
select * from invoice where billingaddress like 'T%';

/* 2.6 */
select * from invoice where total between 15 and 50;
select * from employee where hiredate between date '2003-01-01' and date '2004-03-01';

/* 2.7 

delete from invoiceline where invoiceid in (
    select invoiceid from invoice where customerid in (
        select customerid from customer where firstname = 'Robert' and lastname = 'Walter'
    )
);

delete from invoice where customerid = 33;

delete from invoice where customerid in (
    select customerid from customer where firstname = 'Robert' and lastname = 'Walter'
);

delete from customer where firstname = 'Robert' and lastname = 'Walter';
*/

/* 3.1 */

CREATE OR REPLACE FUNCTION get_current_time RETURN VARCHAR2
IS
    cur_time VARCHAR2(8);
BEGIN
    select to_char(sysdate, 'HH24:MI:SS') into cur_time from dual;
  RETURN cur_time;
END;
/

CREATE OR REPLACE FUNCTION get_media_length(mTypeID number) RETURN Number
IS
    media_length number;
BEGIN
    select length(name) into media_length from mediatype where mediatypeid = mtypeid;
  RETURN media_length;
END;
/

/* 3.2 */
CREATE OR REPLACE FUNCTION INVOICELINE_AVG_TOTAL RETURN NUMBER
IS
  AVERAGE NUMBER;
BEGIN
  SELECT SUM(TOTAL)/COUNT(TOTAL) INTO AVERAGE FROM INVOICE;
  RETURN AVERAGE;
END;
/

CREATE OR REPLACE FUNCTION MAX_PRICE_TRACK RETURN NUMBER
IS
  MAX_PRICE NUMBER;
BEGIN
  SELECT MAX(UNITPRICE) INTO MAX_PRICE FROM TRACK;
  RETURN MAX_PRICE;
END;
/

/* 3.3 */
CREATE OR REPLACE FUNCTION INVOICELINE_AVG RETURN NUMBER
IS
  AVERAGE NUMBER;
BEGIN
  SELECT SUM(UNITPRICE)/COUNT(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
  RETURN AVERAGE;
END;
/

/* 3.4 */
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/

/* 4.1 */

CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(JUSTIN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN JUSTIN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

/* 4.2 */
create or replace procedure employee_update_info(
    employeeid_ in number,
    address_ in varchar2,
    city_ in varchar2,
    state_ in varchar2,
    country_ in varchar2,
    postalcode_ in varchar2,
    phone_ in varchar2,
    fax_ in varchar2,
    email_ in varchar2
)
as
begin
    update employee
    set address = address_,
        city = city_,
        state = state_,
        country = country_,
        postalcode = postalcode_,
        phone = phone_,
        fax = fax_,
        email = email_
    where employeeid = employeeid_;
end;
/

create or replace procedure get_manager(
    employeeid_ in number,
    managerid out number)
as
begin
    select reportsto into managerid from employee where employeeid = employeeid_;
end;
/

/* 4.3 */
create or replace procedure get_name_company(
    customerid_ in number,
    firstname_ out varchar2,
    lastname_ out varchar2,
    company_ out varchar2)
as
begin
    select firstname, lastname, company 
    into firstname_, lastname_, company_
    from customer 
    where customerid = customerid_;
end;
/

/* 5.0 */

create or replace procedure delete_invoice(
    invoiceid_ in number)
as
begin
    SET TRANSACTION NAME 'delete-invoice-transaction';
    
    delete from invoiceline where invoiceid = invoiceid_;
    
    delete from invoice where invoiceid = invoiceid_;
    
    rollback;
end;
/

create or replace procedure create_customer(
    fname in varchar2,
    lname in varchar2,
    email_ in varchar2)
as
    customerid_ number;
begin
    SET TRANSACTION NAME 'create_customer-transaction';
    
    select max(customerid) + 1 into customerid_ from customer;
    
    insert into customer (customerid, email, firstname, lastname) values (customerid_, email_, fname, lname);
    
    rollback;
end;
/

/* 6.1 */
create or replace trigger after_insert_album
after insert on album
for each row
begin
    dbms_output.put_line('Inserted into album');
end;

/

create or replace trigger after_delete_customer
after delete on customer
for each row
begin
    dbms_output.put_line('Deleted from customer');
end;

/

/* 7.1 */
select firstname, invoiceid 
from customer
inner join invoice on invoice.customerid=customer.customerid;

/* 7.2 */
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join invoice on invoice.customerid=customer.customerid;

/* 7.3 */
select artist.name, album.title
from artist
right outer join album on artist.artistid = album.artistid;

/* 7.4 */
select * from album
cross join artist
order by artist.name asc;

/* 7.5 */
select e1.firstname as employee, e2.firstname as manager 
from employee e1, employee e2
where e1.reportsto = e2.employeeid;

/* 7.6 
select * 
from album
join track on album.albumid = track.albumid
join playlisttrack on track.trackid = playlisttrack.trackid
join playlist on playlisttrack.playlistid = playlist.playlistid
join genre on track.genreid = genre.genreid
join invoiceline on invoiceline.trackid = track.trackid
join invoice on invoiceline.invoiceid = invoice.invoiceid
join mediatype on mediatype.mediatypeid = track.mediatypeid
join artist on artist.artistid = album.albumid
join customer on customer.customerid = invoice.customerid
join employee on employee.employeeid = customer.supportrepid
*/


