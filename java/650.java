// 650. 2 Keys Keyboard
// There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:
//
// Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
// Paste: You can paste the characters which are copied last time.
// Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
//
//
//
// Example 1:
//
// Input: n = 3
// Output: 3
// Explanation: Intitally, we have one character 'A'.
// In step 1, we use Copy All operation.
// In step 2, we use Paste operation to get 'AA'.
// In step 3, we use Paste operation to get 'AAA'.
// Example 2:
//
// Input: n = 1
// Output: 0
//
//
// Constraints:
//
// 1 <= n <= 1000
//
// Runtime: 7 ms, faster than 61.89% of Java online submissions for 2 Keys Keyboard.
// Memory Usage: 35.9 MB, less than 71.94% of Java online submissions for 2 Keys Keyboard.
class Solution {
    public int minSteps(int n) {
        int[] counts = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            counts[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    counts[i] = counts[j] + i / j;
                    break;
                }
            }
        }
        return counts[n];
    }
}