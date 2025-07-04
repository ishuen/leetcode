// 541. Reverse String II
//
// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
//
// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
//
//
//
// Example 1:
//
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Example 2:
//
// Input: s = "abcd", k = 2
// Output: "bacd"
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 104
//
// Runtime 3 ms Beats 22.35%
// Memory 43.3 MB Beats 68.58%
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int iteration = 0;
        while (iteration * 2 * k + 1 <= s.length()) {
            int base = iteration * 2 * k;
            int reverseIndex = base + k - 1;
            while (reverseIndex >= s.length()) {
                reverseIndex--;
            }
            while (reverseIndex >= base) {
                sb.append(s.charAt(reverseIndex));
                reverseIndex--;
            }
            if (base + k < s.length()) {
                int tail = Math.min(base + 2 * k, s.length());
                sb.append(s.substring(base + k, tail));
            }
            iteration++;
        }
        return sb.toString();
    }
}

// Runtime 1 ms Beats 100%
// Memory 43.8 MB Beats 18.65%
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int iteration = 0;
        while (iteration * 2 * k + 1 <= s.length()) {
            int base = iteration * 2 * k;
            int reverseLast = Math.min(base + k, s.length());
            StringBuilder sub = new StringBuilder(s.substring(base, reverseLast));
            sub.reverse();
            sb.append(sub);
            if (base + k < s.length()) {
                int tail = Math.min(base + 2 * k, s.length());
                sb.append(s.substring(base + k, tail));
            }
            iteration++;
        }
        return sb.toString();
    }
}
