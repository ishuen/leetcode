// 67. Add Binary
// Given two binary strings, return their sum (also a binary string).
//
// The input strings are both non-empty and contains only characters 1 or 0.
//
// Example 1:
//
// Input: a = "11", b = "1"
// Output: "100"
// Example 2:
//
// Input: a = "1010", b = "1011"
// Output: "10101"

// 4 ms, faster than 52.18%

class Solution {
public:
  string addBinary(string a, string b) {
    int len1 = a.size() - 1;
    int len2 = b.size() - 1;
    int next = 0;
    string result = "";
    while (len1 >= 0 || len2 >= 0 || next == 1) {
      if (len1 >= 0) {
        next = next + a[len1] - '0';
        len1--;
      }
      if (len2 >= 0) {
        next = next + b[len2] - '0';
        len2--;
      }
      result = char(next%2 + '0') + result;
      if (next <= 1) {
        next = 0;
      } else {
        next = 1;
      }
    }
    return result;
  }
};