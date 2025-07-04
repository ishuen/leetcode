-- 626. Exchange Seats
-- Table: Seat
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | student     | varchar |
-- +-------------+---------+
-- id is the primary key column for this table.
-- Each row of this table indicates the name and the ID of a student.
-- id is a continuous increment.
--
--
-- Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
--
-- Return the result table ordered by id in ascending order.
--
-- The query result format is in the following example.
--
--
--
-- Example 1:
--
-- Input:
-- Seat table:
-- +----+---------+
-- | id | student |
-- +----+---------+
-- | 1  | Abbot   |
-- | 2  | Doris   |
-- | 3  | Emerson |
-- | 4  | Green   |
-- | 5  | Jeames  |
-- +----+---------+
-- Output:
-- +----+---------+
-- | id | student |
-- +----+---------+
-- | 1  | Doris   |
-- | 2  | Abbot   |
-- | 3  | Green   |
-- | 4  | Emerson |
-- | 5  | Jeames  |
-- +----+---------+
-- Explanation:
-- Note that if the number of students is odd, there is no need to change the last one's seat.
--
--
-- Runtime 1004 ms Beats 5.4%
SELECT IF (id % 2 = 1 && id = (SELECT Count(*) FROM Seat), id, IF (id % 2 = 1, id + 1, id - 1)) AS id, student 
FROM Seat 
ORDER BY id;

-- Runtime 504 ms Beats 87.22%
SELECT IF (id % 2 = 0, id - 1, IF (id = (SELECT Count(*) FROM Seat), id, id + 1))AS id, student 
FROM Seat 
ORDER BY id;