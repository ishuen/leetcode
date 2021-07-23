// 28. Implement strStr()
// Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great question to ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//
//
//
// Example 1:
//
// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:
//
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Example 3:
//
// Input: haystack = "", needle = ""
// Output: 0
//
//
// Constraints:
//
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack and needle consist of only lower-case English characters.
//
// Runtime: 1697 ms, faster than 9.26% of Java online submissions for Implement strStr().
// Memory Usage: 39 MB, less than 37.34% of Java online submissions for Implement strStr().
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        int start = -1;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}

// Runtime: 308 ms, faster than 28.91% of Java online submissions for Implement strStr().
// Memory Usage: 39.7 MB, less than 7.97% of Java online submissions for Implement strStr().
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; ++i) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

