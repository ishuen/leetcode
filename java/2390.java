// 2390. Removing Stars From a String
//
// You are given a string s, which contains stars *.
//
// In one operation, you can:
//
// Choose a star in s.
// Remove the closest non-star character to its left, as well as remove the star itself.
// Return the string after all stars have been removed.
//
// Note:
//
// The input will be generated such that the operation is always possible.
// It can be shown that the resulting string will always be unique.
//
//
// Example 1:
//
// Input: s = "leet**cod*e"
// Output: "lecoe"
// Explanation: Performing the removals from left to right:
// - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
// - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
// - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
// There are no more stars, so we return "lecoe".
// Example 2:
//
// Input: s = "erase*****"
// Output: ""
// Explanation: The entire string is removed, so we return an empty string.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase English letters and stars *.
// The operation above can be performed on s.
//
// Runtime 459 ms Beats 24.06% of users with Java
// Memory 46.56 MB Beats 26.31% of users with Java
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else if (c != '*'){
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}


// Runtime 305 ms Beats 29.81% of users with Java
// Memory 45.52 MB Beats 41.37% of users with Java
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        int toRemove = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
               toRemove++;
               sb.deleteCharAt(i);
            } else if (toRemove > 0) {
                sb.deleteCharAt(i);
                toRemove--;
            }
        }
        return sb.toString();
    }
}


// Runtime 15 ms Beats 96.59% of users with Java
// Memory 45.23 MB Beats 53.17% of users with Java
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int toRemove = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
               toRemove++;
            } else if (toRemove > 0) {
                toRemove--;
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}