// 1456. Maximum Number of Vowels in a Substring of Given Length
//
// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
// Example 1:
//
// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
// Example 2:
//
// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
// Example 3:
//
// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
// 1 <= k <= s.length
//
// Runtime 18 ms Beats 49.60% of users with Java
// Memory 43.46 MB Beats 84.27% of users with Java
class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int cur = 0;
        while(right < s.length()) {
            if (isVowel(s.charAt(right))) {
                cur++;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, cur);
                if (isVowel(s.charAt(left))) {
                    cur--;
                }
                left++;
            }
            right++;
        }
        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) > -1;
    }
}

// Runtime 13 ms Beats 65.64% of users with Java
// Memory 43.85 MB Beats 45.11% of users with Java
class Solution {
    public int maxVowels(String s, int k) {
        boolean[] vowels = new boolean[s.length()];
        int max = 0;
        int left = 0;
        int right = 0;
        int cur = 0;
        while(right < s.length()) {
            if (isVowel(s.charAt(right))) {
                vowels[right] = true;
                cur++;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, cur);
                if (vowels[left]) {
                    cur--;
                }
                left++;
            }
            right++;
        }
        return max;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) > -1;
    }
}