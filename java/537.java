// 537. Complex Number Multiplication
// A complex number can be represented as a string on the form "real+imaginaryi" where:
//
// real is the real part and is an integer in the range [-100, 100].
// imaginary is the imaginary part and is an integer in the range [-100, 100].
// i2 == -1.
// Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
//
//
//
// Example 1:
//
// Input: num1 = "1+1i", num2 = "1+1i"
// Output: "0+2i"
// Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
// Example 2:
//
// Input: num1 = "1+-1i", num2 = "1+-1i"
// Output: "0+-2i"
// Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
//
//
// Constraints:
//
// num1 and num2 are valid complex numbers.
//
// Runtime: 4 ms, faster than 81.16% of Java online submissions for Complex Number Multiplication.
// Memory Usage: 37.2 MB, less than 78.62% of Java online submissions for Complex Number Multiplication.
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        String[] arr2 = num2.split("\\+");
        int[] ans = new int[2];
        for (String s: arr1) {
            if (s.contains("i")) {
                ans[1] = Integer.parseInt(s.substring(0, s.length() - 1));
            } else {
                ans[0] = Integer.parseInt(s);
            }
        }
        int tempI = 0;
        int tempC = 0;
        int v = 0;
        for (String s: arr2) {
            if (s.contains("i")) {
                int value = Integer.parseInt(s.substring(0, s.length() - 1));
                tempI = ans[0] * value;
                tempC = ans[1] * value * (-1);
            } else {
                v = Integer.parseInt(s);
            }
        }
        ans[0] = ans[0] * v + tempC;
        ans[1] = ans[1] * v + tempI;
        return ans[0] + "+" + ans[1] + "i"; 
    }
}