// 869. Reordered Power of 2
//
// You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//
// Return true if and only if we can do this so that the resulting number is a power of two.
//
//
//
// Example 1:
//
// Input: n = 1
// Output: true
// Example 2:
//
// Input: n = 10
// Output: false
//
//
// Constraints:
//
// 1 <= n <= 109
//
// Runtime 1 ms Beats 95.63%
// Memory 39.5 MB Beats 85.63%
class Solution {
    public boolean reorderedPowerOf2(int n) {
        if (n == 1) return true;
        String str = String.valueOf(n);
        int numOfDigit = str.length();
        int[] occurrence = new int[10];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            occurrence[c - '0']++;
        }
        int base = 1;
        String str2 = String.valueOf(base);
        while (str2.length() <= numOfDigit) {
            if (str2.length() == numOfDigit) {
                int[] map = new int[10];
                for (int i = 0; i < str2.length(); i++) {
                    char c = str2.charAt(i);
                    map[c - '0']++;
                }
                boolean match = true;
                for (int i = 0; i < 10; i++) {
                    if (map[i] != occurrence[i]) {
                        match = false;
                        break;
                    }
                }
                if (match == true) return true;
            }
            base = base * 2;
            str2 = String.valueOf(base);
        }
        return false;
    }
}