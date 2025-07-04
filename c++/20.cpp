// 20. Valid Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.
//
// Example 1:
//
// Input: "()"
// Output: true
// Example 2:
//
// Input: "()[]{}"
// Output: true
// Example 3:
//
// Input: "(]"
// Output: false
// Example 4:
//
// Input: "([)]"
// Output: false
// Example 5:
//
// Input: "{[]}"
// Output: true

// 0 ms, faster than 100.00%
class Solution {
public:
  bool isValid(string s) {
    int len = s.size();
    if (len % 2 == 1) return false;
    vector<char> p;
    for (int i = 0; i < len; i++) {
      if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
        p.push_back(s[i]);
      }  else if ((s[i] == ')' || s[i] == ']' || s[i] == '}') && p.size() == 0) {
        return false;
      } else if (s[i] == ')' && p.back() == '(') {
        p.pop_back();
      } else if (s[i] == ']' && p.back() == '[') {
        p.pop_back();
      } else if (s[i] == '}' && p.back() == '{') {
        p.pop_back();
      }
    } 
    if (p.size() > 0) return false;
    return true;
  }
};