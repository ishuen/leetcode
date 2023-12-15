// 1170. Compare Strings by Frequency of the Smallest Character
//
// Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.
//
// You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.
//
// Return an integer array answer, where each answer[i] is the answer to the ith query.
//
//
//
// Example 1:
//
// Input: queries = ["cbd"], words = ["zaaaz"]
// Output: [1]
// Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
// Example 2:
//
// Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
// Output: [1,2]
// Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
//
//
// Constraints:
//
// 1 <= queries.length <= 2000
// 1 <= words.length <= 2000
// 1 <= queries[i].length, words[i].length <= 10
// queries[i][j], words[i][j] consist of lowercase English letters.
//
//
// Runtime 6 ms Beats 63.46% of users with Java
// Memory 43.74 MB Beats 82.05% of users with Java
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        TreeMap<Integer, Integer> wordFreq = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            int freq = f(words[i]);
            wordFreq.put(freq, wordFreq.getOrDefault(freq, 0) + 1);
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int freq = f(queries[i]);
            if (!sumMap.containsKey(freq)) {
                Map<Integer, Integer> tailMap = wordFreq.tailMap(freq, false);
                int sum = 0;
                for (int value: tailMap.values()) {
                    sum = sum + value;
                }
                sumMap.put(freq, sum);
            }
            ans[i] = sumMap.get(freq);
        }
        return ans;
    }
    private int f(String word) {
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }
        int min = word.length();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            return counts[i];
        }
        return 0;
    }
}


// Runtime 2 ms Beats 96.15% of users with Java
// Memory 43.87 MB Beats 67.31% of users with Java
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] wordFreq = new int[12];
        for (int i = 0; i < words.length; i++) {
            int freq = f(words[i]);
            wordFreq[freq]++;
        }
        for (int i = 9; i >= 0; i--) {
            wordFreq[i] += wordFreq[i + 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int freq = f(queries[i]);
            ans[i] = wordFreq[freq + 1];
        }
        return ans;
    }
    private int f(String word) {
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }
        int min = word.length();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            return counts[i];
        }
        return 0;
    }
}