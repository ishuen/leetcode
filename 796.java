// 796. Rotate String
// We are given two strings, A and B.
//
// A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
//
// Example 1:
// Input: A = 'abcde', B = 'cdeab'
// Output: true
//
// Example 2:
// Input: A = 'abcde', B = 'abced'
// Output: false
// Note:
//
// A and B will have length at most 100.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
// Memory Usage: 36.7 MB, less than 82.77% of Java online submissions for Rotate String.

class Solution {
    public boolean rotateString(String A, String B) {
    if (A.length() == 0 && B.length() == 0) return true;
    int last = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i - last) == B.charAt(0)) {
        A = A.substring(i - last) + A.substring(0, i - last);
        if (A.equals(B)) {
          return true;
        }
        last = i;
      }
    }
    return false;
  }
}