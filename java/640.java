// 640. Solve the Equation
// Solve a given equation and return the value of 'x' in the form of a string "x=#value". The equation contains only '+', '-' operation, the variable 'x' and its coefficient. You should return "No solution" if there is no solution for the equation, or "Infinite solutions" if there are infinite solutions for the equation.
//
// If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.
//
//
//
// Example 1:
//
// Input: equation = "x+5-3+x=6+x-2"
// Output: "x=2"
// Example 2:
//
// Input: equation = "x=x"
// Output: "Infinite solutions"
// Example 3:
//
// Input: equation = "2x=x"
// Output: "x=0"
// Example 4:
//
// Input: equation = "2x+3x-6x=x+2"
// Output: "x=-1"
// Example 5:
//
// Input: equation = "x=x+2"
// Output: "No solution"
//
//
// Constraints:
//
// 3 <= equation.length <= 1000
// equation has exactly one '='.
// equation consists of integers with an absolute value in the range [0, 100] without any leading zeros, and the variable 'x'.
//
// Runtime: 3 ms, faster than 85.94% of Java online submissions for Solve the Equation.
// Memory Usage: 37.4 MB, less than 66.67% of Java online submissions for Solve the Equation.
class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] left = new int[2]; // [variable, constant]
        int[] right = new int[2];
        rearrange(eq[0], left);
        rearrange(eq[1], right);
        if (left[0] == right[0] && left[1] == right[1]) return "Infinite solutions";
        if (left[0] == right[0] && left[1] != right[1]) return "No solution";
        return "x=" + ((right[1] - left[1]) / (left[0] - right[0]));
    }
    
    private void rearrange(String ex, int[] pair) {
        int sign = 1;
        int constant = 0;
        boolean hasZero = false;
        boolean isVariable = false;
        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            if (Character.isDigit(c)) {
                constant = constant * 10 + Character.getNumericValue(c);
                if (constant == 0) hasZero = true;
            } else if (c == 'x') {
                isVariable = true;
            } 
            if (c == '+' || c == '-' || i == ex.length() - 1){
                if (isVariable == true) {
                    if (constant == 0 && hasZero == false) pair[0] = pair[0] + sign * 1; 
                    else {
                        pair[0] = pair[0] + sign * constant;
                        hasZero = false;
                    }
                } else {
                    pair[1] = pair[1] + sign * constant;
                }
                if (c == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
                constant = 0;
                isVariable = false;
            }
        }
    }
}