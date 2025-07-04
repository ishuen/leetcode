// 242. Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//
// Example 1:
//
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
//
// Input: s = "rat", t = "car"
// Output: false
//
//
// Constraints:
//
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
//
//
// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
//
// Runtime: 10 ms, faster than 28.11% of Java online submissions for Valid Anagram.
// Memory Usage: 39.6 MB, less than 32.62% of Java online submissions for Valid Anagram.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count > 0) {
                map.put(c, count - 1);
            } else if (count == 1) {
                map.remove(c);
            } else return false;
        }
        return true;
    }
}


// Runtime: 3 ms, faster than 74.87% of Java online submissions for Valid Anagram.
// Memory Usage: 39.6 MB, less than 28.81% of Java online submissions for Valid Anagram.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapping = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapping[s.charAt(i) - 'a']++;
            mapping[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (mapping[i] != 0) return false;
        }
        return true;
    }
}

