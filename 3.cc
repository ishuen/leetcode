// 3. Longest Substring Without Repeating Characters
// Given a string, find the length of the longest substring without repeating characters.
//
// Example 1:
// Input: "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
// Example 2:
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
// Example 3:
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
//    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// 20 ms, faster than 85.79%
class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    unordered_map<char, int> indices;
    int start = 0, res = 0;
    int len = s.size();
    for (int i = 0; i < len; i++) {
      if(indices.count(s[i])) start = max(start, indices[s[i]] + 1);
      res = max(res, i-start+1);
      indices[s[i]] = i;
    }
    return res;
  }
};