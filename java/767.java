// 767. Reorganize String
// Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
// If possible, output any possible result.  If not possible, return the empty string.
//
// Example 1:
//
// Input: s = "aab"
// Output: "aba"
// Example 2:
//
// Input: s = "aaab"
// Output: ""
// Note:
//
// s will consist of lowercase letters and have length in range [1, 500].
//
// Runtime: 1 ms, faster than 82.22% of Java online submissions for Reorganize String.
// Memory Usage: 38.5 MB, less than 26.76% of Java online submissions for Reorganize String.
class Solution {
    public String reorganizeString(String s) {
        if (s.length() <= 1) return s;
        char[] chars = new char[26];
        int max = 0;
        char letter = 'a';
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            chars[c]++;
            if (chars[c] > max) {
                max = chars[c];
                letter = (char) ('a' + c);
            }
        }
        if ((s.length() > 3 && max * 2 > s.length() + 1)) return "";
        char[] ans = new char[s.length()];
        int i = 0;
        while (chars[letter - 'a'] > 0) {
            ans[i] = letter;
            i += 2;
            chars[letter - 'a']--;
        }
        
        for (int j = 0; j < chars.length; j++) {
            while(chars[j] > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                ans[i] =(char) (j + 'a');
                i += 2;
                chars[j]--;
            }
        }
        return String.valueOf(ans);
    }
}