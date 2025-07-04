// 60. Permutation Sequence
// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
//
//
//
// Example 1:
//
// Input: n = 3, k = 3
// Output: "213"
// Example 2:
//
// Input: n = 4, k = 9
// Output: "2314"
// Example 3:
//
// Input: n = 3, k = 1
// Output: "123"
//
//
// Constraints:
//
// 1 <= n <= 9
// 1 <= k <= n!
//
// Runtime: 1 ms, faster than 96.86% of Java online submissions for Permutation Sequence.
// Memory Usage: 36.6 MB, less than 46.63% of Java online submissions for Permutation Sequence.
class Solution {
    public String getPermutation(int n, int k) {
        return getPermutation(n, 0, k, new boolean[n]);
    }
    public String getPermutation(int remained, int per, int target, boolean[] used) {
        int gap = countPermutation(remained - 1);
        int count = 1;
        for (int i = 0; i < used.length; i++) {
            if (used[i] == true) continue;
            if (per + 1 * gap >= target) {
                used[i] = true;
                return String.valueOf(i + 1) + getPermutation(remained - 1, per, target, used);
            }
            else if (per + count * gap >= target && per + (count - 1) * gap < target) { 
                used[i] = true;
                return String.valueOf(i + 1) + getPermutation(remained - 1, per + (count - 1) * gap, target, used); 
            }
            count++;
        }
        return "";
    }
    
    public int countPermutation(int remained) {
        int product = 1;
        for (int i = 2; i <= remained; i++) {
            product *= i;
        }
        return product;
    }
}

// array = n, boolean
// permutation = 1 .. n!
// count the permutation