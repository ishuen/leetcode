-- 196. Delete Duplicate Emails
-- Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id is the primary key column for this table.
-- For example, after running your query, the above Person table should have the following rows:
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- Note:
--
-- Your output is the whole Person table after executing your sql. Use delete statement.

-- Runtime: 2361 ms, faster than 7.25% of MySQL online submissions for Delete Duplicate Emails.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Delete Duplicate Emails.
DELETE FROM Person
WHERE Id NOT IN (
  SELECT id FROM (
    SELECT MIN(p.Id) AS id FROM Person AS p GROUP BY p.Email
  ) AS temp);
  
-- Runtime: 2182 ms, faster than 10.49% of MySQL online submissions for Delete Duplicate Emails.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Delete Duplicate Emails.
DELETE p1
FROM Person AS p1, Person AS p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id;