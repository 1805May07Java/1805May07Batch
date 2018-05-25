-- Chris Ray, SQL practice

-- 2.1
select * from employee;

select * from employee where lastname = 'King';

select * from employee where firstname = 'andrew' and reportsto = null;

--2.2
select * from album order by title desc;

select * from customer order by city asc;

--2.3
insert into genre values(27, 'New Age Retro');

insert into genre values(28, 'White Noise');

insert into employee values(11, 'Lao', 'Lars', 'Assistant Manager', 6, '01-JAN-01', '01-JAN-01', '123 Main St.', 'Homecity', 'TX', 'USA', 'Post-x', '123456789', '123456789', 'll@lao.com');

insert into employee values(12, 'Kao', 'Kars', 'Assistant Manager', 6, '01-JAN-01', '01-JAN-01', '321 Main St.', 'Homecity', 'VA', 'USA', 'Post-EX', '123456789', '123456789', 'yoden@qerk.com');

insert into customer values(62, 'Abc', 'Def', 'Alphabet, Inc', '7 Alpha Way', 'Greco', 'WA', 'USA', 'POST-99', '123456789', '98764321', 'a@b.com', 2);

insert into customer values(63, 'Ced', 'Def', 'Rosher, LLC', '86 Kafo Dr', 'Oochtown', 'GA', 'USA', 'POST-SSS', '1597486', '4579512', 'b@c.com', 7);

-- 2.4 Update

update customer 
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5
select * from invoice where billingaddress like 'T%';

-- 2.6
select * from invoice where total >= 15 and total <= 50;

select * from employee where hiredate between '01-JUN-03' and '01-MAR-04'; 

delete from customer where firstname = 'Robert' and lastname = 'Walter';

-- 3.1 

create or replace function getSysdate
return date is

  l_sysdate date;

begin

  select sysdate
    into l_sysdate
    from dual;

  return l_sysdate;

end;
/

select getsysdate() from dual;

-- 3.2
select * from mediatype;
select * from invoice;
select avg(total) from invoice;

create or replace function avgInvoice
return number is
  average number;
begin
  select avg(total)
    into average
    from invoice;
  return average;
end;
/

select avgInvoice from dual;

select max(unitprice) from track;

create or replace function getMostExpensiveTrack
return number is
  price number;
begin
  select max(unitprice)
  into price
  from track;
  return price;

end;
/

select getMostExpensiveTrack from dual;

select * from invoice;

-- 3.3
create or replace function getAvgPriceInvoice
return number is
  price number;
begin
  select avg(unitprice)
  into price
  from invoiceline;
  return price;
end;
/

select * from invoiceline;
select getAvgPriceInvoice from dual;

select * from employee;

-- 3.4 taken from the GitHub archives
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/

SELECT AFTER_1968 FROM DUAL;

-- 4.1, taken from the GitHub archives
--CURSOR AS A PASS BY REFERENCE EXAMPLE
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(JUSTIN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN JUSTIN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--TESTING
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO FIRSTNAME, LASTNAME;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME);
  END LOOP;
END;
/

-- 7.1
select customer.firstname, invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.invoiceid;

-- 7.2
select invoice.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join invoice
on customer.customerid = invoice.invoiceid;

-- 7.3
select artist.name, album.title
from album
right join artist
on album.artistid = artist.artistid;

-- 7.4
select artist.name
from artist
cross join album
order by artist.name asc;

-- 7.5


