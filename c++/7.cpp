// 7. Reverse Integer
// Given a 32-bit signed integer, reverse digits of an integer.
// Example 1:
// Input: 123
// Output: 321
//
// Example 2:
// Input: -123
// Output: -321
//
// Example 3:
// Input: 120
// Output: 21
// Note:
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

// 16 ms, faster than 66.94%
class Solution {
public:
  int reverse(int x) {
    int res = 0;
    int sign = 1;
    if (x < 0) {
      x = -x;
      sign = -1;
    }
    while (x > 0) {
      int temp = x % 10;
      if (res > (INT_MAX - temp) / 10) return 0;
      res = res * 10 + temp;
      x = x / 10;
    }
    return sign * res;
  }
};

// 16 ms, faster than 66.94%
class Solution {
public:
  int reverse(int x) {
    int res = 0;
    bool neg = false;
    if (x < 0) {
      x = -x;
      neg = true;
    }
    while (x > 0) {
      int temp = x % 10;
      if (res > (INT_MAX - temp) / 10) return 0;
      res = res * 10 + temp;
      x = x / 10;
    }
    if (neg == true) return -res;
    return res;
  }
};
