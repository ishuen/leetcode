// 916. Word Subsets
//
// You are given two string arrays words1 and words2.
//
// A string b is a subset of string a if every letter in b occurs in a including multiplicity.
//
// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.
//
// Return an array of all the universal strings in words1. You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]
// Example 2:
//
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
// Output: ["apple","google","leetcode"]
//
//
// Constraints:
//
// 1 <= words1.length, words2.length <= 104
// 1 <= words1[i].length, words2[i].length <= 10
// words1[i] and words2[i] consist only of lowercase English letters.
// All the strings of words1 are unique.

// Runtime 19 ms Beats 37.16%
// Memory 53.1 MB Beats 15.30%
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] words1Map = new int[26];
        int[] words2Map = new int[26];
        for (int i = 0; i < words2.length; i++) {
            int[] tempMap = new int[26];
            for (int j = 0; j < words2[i].length(); j++) {
                int index = words2[i].charAt(j) - 'a';
                tempMap[index]++;
                words2Map[index] = Math.max(words2Map[index], tempMap[index]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) { 
            Arrays.fill(words1Map, 0);
            for (int j = 0; j < words1[i].length(); j++) {
                words1Map[words1[i].charAt(j) - 'a']++;
            }           
            if (isSubSet(words1Map, words2Map)) {
                ans.add(words1[i]);
            }
        }
        return ans;
    }

    private boolean isSubSet(int[] word1, int[] word2) {
        for (int i = 0; i < 26; i++) {
            if (word1[i] < word2[i]) {
                return false;
            }
        }
        return true;
    }
}