// 5. Longest Palindromic Substring
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//   Example 1:
//
//   Input: "babad"
//   Output: "bab"
//   Note: "aba" is also a valid answer.
//   Example 2:
//
//   Input: "cbbd"
//   Output: "bb"

// 12 ms, faster than 75.05%

class Solution {
public:
  string longestPalindrome(string s) {
    int length = s.size();
    if (length == 0) return s;
    int maxLen = 1;
    string maxStr = string(1, s[0]);
    for (int i = 0; i < length; i++) {
      if (i + 1 > 0 && s[i] == s[i+1]) {
        int tempLen = 2;
        int j = 1;
        while (i - j >= 0 && i + j < length) {
          if (s[i - j] == s[i + 1 + j]) {
            tempLen = tempLen + 2;
            j = j + 1;
          } else {
            break;
          }
        }
        if (tempLen > maxLen) {
          maxLen = tempLen;
          maxStr = s.substr(i - j + 1, tempLen);
        }
      }
        int tempLen = 1;
        int k = 1;
        while (i - k >= 0 && i + k < length) {
          if (s[i - k] == s[i + k]) {
            tempLen += 2;
            k = k + 1;
          } else {
            break;
          }
        }
        if (tempLen > maxLen) {
          maxLen = tempLen;
          maxStr = s.substr(i - k + 1, tempLen);
        }
      }
    return maxStr;
  }
};