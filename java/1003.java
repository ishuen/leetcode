// 1003. Check If Word Is Valid After Substitutions
// Given a string s, determine if it is valid.
//
// A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
//
// Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
// Return true if s is a valid string, otherwise, return false.
//
//
//
// Example 1:
//
// Input: s = "aabcbc"
// Output: true
// Explanation:
// "" -> "abc" -> "aabcbc"
// Thus, "aabcbc" is valid.
// Example 2:
//
// Input: s = "abcabcababcc"
// Output: true
// Explanation:
// "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
// Thus, "abcabcababcc" is valid.
// Example 3:
//
// Input: s = "abccba"
// Output: false
// Explanation: It is impossible to get "abccba" using the operation.
// Example 4:
//
// Input: s = "cababc"
// Output: false
// Explanation: It is impossible to get "cababc" using the operation.
//
//
// Constraints:
//
// 1 <= s.length <= 2 * 104
// s consists of letters 'a', 'b', and 'c'
//
// Runtime: 7 ms, faster than 80.48% of Java online submissions for Check If Word Is Valid After Substitutions.
// Memory Usage: 39.2 MB, less than 72.53% of Java online submissions for Check If Word Is Valid After Substitutions.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}