// 2579. Count Total Number of Colored Cells
//
// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:
//
// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.
// Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
//
//
// Return the number of colored cells at the end of n minutes.
//
//
//
// Example 1:
//
// Input: n = 1
// Output: 1
// Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
// Example 2:
//
// Input: n = 2
// Output: 5
// Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5.
//
//
// Constraints:
//
// 1 <= n <= 10^5
//
//
// Runtime 3 ms Beats 39.59%
// Memory 40.86 MB Beats 18.40%
class Solution {
    public long coloredCells(int n) {
        if (n == 1) return 1;
        long total = 1;
        for (int i = 1; i < n; i++) {
            total = total + i * 4;
        }
        return total;
    }
}


/*
1
1 + 1 * 4 = 5
5 + 2 * 4 = 13 => (1 + 2) * 4 + 1
13 + 3 * 4 = 25 => (1 + 2 + 3) * 4 + 1
25 + 4 * 4 = 41 => (1 + 2 + 3 + 4) * 4 + 1

(1 + (n - 1)) * (n - 1) / 2 * 4 + 1 => n * (n - 1) * 2 + 1
*/

// Runtime 0 ms Beats 100.00%
// Memory 40.64 MB Beats 36.35%
class Solution {
    public long coloredCells(int n) {
        if (n == 1) return 1;
        long total = 2L * n * (n - 1) + 1;
        return total;
    }
}
