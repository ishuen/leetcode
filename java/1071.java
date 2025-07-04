// 1071. Greatest Common Divisor of Strings
//
// For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
//
// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
//
//
//
// Example 1:
//
// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:
//
// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:
//
// Input: str1 = "LEET", str2 = "CODE"
// Output: ""
//
//
// Constraints:
//
// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of English uppercase letters.
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 40.98 MB Beats 82.56% of users with Java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        if (str2.length() > str1.length()) {
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }
        if (str1.indexOf(str2) == 0) {
            str1 = str1.substring(str2.length());
            return gcdOfStrings(str1, str2);
        }
        return "";
    }
}
