// 166. Fraction to Recurring Decimal
// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in parentheses.
//
// If multiple answers are possible, return any of them.
//
// It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
//
// Example 1:
//
// Input: numerator = 1, denominator = 2
// Output: "0.5"
// Example 2:
//
// Input: numerator = 2, denominator = 1
// Output: "2"
// Example 3:
//
// Input: numerator = 2, denominator = 3
// Output: "0.(6)"
// Example 4:
//
// Input: numerator = 4, denominator = 333
// Output: "0.(012)"
// Example 5:
//
// Input: numerator = 1, denominator = 5
// Output: "0.2"
//
// Constraints:
//
// -231 <= numerator, denominator <= 231 - 1
// denominator != 0
//
// Runtime: 8 ms, faster than 17.39% of Java online submissions for Fraction to Recurring Decimal.
// Memory Usage: 36.8 MB, less than 30.48% of Java online submissions for Fraction to Recurring Decimal.
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        String sign = numerator < 0 ^ denominator < 0 ? "-" : "";
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long integral = n / d;
        n = n % d;
        if (n == 0) return sign + String.valueOf(integral);
        StringBuilder sb = new StringBuilder(sign + String.valueOf(integral) + '.');
        Map<Long, Integer> repeatIndex = new HashMap<>();
        while(n > 0) {
            n = n * 10;
            if (repeatIndex.containsKey(n)) {
                int index = repeatIndex.get(n);
                sb.insert(index, '(');
                sb.append(')');
                return sb.toString();
            }
            integral = n / d;
            sb.append(integral);
            repeatIndex.put(n, sb.length() - 1);
            n = n % d;
        }
        return sb.toString();
    }
}