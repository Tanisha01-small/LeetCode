# Write your MySQL query statement below
SELECT Customers.name AS Customers FROM Customers LEFT JOIN Orders on Customers.id=Orders.customerId WHERE Orders.customerId is NULL;

