// 848. Shifting Letters
// You are given a string s of lowercase English letters and an integer array shifts of the same length.
//
// Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
//
// For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
// Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
//
// Return the final string after all such shifts to s are applied.
//
//
//
// Example 1:
//
// Input: s = "abc", shifts = [3,5,9]
// Output: "rpl"
// Explanation: We start with "abc".
// After shifting the first 1 letters of s by 3, we have "dbc".
// After shifting the first 2 letters of s by 5, we have "igc".
// After shifting the first 3 letters of s by 9, we have "rpl", the answer.
// Example 2:
//
// Input: s = "aaa", shifts = [1,2,3]
// Output: "gfd"
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
// shifts.length == s.length
// 0 <= shifts[i] <= 109
//
// Runtime 13 ms Beats 71.71%
// Memory 51.5 MB Beats 85.41%
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            count = (count + shifts[i])%26;
            sb.setCharAt(i, shift(s.charAt(i), count));
        }
        return sb.toString();
    }
    private char shift(char c, int move) {
        return (char) ('a' + ((c - 'a') + move ) % 26);
    }

}