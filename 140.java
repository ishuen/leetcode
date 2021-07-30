// 140. Word Break II
// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
//
// Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//
//
// Example 1:
//
// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]
// Example 2:
//
// Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
// Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
// Explanation: Note that you are allowed to reuse a dictionary word.
// Example 3:
//
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: []
//
//
// Constraints:
//
// 1 <= s.length <= 20
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 10
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
//
// Runtime: 4 ms, faster than 66.30% of Java online submissions for Word Break II.
// Memory Usage: 37.8 MB, less than 36.56% of Java online submissions for Word Break II.
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        wordBreak(s, "", wordDict, ans);
        return ans;
    }

    private void wordBreak(String s, String temp, List<String> wordDict, List<String> ans) {
        if (s.isEmpty()) {
            ans.add(temp.substring(1));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                wordBreak(s.substring(i), temp + " " + sub, wordDict, ans);
            }
        }
    }
}

// StringBuilder tempSB
// recursive function s, tempSB, wordDict, finList
// s == empty -> add tempSB to list
// for (int i = 1 .. s.length())
// wordDict.contains(s.substring(0, i))
//  if true: append it to sb, recursive call s.substring(i)


// Runtime: 5 ms, faster than 36.13% of Java online submissions for Word Break II.
// Memory Usage: 37.9 MB, less than 25.23% of Java online submissions for Word Break II.
class Solution {
    Map<Integer, List<String>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("");
        memo.put(s.length(), list);
        return wordBreak(s, 0, wordDict);
    }
    
    private List<String> wordBreak(String s, int start, List<String> wordDict) {
        if (memo.containsKey(start)) return memo.get(start);

        List<String> list = new ArrayList<>();
        String sub = s.substring(start);
        for (String word: wordDict) {
            if (sub.startsWith(word)) {
                List<String> subList = wordBreak(s, start + word.length(), wordDict);
                for (String substr : subList) {
                    list.add(word + (substr.isEmpty() ? "" : " ") + substr);
                }
            }
        }
        memo.put(start, list);
        return list;
    }
}