// 670. Maximum Swap
// You are given an integer num. You can swap two digits at most once to get the maximum valued number.
//
// Return the maximum valued number you can get.
//
//
//
// Example 1:
//
// Input: num = 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
// Example 2:
//
// Input: num = 9973
// Output: 9973
// Explanation: No swap.
//
//
// Constraints:
//
// 0 <= num <= 108
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Swap.
// Memory Usage: 35.6 MB, less than 90.15% of Java online submissions for Maximum Swap.
class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] lastIndexes = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndexes[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (i < lastIndexes[j]) {
                    digits[lastIndexes[j]] = digits[i];
                    digits[i] = (char) (j + '0');
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}

// bucket [0, 1, 2,  .. 9] last index of digit in num with bucket index occured