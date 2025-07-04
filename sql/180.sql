-- 180. Consecutive Numbers
-- Table: Logs
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | num         | varchar |
-- +-------------+---------+
-- id is the primary key for this table.
--
--
-- Write an SQL query to find all numbers that appear at least three times consecutively.
--
-- Return the result table in any order.
--
-- The query result format is in the following example:
--
--
--
-- Logs table:
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  | 1   |
-- | 2  | 1   |
-- | 3  | 1   |
-- | 4  | 2   |
-- | 5  | 1   |
-- | 6  | 2   |
-- | 7  | 2   |
-- +----+-----+
--
-- Result table:
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- 1 is the only number that appears consecutively for at least three times.
--
--
-- Runtime: 384 ms, faster than 89.16% of MySQL online submissions for Consecutive Numbers.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.

SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l1.Num = l2.Num
AND l1.Num = l3.Num
AND l1.Id + 1 = l2.Id
AND l1.Id + 2 = l3.Id;