// 784. Letter Case Permutation
// Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.
//
// Return a list of all possible strings we could create. You can return the output in any order.
//
//
//
// Example 1:
//
// Input: s = "a1b2"
// Output: ["a1b2","a1B2","A1b2","A1B2"]
// Example 2:
//
// Input: s = "3z4"
// Output: ["3z4","3Z4"]
// Example 3:
//
// Input: s = "12345"
// Output: ["12345"]
// Example 4:
//
// Input: s = "0"
// Output: ["0"]
//
//
// Constraints:
//
// s will be a string with length between 1 and 12.
// s will consist only of letters or digits.
//
// Runtime: 15 ms, faster than 15.98% of Java online submissions for Letter Case Permutation.
// Memory Usage: 52.7 MB, less than 5.57% of Java online submissions for Letter Case Permutation.
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        permutate(s, "", output);
        return output;
    }
    
    private char transform(char c) {
        int diff = c - 'a';
        if (diff >= 0 && diff < 26) {
            return (char) (diff + 'A');
        }
        diff = c - 'A';
        return (char) (diff + 'a');
    }
    private void permutate(String s, String tempString, List<String> output) {
        if (s.length() == tempString.length()) {
            output.add(tempString);
            return;
        }
        int index = tempString.length();
        char c = s.charAt(index);
        if (Character.isDigit(c)) permutate(s, tempString + c, output);
        else {
            permutate(s, tempString + c, output);
            permutate(s, tempString + transform(c), output);
        }
    }
}

// Runtime: 4 ms, faster than 58.04% of Java online submissions for Letter Case Permutation.
// Memory Usage: 52 MB, less than 8.56% of Java online submissions for Letter Case Permutation.
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        permutate(s, new StringBuilder(), output);
        return output;
    }
    
    private char transform(char c) {
        int diff = c - 'a';
        if (diff >= 0 && diff < 26) {
            return (char) (diff + 'A');
        }
        diff = c - 'A';
        return (char) (diff + 'a');
    }
    private void permutate(String s, StringBuilder tempString, List<String> output) {
        if (s.length() == tempString.length()) {
            output.add(tempString.toString());
            return;
        }
        int index = tempString.length();
        char c = s.charAt(index);
        if (Character.isDigit(c)) {
            tempString.append(c);
            permutate(s, tempString, output);
        }
        else {
            StringBuilder temp = new StringBuilder(tempString);
            tempString.append(c);
            permutate(s, tempString, output);
            temp.append(transform(c));
            permutate(s, temp, output);
        }
    }
}