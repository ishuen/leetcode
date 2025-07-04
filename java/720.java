// 720. Longest Word in Dictionary
// Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
//
// If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
//
//
//
// Example 1:
//
// Input: words = ["w","wo","wor","worl","world"]
// Output: "world"
// Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
// Example 2:
//
// Input: words = ["a","banana","app","appl","ap","apply","apple"]
// Output: "apple"
// Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//
//
// Constraints:
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 30
// words[i] consists of lowercase English letters.
//
// Runtime: 6 ms, faster than 86.19% of Java online submissions for Longest Word in Dictionary.
// Memory Usage: 39.3 MB, less than 64.39% of Java online submissions for Longest Word in Dictionary.
class Solution {
    public String longestWord(String[] words) {
        Node root = buildTree(words);
        return dfs(root, true);
    }
    
    private Node buildTree(String[] words) {
        Node root = new Node();
        for (String word: words) {
            Node pointer = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (pointer.next[index] == null) pointer.next[index] = new Node();
                pointer = pointer.next[index];
            }
            pointer.word = word;
        }
        return root;
    }
    
    private String dfs(Node root, boolean isRoot) {
        if (isRoot == false && root.word == null) return "";
        int max = root.word == null ? 0 : root.word.length();
        String maxString = root.word == null ? "" : root.word;
        for (int i = 0; i < 26; i++) {
            if (root.next[i] == null) continue;
            String str = dfs(root.next[i], false);
            if (str.length() > max) {
                max = str.length();
                maxString = str;
            }
        }
        return maxString;
    }
    
    
    class Node{
        Node[] next = new Node[26];
        String word;
    }
}
// prefix tree
// dfs traverse all nodes and find the longest