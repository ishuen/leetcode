// 1047. Remove All Adjacent Duplicates In String
// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//
// We repeatedly make duplicate removals on s until we no longer can.
//
// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
//
//
//
// Example 1:
//
// Input: s = "abbaca"
// Output: "ca"
// Explanation:
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
// Example 2:
//
// Input: s = "azxxzy"
// Output: "ay"
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
//
// Runtime: 52 ms, faster than 25.61% of Java online submissions for Remove All Adjacent Duplicates In String.
// Memory Usage: 39.5 MB, less than 59.05% of Java online submissions for Remove All Adjacent Duplicates In String.
class Solution {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()) {
            output.insert(0, stack.pop());
        }
        return output.toString();
    }
}

// Runtime: 5 ms, faster than 92.42% of Java online submissions for Remove All Adjacent Duplicates In String.
// Memory Usage: 39.1 MB, less than 97.97% of Java online submissions for Remove All Adjacent Duplicates In String.
class Solution {
    public String removeDuplicates(String s) {
        char[] output = new char[s.length()];
        int endIndex = 1;
        output[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (endIndex > 0 && output[endIndex - 1] == s.charAt(i)) {
                endIndex--;
            } else {
                output[endIndex] = s.charAt(i);
                endIndex++;
            }
        }
        return new String(output, 0, endIndex);
    }
}