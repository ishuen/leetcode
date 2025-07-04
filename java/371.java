// 371. Sum of Two Integers
// Given two integers a and b, return the sum of the two integers without using the operators + and -.
//
// Example 1:
// Input: a = 1, b = 2
// Output: 3
// Example 2:
// Input: a = 2, b = 3
// Output: 5
//
// Constraints:
// -1000 <= a, b <= 1000
//
// Runtime: 7 ms, faster than 100.00% of Java online submissions for Sum of Two Integers.
// Memory Usage: 36.2 MB, less than 5.89% of Java online submissions for Sum of Two Integers.
class Solution {
    int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1); 
    }
}