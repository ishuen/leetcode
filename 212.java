// 212. Word Search II
// Given an m x n board of characters and a list of strings words, return all words on the board.
//
// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//
//
// Example 1:
//
//
// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
// Example 2:
//
//
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
//
//
// Constraints:
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.
//
// Runtime: 137 ms, faster than 64.55% of Java online submissions for Word Search II.
// Memory Usage: 37.9 MB, less than 65.62% of Java online submissions for Word Search II.
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildPrefixTree(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, ans);
            }
        }
        return ans;
    }
    
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void search(char[][] board, int row, int col, Node root, List<String> ans) {
        char c = board[row][col];
        if (c == '.' || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        board[row][col] = '.';
        for (int i = 0; i < 4; i++) {
            if (row + directions[i][0] < 0 || row + directions[i][0] >= board.length || col + directions[i][1] < 0 || col + directions[i][1] >= board[0].length) continue;
            search(board, row + directions[i][0], col + directions[i][1], root, ans);
        }
        board[row][col] = c;
    }
    
    private class Node {
        Node[] next = new Node[26];
        String word;
    }
    private Node buildPrefixTree(String[] words) {
        Node root = new Node();
        for (String word: words) {
            Node pointer = root;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (pointer.next[arr[i] - 'a'] == null) {
                    pointer.next[arr[i] - 'a'] = new Node();
                }
                pointer = pointer.next[arr[i] - 'a'];
            }
            pointer.word = word;
        }
        return root;
    }
}