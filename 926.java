// 926. Flip String to Monotone Increasing
// A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
//
// You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
//
// Return the minimum number of flips to make s monotone increasing.
//
//
//
// Example 1:
//
// Input: s = "00110"
// Output: 1
// Explanation: We flip the last digit to get 00111.
// Example 2:
//
// Input: s = "010110"
// Output: 2
// Explanation: We flip to get 011111, or alternatively 000111.
// Example 3:
//
// Input: s = "00011000"
// Output: 2
// Explanation: We flip to get 00000000.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s[i] is either '0' or '1'.
//
// Runtime: 29 ms, faster than 5.89% of Java online submissions for Flip String to Monotone Increasing.
// Memory Usage: 51.9 MB, less than 5.26% of Java online submissions for Flip String to Monotone Increasing.
class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] zeros = new int[len + 1];
        int[] ones = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            zeros[i] = zeros[i - 1];
            if (s.charAt(i - 1) == '1') {
                zeros[i] += 1;
            }
        } // zero [0, 0, 0, 0, 1, 2, 2, 2, 2]
        for (int i = len - 1; i >= 0; i--) {
            ones[i] = ones[i + 1];
            if (s.charAt(i) == '0') {
                ones[i] += 1;
            }
        } // one [6, 5, 4, 3, 3, 3, 2, 1, 0]
        int min = len;
        for (int i = 0; i <= len; i++) {
            // System.out.println(zeros[i] + " " + ones[i]);
            if (min > zeros[i] + ones[i]) {
                min = zeros[i] + ones[i];
            }
        }
        return min;
    }
}

// Runtime: 12 ms, faster than 24.61% of Java online submissions for Flip String to Monotone Increasing.
// Memory Usage: 39 MB, less than 99.51% of Java online submissions for Flip String to Monotone Increasing.
class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int ones = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') ones++;
        }
        int min = len - ones;
        int zeros = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') zeros++;
            min = Math.min(min, len - i - 1 - ones + 2 * zeros);
        }
        return min;
    }
}

// Runtime: 11 ms, faster than 27.08% of Java online submissions for Flip String to Monotone Increasing.
// Memory Usage: 47.1 MB, less than 6.66% of Java online submissions for Flip String to Monotone Increasing.
class Solution {
    public int minFlipsMonoIncr(String s) {
        int flipToZeroCount = 0;
        int flipToOneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (flipToZeroCount == 0) continue;
                flipToOneCount++;   
            } else {
                flipToZeroCount++;
            }
            flipToOneCount = Math.min(flipToZeroCount, flipToOneCount);
        }
        return flipToOneCount;
    }
}