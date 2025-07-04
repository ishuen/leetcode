// 592. Fraction Addition and Subtraction
// Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
//
// The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
//
//
//
// Example 1:
//
// Input: expression = "-1/2+1/2"
// Output: "0/1"
// Example 2:
//
// Input: expression = "-1/2+1/2+1/3"
// Output: "1/3"
// Example 3:
//
// Input: expression = "1/3-1/2"
// Output: "-1/6"
//
//
// Constraints:
//
// The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
// Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
// The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
// The number of given fractions will be in the range [1, 10].
// The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
//
// Runtime 4 ms Beats 95.40%
// Memory 40.3 MB Beats 100%
class Solution {
    public String fractionAddition(String expression) {
        int curNo = 0;
        int curDe = 1;
        int index = 0;
        Boolean isNextPositive = true;
        int nextNo = 0;
        int nextDe = 0;
        while (index < expression.length()) {
            nextNo = 0;
            nextDe = 0;
            if (expression.charAt(index) == '-') {
                isNextPositive = false;
                index++;
            } else if (expression.charAt(index) == '+') {
                isNextPositive = true;
                index++;
            } else {
                isNextPositive = true;
            }
            
            while (expression.charAt(index) != '/') {
                nextNo = nextNo * 10 + Character.getNumericValue(expression.charAt(index));
                index++;
            }
            if (isNextPositive == false) {
                nextNo = nextNo * (-1);
            }
            index++;
            while (index < expression.length() && expression.charAt(index) != '+' && expression.charAt(index) != '-') {
                nextDe = nextDe * 10 + Character.getNumericValue(expression.charAt(index));
                index++;
            }
            curNo = curNo * nextDe + nextNo * curDe;
            curDe = curDe * nextDe;
            int common = findCommonDivisor(Math.abs(curNo), curDe);
            if (common != 0) {
                curNo = curNo / common;
                curDe = curDe / common;
            } else {
                curDe = 1;
            }            
        }
        return String.valueOf(curNo) + "/" + String.valueOf(curDe);
    }

    private int findCommonDivisor(int curNo, int curDe) {
        if (curNo == 0 || curDe == 0) return 0;
        if (curNo == curDe) return curNo;
        if (curNo > curDe) return findCommonDivisor(curNo - curDe, curDe);
        else return findCommonDivisor(curDe - curNo, curNo);
    }
}