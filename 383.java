// 383. Ransom Note
//
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
// Each letter in magazine can only be used once in ransomNote.
//
//
//
// Example 1:
//
// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:
//
// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:
//
// Input: ransomNote = "aa", magazine = "aab"
// Output: true
//
//
// Constraints:
//
// 1 <= ransomNote.length, magazine.length <= 105
// ransomNote and magazine consist of lowercase English letters.
//
// Runtime 4 ms Beats 67.54%
// Memory 44.3 MB Beats 5.50%
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26];
        int[] ransomCounts = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            ransomCounts[c - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineCounts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomCounts[i] > magazineCounts[i]) return false;
        }
        return true;
    }
}

// Runtime 4 ms Beats 67.54%
// Memory 43.7 MB Beats 5.50%
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] magazineCounts = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineCounts[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (magazineCounts[c - 'a'] == 0) return false;
            magazineCounts[c - 'a']--;
        }
        return true;
    }
}