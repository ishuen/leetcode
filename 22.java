// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]
// Constraints:
// 1 <= n <= 8
//
//
// Runtime: 1 ms, faster than 69.03% of Java online submissions for Generate Parentheses.
// Memory Usage: 40.2 MB, less than 5.24% of Java online submissions for Generate Parentheses.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        findCombinations(new StringBuilder(), 0, 0, n, list);
        return list;
    }
    private void findCombinations(StringBuilder str, int left, int right, int max, List<String> list) {
        if (left == max && right == max) {
            list.add(str.toString());
            return;
        }
        if (left < max) {
            findCombinations(str.append("("), left + 1, right, max, list);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < left) {
            findCombinations(str.append(")"), left, right + 1, max, list);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

