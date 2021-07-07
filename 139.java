// 139. Word Break
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
// Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//
//
// Example 1:
//
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:
//
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:
//
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
//
//
// Constraints:
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
//
//
// Runtime: 10 ms, faster than 20.26% of Java online submissions for Word Break.
// Memory Usage: 39.6 MB, less than 28.71% of Java online submissions for Word Break.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] sub = new boolean[s.length() + 1];
        sub[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i, j)) && sub[i] == true) {
                    sub[j] = true;
                }
            }  
        }
        return sub[s.length()];
    }
}

// [_,l,e,e,t,c,o,d,e]
// [t,f,f,f,t,f,f,f,t]

// Runtime: 7 ms, faster than 43.53% of Java online submissions for Word Break.
// Memory Usage: 39.2 MB, less than 55.44% of Java online submissions for Word Break.
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] sub = new boolean[s.length() + 1];
        sub[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (sub[j] && dict.contains(s.substring(j, i))){
                    sub[i] = true;
                    break;
                }
            }
        }
        
        return sub[s.length()];
    }
}