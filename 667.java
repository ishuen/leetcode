// 667. Beautiful Arrangement II
// Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
//
// Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
// Return the list answer. If there multiple valid answers, return any of them.
//
//
//
// Example 1:
//
// Input: n = 3, k = 1
// Output: [1,2,3]
// Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
// Example 2:
//
// Input: n = 3, k = 2
// Output: [1,3,2]
// Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
//
//
// Constraints:
//
// 1 <= k < n <= 104
//
// Runtime 0 ms Beats 100%
// Memory 42.9 MB Beats 59.46%
class Solution {
    public int[] constructArray(int n, int k) {
        int distance = n - k;
        int[] arr = new int[n];
        for (int i = k; i < n; i++) {
            arr[i] = i + 1;
        }
        int base = 1;
        for (int i = k - 1; i >= 0; i = i - 2) {
            arr[i] = base;
            if (i - 1 >= 0) arr[i - 1] = arr[k] - base;
            base++;
        }
        return arr;
    }
}