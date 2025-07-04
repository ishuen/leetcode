// Number of Matching Subsequences
// Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
//
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
// For example, "ace" is a subsequence of "abcde".
//
//
// Example 1:
//
// Input: s = "abcde", words = ["a","bb","acd","ace"]
// Output: 3
// Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
// Example 2:
//
// Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
// Output: 2
//
//
// Constraints:
//
// 1 <= s.length <= 5 * 104
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 50
// s and words[i] consist of only lowercase English letters.

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Integer> wMap = new HashMap<>();
        for (String word : words) {
            wMap.put(word, wMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wMap.entrySet()) {
            String word = entry.getKey();
            int indexW = 0;
            int indexS = 0;
            if (word.length() > s.length()) continue; 
            while(indexW < word.length() && indexS < s.length()) {
                if (s.charAt(indexS) == word.charAt(indexW)) {
                    indexS++;
                    indexW++;
                    if (indexW == word.length()) {
                        count = count + entry.getValue();
                        break;
                    }
                } else indexS++;
            }
        }
        return count;
    }
}