// 567. Permutation in String
//
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
// In other words, return true if one of s1's permutations is the substring of s2.
//
//
//
// Example 1:
//
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:
//
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
//
//
// Constraints:
//
// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.
//
// Runtime 24 ms Beats 42.11%
// Memory 43.3 MB Beats 11.18%
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> refMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            refMap.put(c, refMap.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        while (end < s2.length()) {
            Character c = s2.charAt(end);
            if (!refMap.containsKey(c)) {
                end++;
                start = end;
                map.clear();
                continue;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (end - start + 1 > s1.length()) {
                char toRemove = s2.charAt(start);
                map.put(toRemove, map.get(toRemove) - 1);
                start++;
            }
            if (end - start + 1 == s1.length()) {
                if (refMap.equals(map)) return true;
            }
            end++;
        }
        return false;
    }
}
