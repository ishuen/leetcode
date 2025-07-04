// 125. Valid Palindrome
// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// Example 1:
//
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:
//
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
//
//
// Constraints:
//
// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.
//
// Runtime: 3 ms, faster than 69.31% of Java online submissions for Valid Palindrome.
// Memory Usage: 38.8 MB, less than 81.69% of Java online submissions for Valid Palindrome.
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isAlphabetic(s.charAt(start)) &&
               !Character.isDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isAlphabetic(s.charAt(end))&&
               !Character.isDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}