// 696. Count Binary Substrings
//   Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//   Substrings that occur multiple times are counted the number of times they occur.
//
//   Example 1:
//
//   Input: "00110011"
//   Output: 6
//   Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
//
//   Notice that some of these substrings repeat and are counted the number of times they occur.
//
//   Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//   Example 2:
//
//   Input: "10101"
//   Output: 4
//   Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//   Note:
//
//   s.length will be between 1 and 50,000.
//   s will only consist of "0" or "1" characters.
//
// Runtime: 8 ms, faster than 92.06% of Java online submissions for Count Binary Substrings.
// Memory Usage: 39.1 MB, less than 6.04% of Java online submissions for Count Binary Substrings.
class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int count = 0;
        int firstHalf = 0;
        int sndHalf = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                sndHalf++;
            } else {
                firstHalf = sndHalf;
                sndHalf = 1;
            }
            if (firstHalf >= sndHalf) count++;
        }
        return count;
    }
}