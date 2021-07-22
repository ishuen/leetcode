// 43. Multiply Strings
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//
//
// Example 1:
//
// Input: num1 = "2", num2 = "3"
// Output: "6"
// Example 2:
//
// Input: num1 = "123", num2 = "456"
// Output: "56088"
//
//
// Constraints:
//
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//
// Runtime: 6 ms, faster than 45.89% of Java online submissions for Multiply Strings.
// Memory Usage: 38.9 MB, less than 82.27% of Java online submissions for Multiply Strings.
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                prev = prev + digit1 * digit2;
                int index = sb.length() - 1 - (num1.length() - i - 1) - (num2.length() - j - 1);
                if (i == num1.length() - 1 || index < 0) sb.insert(0, (char) (prev % 10 + '0'));
                else {
                    prev = prev + (sb.charAt(index) - '0');
                    sb.setCharAt(index, (char) (prev % 10 + '0'));
                }
                prev = prev / 10;
            }
            if (prev > 0) {
                sb.insert(0, (char) (prev % 10 + '0'));
                prev = 0;
            }
        }
        
        return sb.toString();
    }
}