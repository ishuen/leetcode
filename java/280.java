// 279. Perfect Squares
// Given an integer n, return the least number of perfect square numbers that sum to n.
//
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
//
//
//
// Example 1:
//
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:
//
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
//
//
// Constraints:
//
// 1 <= n <= 104

// Runtime 2137 ms Beats 5.1%
// Memory 41.6 MB Beats 87.30%
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i <= n/2; i++) {
            if (i * i <= n) {
                nums[i * i - 1] = 1;
            }
        }
        if (nums[n - 1] == 1) return 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) continue;
            int min = nums[i - 1] + 1;
            for (int j = i - 2; j >= i / 2; j--) {
                if (nums[j] + nums[i - j - 1] < min) {
                    min = nums[j] + nums[i - j - 1];
                }
            }
            nums[i] = min;
        }
        return nums[n - 1];
    }
}


// Runtime 45 ms Beats 72.89%
// Memory 42.8 MB Beats 75.51%
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = i;
            for (int j = 1; j * j <= i; j++) {
                nums[i] = Math.min(nums[i], nums[i - j * j] + 1);
            }
        }
        return nums[n];
    }
}