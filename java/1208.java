// 1208. Get Equal Substrings Within Budget
//
// You are given two strings s and t of the same length and an integer maxCost.
//
// You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
//
// Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.
//
//
//
// Example 1:
//
// Input: s = "abcd", t = "bcdf", maxCost = 3
// Output: 3
// Explanation: "abc" of s can change to "bcd".
// That costs 3, so the maximum length is 3.
// Example 2:
//
// Input: s = "abcd", t = "cdef", maxCost = 3
// Output: 1
// Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
// Example 3:
//
// Input: s = "abcd", t = "acde", maxCost = 0
// Output: 1
// Explanation: You cannot make any change, so the maximum length is 1.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// t.length == s.length
// 0 <= maxCost <= 106
// s and t consist of only lowercase English letters.
//
// Runtime 7 ms Beats 72.26% of users with Java
// Memory 44.03 MB Beats 12.44% of users with Java
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int left = 0;
        int right = 0;
        int cost = 0;
        int maxLen = 0;
        while (right < sArr.length && left <= right) {
            int diff = (int) Math.abs(sArr[right] - tArr[right]);
            if (cost + diff <= maxCost) {
                cost += diff;
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else if (left < right){
                cost = cost - (int) Math.abs(sArr[left] - tArr[left]);
                left++;
            } else {
                right++;
                left++;
                cost = 0;
            }
        }
        return maxLen;
    }
}


// Runtime 5 ms Beats 95.80% of users with Java
// Memory 43.21 MB Beats 81.56% of users with Java
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int left = 0;
        int right = 0;
        int cost = 0;
        int maxLen = 0;
        while (right < sArr.length && left <= right) {
            int diff = (int) Math.abs(sArr[right] - tArr[right]);
            cost += diff;
            if (cost <= maxCost) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            while (cost > maxCost){
                cost = cost - (int) Math.abs(sArr[left] - tArr[left]);
                left++;
            }
            right++;
        }
        return maxLen;
    }
}