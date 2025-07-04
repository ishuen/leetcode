// 241. Different Ways to Add Parentheses
// Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
//
//
// Example 1:
//
// Input: expression = "2-1-1"
// Output: [0,2]
// Explanation:
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Example 2:
//
// Input: expression = "2*3-4*5"
// Output: [-34,-14,-10,-10,10]
// Explanation:
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
//
//
// Constraints:
//
// 1 <= expression.length <= 20
// expression consists of digits and the operator '+', '-', and '*'.
//
// Runtime: 1 ms, faster than 98.16% of Java online submissions for Different Ways to Add Parentheses.
// Memory Usage: 38.9 MB, less than 60.02% of Java online submissions for Different Ways to Add Parentheses.
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (isOperator(expression.charAt(i))) {
                left = diffWaysToCompute(expression.substring(0, i));
                right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (int l: left) {
                    for (int r: right) {
                        switch(expression.charAt(i)) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) list.add(Integer.parseInt(expression));
        return list;
    }
                
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}