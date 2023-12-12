// 1156. Swap For Longest Repeated Character Substring
//
// You are given a string text. You can swap two of the characters in the text.
//
// Return the length of the longest substring with repeated characters.
//
//
//
// Example 1:
//
// Input: text = "ababa"
// Output: 3
// Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa" with length 3.
// Example 2:
//
// Input: text = "aaabaaa"
// Output: 6
// Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa" with length 6.
// Example 3:
//
// Input: text = "aaaaa"
// Output: 5
// Explanation: No need to swap, longest repeated character substring is "aaaaa" with length is 5.
//
//
// Constraints:
//
// 1 <= text.length <= 2 * 104
// text consist of lowercase English characters only.
//
// Runtime 9 ms Beats 65.00% of users with Java
// Memory 40.66 MB Beats 94.00% of users with Java
class Solution {
    public int maxRepOpt1(String text) {
        int[] occurrences = new int[26];
        int max = 0;
        for (char c: text.toCharArray()) {
            occurrences[c - 'a']++;
        }   
       
        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > max) {
                max = Math.max(max, findMax((char)('a' + i), occurrences[i], text));
            }
        }
        return max;
    }

    private int findMax(char c, int count, String text) {
        int left = 0;
        int right = 0;
        int len = 0;
        boolean isSwapped = false;
        while (right < text.length()) {
            if (text.charAt(right) != c) {
                if (isSwapped == false) {
                    isSwapped = true;
                } else {
					while (left <= right && text.charAt(left) == c) {    
					    left++;          
                    }
                    left++;
                }
            }
            right++;
            len = Math.max(len, right - left);
        }
        return Math.min(len, count);
    }
}