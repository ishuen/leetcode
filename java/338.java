// 338. Counting Bits
//
// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//
//
//
// Example 1:
//
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// Example 2:
//
// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
//
//
// Constraints:
//
// 0 <= n <= 105
//
//
// Follow up:
//
// It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
// Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
//
// Runtime 2 ms Beats 58.85%
// Memory 46.8 MB Beats 42.31%
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        if (n == 0) return arr;
        arr[1] = 1;
        if (n == 1) return arr;
        int base = 2;
        int lastBase = 1;
        for (int i = 2; i <= n; i++) {
            if (i == base) {
                arr[i] = 1;
                base = base * 2;
                lastBase = i;
            } else {
                arr[i] = arr[lastBase] + arr[i - lastBase];
            }
        }
        return arr;
    }
}

// Runtime 1 ms Beats 99.64%
// Memory 46.5 MB Beats 78.52%
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        if (n == 0) return arr;
        arr[1] = 1;
        if (n == 1) return arr;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
           if (i % 2 == 0) {
               arr[i] = arr[i / 2];
           } else {
               arr[i] = arr[i / 2] + 1;
           }
        }
        return arr;
    }
}