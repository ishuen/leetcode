// 438. Find All Anagrams in a String
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
// Example 1:
//
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:
//
// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
// Constraints:
//
// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.
//
// Runtime 13 ms Beats 54.5%
// Memory 43 MB Beats 96.27%
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] stringArr = new int[26];
        int[] patternArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            stringArr[s.charAt(i) - 'a']++;
            patternArr[p.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = p.length() - 1; i < s.length(); i++) {
            if (Arrays.equals(stringArr, patternArr)) {
                list.add(i - p.length() + 1);
            }
            stringArr[s.charAt(i - p.length() + 1) - 'a']--;
            if (i == s.length() - 1) break;
            stringArr[s.charAt(i + 1) - 'a']++;
        }
        return list;
    }
}