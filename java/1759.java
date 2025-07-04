// 1759. Count Number of Homogenous Substrings
//
// Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
//
// A string is homogenous if all the characters of the string are the same.
//
// A substring is a contiguous sequence of characters within a string.
//
//
//
// Example 1:
//
// Input: s = "abbcccaa"
// Output: 13
// Explanation: The homogenous substrings are listed as below:
// "a"   appears 3 times.
// "aa"  appears 1 time.
// "b"   appears 2 times.
// "bb"  appears 1 time.
// "c"   appears 3 times.
// "cc"  appears 2 times.
// "ccc" appears 1 time.
// 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
// Example 2:
//
// Input: s = "xy"
// Output: 2
// Explanation: The homogenous substrings are "x" and "y".
// Example 3:
//
// Input: s = "zzzzz"
// Output: 15
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase letters.
//
// Runtime 9ms Beats 80.00%of users with Java
// Memory 44.42MB Beats 20.00%of users with Java
class Solution {
    public int countHomogenous(String s) {
        int base = 0;
        char baseChar = s.charAt(base);
        int pointer = 1;
        long counter = 1;
        double sum = 0;
        double mod = Math.pow(10, 9) + 7;
		int len = s.length();

		while (pointer < len) { 
            if (baseChar == s.charAt(pointer)) {
                counter++;
            } else {
                double diff = ((1 + counter) * counter / 2) % mod;
                sum = (diff + sum) % mod;
                counter = 1;
                base = pointer;
                baseChar = s.charAt(base);
            }
            pointer++;
        }
        double diff = ((1 + counter) * counter / 2) % mod;
        sum = (diff + sum) % mod;
        return (int) sum;
    }
}
