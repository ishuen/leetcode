// 208. Implement Trie (Prefix Tree)

// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

// Example 1:

// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
 

// Constraints:

// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith.

// Runtime 19 ms Beats 76.66%
// Memory 18.42 MB Beats 20.58%
type Trie struct {
    NextLayer []*Trie
    HasEnd bool
}


func Constructor() Trie {
    return Trie{
        NextLayer: make([]*Trie, 26),
    }   
}


func (this *Trie) Insert(word string)  {
    cur := this
    for index, char := range(word) {
        i := char - rune('a')
        if cur.NextLayer[i] == nil {
            cur.NextLayer[i] = &Trie{NextLayer: make([]*Trie, 26)}
        }
        cur = cur.NextLayer[i]
        if index == len(word) - 1 {
            cur.HasEnd = true
        }
    }
}


func (this *Trie) Search(word string) bool {
    cur := this
    for _, char := range(word) {
        i := char - rune('a')
        if cur.NextLayer[i] == nil {
            return false
        }
        cur = cur.NextLayer[i]
    }
    return cur.HasEnd
}


func (this *Trie) StartsWith(prefix string) bool {
    cur := this
    for _, char := range(prefix) {
        i := char - rune('a')
        if cur.NextLayer[i] == nil {
            return false
        }
        cur = cur.NextLayer[i]
    }
    return true
}