/** Employees and Costumers that are named the same **/
SELECT FIRSTNAME FROM CUSTOMER
INTERSECT
SELECT FIRSTNAME FROM EMPLOYEE;

/** Unique names between customer and employee **/
SELECT FIRSTNAME, 'CUSTOMER' FROM CUSTOMER
UNION
SELECT FIRSTNAME, 'EMPLOYEE' FROM EMPLOYEE;

/** Unique names between customer and employee (AND WHEN THEY REPEAT: Steve, Robert) **/
SELECT FIRSTNAME, 'CUSTOMER' FROM CUSTOMER
UNION ALL
SELECT FIRSTNAME, 'EMPLOYEE' FROM EMPLOYEE ORDER BY FIRSTNAME;

/** Employee Names that Customer don't have **/
SELECT FIRSTNAME FROM EMPLOYEE
MINUS
SELECT FIRSTNAME FROM CUSTOMER ORDER BY FIRSTNAME;