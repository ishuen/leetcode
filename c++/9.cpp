// 9. Palindrome Number
// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
// Example 1:
// Input: 121
// Output: true
//
// Example 2:
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
// Example 3:
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
// Follow up:
// Coud you solve it without converting the integer to a string?

// 188 ms, faster than 41.40%
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        string str = to_string(x);
        string rev = str;
        reverse(rev.begin(), rev.end());
        return rev == str;
    }
};

// 172 ms, faster than 50.35%
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        string str = to_string(x);
        int len = str.size();
        int half = len / 2;
        for (int i = 0; i < half; i++) {
            if (str[i] != str[len - i - 1]) return false;
        }
        return true;
        
    }
};

// 168 ms, faster than 53.14%
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x);
    }
    int reverse(int x) {
    int res = 0;
    while (x > 0) {
      int temp = x % 10;
      if (res > (INT_MAX - temp) / 10) return 0;
      res = res * 10 + temp;
      x = x / 10;
    }
    return res;
    }
};