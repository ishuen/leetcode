// 394. Decode String
// Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
// Example 1:
//
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:
//
// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:
//
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
// Example 4:
//
// Input: s = "abc3[cd]xyz"
// Output: "abccdcdcdxyz"
//
//
// Constraints:
//
// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].
//
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
// Memory Usage: 37 MB, less than 76.33% of Java online submissions for Decode String.
class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder(s);
        str.append(']');
        str = decodeString(str, 0, 1);
        return str.toString();
    }
    private StringBuilder decodeString(StringBuilder str, int start, int repeat) {
        StringBuilder substr = new StringBuilder();
        int num = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - '0' < 10 && c - '0' >= 0) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                substr.append(decodeString(str, i + 1, num));
                int bracket = 1;
                for (int j = i + 2; j < str.length(); j++) {
                    if (str.charAt(j) == '[') bracket++;
                    if (str.charAt(j) == ']') {
                        bracket--;
                        if (bracket == 0) {
                            i = j;
                            break;
                        }
                    }
                }
                num = 0;
            } else if (c == ']') {
                String sub = substr.toString();
                for (int j = 1; j < repeat; j++) {
                    substr.append(sub);
                }
                return substr;
            } else {
                substr.append(c);
            }
        }
        return substr;
    }
}

// every string is 1[string]

// if digit, value of that digit
// * if the next is still a digit, prev * 10 + new digit

// if [ start new function call, if ] return the internal stuff

// append the string

// Runtime: 1 ms, faster than 61.86% of Java online submissions for Decode String.
// Memory Usage: 37.4 MB, less than 33.26% of Java online submissions for Decode String.
public class Solution {
    public String decodeString(String s) {
        StringBuilder draft = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int count = c - '0';
                index++;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            }
            else if (c == '[') {
                resStack.push(draft);
                draft = new StringBuilder();
                index++;
            }
            else if (c == ']') {
                StringBuilder temp = resStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(draft);
                }
                draft = temp;
                index++;
            }
            else {
                draft.append(c);
                index++;
            }
        }
        return draft.toString();
    }
}

