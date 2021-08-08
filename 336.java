// 336. Palindrome Pairs
// Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
//
//
//
// Example 1:
//
// Input: words = ["abcd","dcba","lls","s","sssll"]
// Output: [[0,1],[1,0],[3,2],[2,4]]
// Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
// Example 2:
//
// Input: words = ["bat","tab","cat"]
// Output: [[0,1],[1,0]]
// Explanation: The palindromes are ["battab","tabbat"]
// Example 3:
//
// Input: words = ["a",""]
// Output: [[0,1],[1,0]]
//
//
// Constraints:
//
// 1 <= words.length <= 5000
// 0 <= words[i].length <= 300
// words[i] consists of lower-case English letters.
//
// Runtime: 111 ms, faster than 45.11% of Java online submissions for Palindrome Pairs.
// Memory Usage: 95.1 MB, less than 6.41% of Java online submissions for Palindrome Pairs.
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, ans);
        }
        return ans;
    }
    
    private void search(Node root, String word, int index, List<List<Integer>> ans) {
        Node pointer = root;
        for (int i = 0; i < word.length(); i++) {
            if (pointer.endWord != -1 && pointer.endWord != index && isPalindrome(word, i, word.length() - 1)) {
                List<Integer> pair = new LinkedList<>();
                pair.add(index);
                pair.add(pointer.endWord);
                ans.add(pair);
            }
            if (pointer.next[word.charAt(i) - 'a'] == null) return;
            pointer = pointer.next[word.charAt(i) - 'a'];
        }
        if (pointer.endWord != -1 && pointer.endWord != index) {
            List<Integer> pair = new LinkedList<>();
            pair.add(index);
            pair.add(pointer.endWord);
            ans.add(pair);
        }
        for (Integer wordIndex: pointer.indexes) {
            if (wordIndex == index) continue;
            List<Integer> pair = new LinkedList<>();
            pair.add(index);
            pair.add(wordIndex);
            ans.add(pair);
        }
    }
    
    private void addWord(Node root, String word, int index) {
        Node pointer = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (pointer.next[j] == null) {
                pointer.next[j] = new Node();
            }
            if (isPalindrome(word, 0, i)) {
                pointer.indexes.add(index);
            }
            pointer = pointer.next[j];
        }
        pointer.endWord = index;
    }
    
    class Node {
        Node[] next = new Node[26];
        List<Integer> indexes = new ArrayList<>();
        int endWord = -1;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}