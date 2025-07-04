// 522. Longest Uncommon Subsequence II
// Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.
//
// An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
//
// A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
//
// For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
//
//
// Example 1:
//
// Input: strs = ["aba","cdc","eae"]
// Output: 3
// Example 2:
//
// Input: strs = ["aaa","aaa","aa"]
// Output: -1
//
//
// Constraints:
//
// 1 <= strs.length <= 50
// 1 <= strs[i].length <= 10
// strs[i] consists of lowercase English letters.
//
// Runtime: 1 ms, faster than 92.93% of Java online submissions for Longest Uncommon Subsequence II.
// Memory Usage: 36.2 MB, less than 90.22% of Java online submissions for Longest Uncommon Subsequence II.
class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < max) continue;
            int curLen = -1;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSub(strs[i], strs[j])) {
                    curLen = -1;
                    break;
                }
                curLen = strs[i].length();
            }
            if (curLen > max) max = curLen;
        }
        return max;
    }
    
    private boolean isSub(String a, String b) {
        if (a.equals(b)) return true;
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}