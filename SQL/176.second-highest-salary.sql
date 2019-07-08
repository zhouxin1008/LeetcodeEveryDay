--
-- @lc app=leetcode id=176 lang=mysql
--
-- [176] Second Highest Salary
--
# Write your MySQL query statement below
SELECT (
  SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1
) AS SecondHighestSalary

SELECT MAX(Salary) AS SecondHighestSalary FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)

