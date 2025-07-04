// 14. Longest Common Prefix
//
// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
//
//
// Example 1:
//
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:
//
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Constraints:
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.
//
// Runtime 1 ms Beats 80.91% of users with Java
// Memory 39.95 MB Beats 91.20% of users with Java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];
        int right = base.length();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < right; j++) {
                if (j == strs[i].length()) {
                    right = j;
                    break;
                }
                if (strs[i].charAt(j) != base.charAt(j)) {
                    right = j;
                    break;
                }
            }
        }
        return base.substring(0, right);
    }
}