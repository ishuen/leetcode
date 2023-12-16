// 676. Implement Magic Dictionary
//
// Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
//
// Implement the MagicDictionary class:
//
// MagicDictionary() Initializes the object.
// void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
// bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
//
//
// Example 1:
//
// Input
// ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
// [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
// Output
// [null, null, false, true, false, false]
//
// Explanation
// MagicDictionary magicDictionary = new MagicDictionary();
// magicDictionary.buildDict(["hello", "leetcode"]);
// magicDictionary.search("hello"); // return False
// magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
// magicDictionary.search("hell"); // return False
// magicDictionary.search("leetcoded"); // return False
//
//
// Constraints:
//
// 1 <= dictionary.length <= 100
// 1 <= dictionary[i].length <= 100
// dictionary[i] consists of only lower-case English letters.
// All the strings in dictionary are distinct.
// 1 <= searchWord.length <= 100
// searchWord consists of only lower-case English letters.
// buildDict will be called only once before search.
// At most 100 calls will be made to search.
//
// Runtime 37 ms Beats 50.34% of users with Java
// Memory 45.25 MB Beats 49.66% of users with Java
class MagicDictionary {
    private Trie dictionary;

    class Trie {
        boolean isEndOfWord;
        Trie[] next;
        Trie() {
            this.next = new Trie[26];
        }
    }
    public MagicDictionary() {
        dictionary = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            Trie cur = this.dictionary;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEndOfWord = true;
        }

    }
    private boolean search(String searchWord, int index, boolean isChanged, Trie curTrie) {
        if (index == searchWord.length()) {
            if (isChanged == false) {
                return false;
            }
            return curTrie.isEndOfWord;
        }
        if (curTrie == null) return false;
        int charIndex = searchWord.charAt(index) - 'a';
        for (int i = 0; i < 26; i++) {
            if (curTrie.next[i] == null) continue;
            if (i != charIndex && isChanged == false) {
                if (search(searchWord, index + 1, true, curTrie.next[i])) return true;
            } else if (i == charIndex) {
                if(search(searchWord, index + 1, isChanged, curTrie.next[i])) return true;
            }
        }
        return false;
    }
    public boolean search(String searchWord) {
        return search(searchWord, 0, false, this.dictionary);
    }
}