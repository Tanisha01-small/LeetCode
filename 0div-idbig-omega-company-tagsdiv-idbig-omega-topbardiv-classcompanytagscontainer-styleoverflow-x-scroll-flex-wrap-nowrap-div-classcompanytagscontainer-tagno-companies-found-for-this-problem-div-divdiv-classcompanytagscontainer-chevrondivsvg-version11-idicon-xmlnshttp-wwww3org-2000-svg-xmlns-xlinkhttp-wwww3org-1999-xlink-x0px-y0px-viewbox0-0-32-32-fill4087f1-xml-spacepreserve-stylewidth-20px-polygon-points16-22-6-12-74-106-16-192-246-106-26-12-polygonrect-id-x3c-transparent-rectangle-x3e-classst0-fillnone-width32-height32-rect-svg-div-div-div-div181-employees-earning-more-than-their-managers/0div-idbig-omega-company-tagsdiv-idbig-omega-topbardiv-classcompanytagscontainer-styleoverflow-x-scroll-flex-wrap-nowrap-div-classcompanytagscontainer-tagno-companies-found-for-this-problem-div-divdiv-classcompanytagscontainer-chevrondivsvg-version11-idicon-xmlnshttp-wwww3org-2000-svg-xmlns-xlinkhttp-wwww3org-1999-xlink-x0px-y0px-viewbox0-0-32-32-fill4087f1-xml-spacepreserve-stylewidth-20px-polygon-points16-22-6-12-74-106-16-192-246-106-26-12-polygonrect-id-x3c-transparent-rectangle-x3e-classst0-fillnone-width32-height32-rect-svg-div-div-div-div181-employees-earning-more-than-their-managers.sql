# Write your MySQL query statement below
Select w.name as Employee 
from Employee w Join Employee m
on m.id=w.managerId 
where w.salary>m.salary ;