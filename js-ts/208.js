// 208. Implement Trie (Prefix Tree)
//
// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
// Implement the Trie class:
//
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
//
//
// Example 1:
//
// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]
//
// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
//
//
// Constraints:
//
// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith.
//
// Runtime 321 ms Beats 6.62% of users with JavaScript
// Memory 64.22 MB Beats 60.37% of users with JavaScript
var Trie = function() {
    this.root = new Node();
};

class Node {
    constructor(next = {}, isEndOfWord = false) {
        this.next = next;
        this.isEndOfWord = isEndOfWord;
    }
}
/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let pointer = this.root;
    let index = 0;
    while (index < word.length) {
        if (!pointer.next[word[index]]) {
            pointer.next[word[index]] = new Node();
        }
        pointer = pointer.next[word[index]];
        index++;
    }
    pointer.isEndOfWord = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let cur = this.root;
    let index = 0;
    while (index < word.length) {
        if (!cur.next[word[index]]) return false;
        cur = cur.next[word[index]];
        index++;
    }
    return cur.isEndOfWord;
};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let cur = this.root;
    let index = 0;
    while (index < prefix.length) {
        if (!cur.next[prefix[index]]) return false;
        cur = cur.next[prefix[index]];
        index++;
    }
    return true;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */



// Runtime 293 ms Beats 9.56% of users with JavaScript
// Memory 64.69 MB Beats 54.71% of users with JavaScript
var Trie = function() {
    this.root = new Node();
};

class Node {
    constructor(next = {}, isEndOfWord = false) {
        this.next = next;
        this.isEndOfWord = isEndOfWord;
    }
}
/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let pointer = this.root;
    for (let char of word) {
        if (!pointer.next[char]) {
            pointer.next[char] = new Node();
        }
        pointer = pointer.next[char];
    }
    pointer.isEndOfWord = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let cur = this.root;
    for (let char of word) {
        if (!cur.next[char]) return false;
        cur = cur.next[char];
    }
    return cur.isEndOfWord;
};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let cur = this.root;
    for (let char of prefix) {
        if (!cur.next[char]) return false;
        cur = cur.next[char];
    }
    return true;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */