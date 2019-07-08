--
-- @lc app=leetcode id=175 lang=mysql
--
-- [175] Combine Two Tables
--
# Write your MySQL query statement below

SELECT FirstName, LastName, City, State 
FROM Person 
LEFT JOIN Address
ON Person.PersonId = Address.PersonId

