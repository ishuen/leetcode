// 96. Unique Binary Search Trees
// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
//
// Example 1:
// Input: n = 3
// Output: 5
// Example 2:
// Input: n = 1
// Output: 1
//
// Constraints:
//
// 1 <= n <= 19
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
// Memory Usage: 35.7 MB, less than 54.48% of Java online submissions for Unique Binary Search Trees.
class Solution {
    public int numTrees(int n) {
        int[] levelCombinations = new int[n+1];
        levelCombinations[0] = 1;
        levelCombinations[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                levelCombinations[i] = levelCombinations[i] + levelCombinations[j - 1] * levelCombinations[i - j];
            }
        }
        return levelCombinations[n];
    }
}

// n = 1 -> 1
// n = 2 -> 2
// 1 - r: 2, 2 -- l: 1
// n = 3 -> 5
// 1 - r: 2, 3 => 2
// 2 - l: 1, r: 3 => 1
// 3 - l: 1, 2 => 2

// n: root 1..n
// sum (left sub * right sub)