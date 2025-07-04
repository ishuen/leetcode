// 301. Remove Invalid Parentheses
// Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
//
// Return all the possible results. You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: s = "()())()"
// Output: ["(())()","()()()"]
// Example 2:
//
// Input: s = "(a)())()"
// Output: ["(a())()","(a)()()"]
// Example 3:
//
// Input: s = ")("
// Output: [""]
//
//
// Constraints:
//
// 1 <= s.length <= 25
// s consists of lowercase English letters and parentheses '(' and ')'.
// There will be at most 20 parentheses in s.
//
// Runtime: 49 ms, faster than 41.64% of Java online submissions for Remove Invalid Parentheses.
// Memory Usage: 39.7 MB, less than 42.84% of Java online submissions for Remove Invalid Parentheses.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(0) == ')') sb.delete(0, 1);
            else break;
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(') sb.delete(i, i + 1);
            else break;
        }
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                leftCount++;
            } else if (sb.charAt(i) == ')') {
                leftCount--;
                if (leftCount == -1) {
                    rightCount++;
                    leftCount = 0;
                }
            }
        }
        Set<String> ans = new HashSet<>();
        removeInvalid(sb, leftCount, rightCount, ans);
        return new ArrayList<>(ans);
    }
    private void removeInvalid(StringBuilder sb, int leftCount, int rightCount, Set<String> ans) {
        if (leftCount == 0 && rightCount == 0 && isValid(sb)) {
            ans.add(sb.toString());
        }
        int lastIndex = -2;
        if (leftCount > 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(') {
                    if (i == lastIndex + 1) {
                        lastIndex++;
                        continue;
                    }
                    sb.delete(i, i + 1);
                    removeInvalid(sb, leftCount - 1, rightCount, ans);
                    sb.insert(i, '(');
                    lastIndex = i;
                }
            }
        } else if (rightCount > 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ')') {
                     if (i == lastIndex + 1) {
                        lastIndex++;
                        continue;
                    }
                    sb.delete(i, i + 1);
                    removeInvalid(sb, leftCount, rightCount - 1, ans);
                    sb.insert(i, ')');
                    lastIndex = i;
                }
            }
        }
    }
    
    private boolean isValid(StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                count++;
            } else if (sb.charAt(i) == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}

// Runtime: 1 ms, faster than 99.90% of Java online submissions for Remove Invalid Parentheses.
// Memory Usage: 39.3 MB, less than 57.21% of Java online submissions for Remove Invalid Parentheses.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    public void remove(String s, List<String> ans, int lastIndex, int lastRemoved,  char[] par) {
        int count = 0;
        for (int i = lastIndex; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1]) count--;
            if (count >= 0) continue;
            for (int j = lastRemoved; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == lastRemoved || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}