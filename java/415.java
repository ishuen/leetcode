// 415. Add Strings
// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
//
// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
//
//
//
// Example 1:
//
// Input: num1 = "11", num2 = "123"
// Output: "134"
// Example 2:
//
// Input: num1 = "456", num2 = "77"
// Output: "533"
// Example 3:
//
// Input: num1 = "0", num2 = "0"
// Output: "0"
//
//
// Constraints:
//
// 1 <= num1.length, num2.length <= 104
// num1 and num2 consist of only digits.
// num1 and num2 don't have any leading zeros except for the zero itself.
//
// Runtime: 8 ms, faster than 17.24% of Java online submissions for Add Strings.
// Memory Usage: 40.7 MB, less than 5.11% of Java online submissions for Add Strings.
class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() -1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) {
                sum = sum + Character.getNumericValue(num1.charAt(index1));
                index1--;
            }
            if (index2 >= 0) {
                sum = sum + Character.getNumericValue(num2.charAt(index2));
                index2--;
            }
            sb.insert(0, sum % 10);
            sum = sum / 10;
        }
        if (sum != 0) sb.insert(0, sum);
        return sb.toString();
    }
}

// stringbuilder insert (0, sum % 10)
// int sum 4
// 1: 1
// 2: 3