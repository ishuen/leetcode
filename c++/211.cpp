// 211. Add and Search Word - Data structure design
// Design a data structure that supports the following two operations:
//
// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
// Example:
//
// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.

// Time Limit Exceeded
class WordDictionary {
public:
  std::vector<string> words;
  /** Initialize your data structure here. */
  WordDictionary() {
  }
  
  /** Adds a word into the data structure. */
  void addWord(string word) {
      this->words.push_back(word);
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  bool search(string word) {
    int length = words.size();
    for (int i = 0; i < length; i++) {
      if(std::regex_match(this->words[i], std::regex(word))) {
        return true;
      }
    }
    return false;
  }
};

// prefix tree
// The regex in this problem only includes '.', which means that there is no other special characters.
// 52 ms, faster than 96.54%
class WordDictionary {
public:
  struct Node {
  public:
    Node *child[26];
    bool isWord;
    Node(): isWord(false) {
      for (auto &c : child) c = NULL;
    }
  };

  WordDictionary() {
    root = new Node();
  }

  void addWord(string word) {
    Node *p = root;
    int i = 0;
    for (auto &c : word) {
      i = c - 'a';
      if (!p->child[i]) p->child[i] = new Node();
        p = p->child[i];
      }
      p->isWord = true;
  }
  bool search(string word) {
    return searchWord(word, root, 0);
  }

  bool searchWord(string &word, Node *p, int i) {
    if (i == word.size()) return p->isWord;
    if (word[i] == '.') {
      for (auto &c : p->child) {
        if (c && searchWord(word, c, i + 1)) return true;
      }
      return false;
    }
    else {
      return p->child[word[i] - 'a'] && searchWord(word, p->child[word[i] - 'a'], i + 1);
    }
  }

private:
  Node *root;
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */