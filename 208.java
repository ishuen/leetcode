// 208. Implement Trie (Prefix Tree)
//   Implement a trie with insert, search, and startsWith methods.
//
//   Example:
//
//   Trie trie = new Trie();
//
//   trie.insert("apple");
//   trie.search("apple");   // returns true
//   trie.search("app");     // returns false
//   trie.startsWith("app"); // returns true
//   trie.insert("app");
//   trie.search("app");     // returns true
//   Note:
//
//   You may assume that all inputs are consist of lowercase letters a-z.
//   All inputs are guaranteed to be non-empty strings.
// Runtime: 32 ms, faster than 60.44% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 49.9 MB, less than 5.10% of Java online submissions for Implement Trie (Prefix Tree).

class Trie {

    Node root;
    class Node {
        boolean isEnd;
        Node[] nextLayer;
        public Node() {
            isEnd = false;
            nextLayer = new Node[26];
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.nextLayer[index] == null) {
                cur.nextLayer[index] = new Node();
            }
            cur = cur.nextLayer[index];
            if (i == arr.length - 1) {
                cur.isEnd = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.nextLayer[index] == null) {
                return false;
            }
            cur = cur.nextLayer[index];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Node cur = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (cur.nextLayer[index] == null) {
                return false;
            }
            cur = cur.nextLayer[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */