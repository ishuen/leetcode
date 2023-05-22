// 434. Number of Segments in a String
// Given a string s, return the number of segments in the string.
//
// A segment is defined to be a contiguous sequence of non-space characters.
//
//
//
// Example 1:
//
// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// Example 2:
//
// Input: s = "Hello"
// Output: 1
//
//
// Constraints:
//
// 0 <= s.length <= 300
// s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
// The only space character in s is ' '.
//
// Runtime 0 ms Beats 100%
// Memory 40.4 MB Beats 70.52%
class Solution {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] arr = s.split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == "") count++;
        }
        return arr.length - count;
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.3 MB Beats 70.52%
class Solution {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        int count = 0;
        int index = 0;
        boolean hasW = false;
        while (index < s.length()) {
           if (s.charAt(index) == ' ' && hasW == true) {
               count++;
               index++;
               while (index < s.length() && s.charAt(index) == ' ') {
                   index++;
               }
               hasW = false;
           } else {
               if (s.charAt(index) != ' ') hasW = true;
               index++;
           }
        }
        if (hasW == true) count++;
        return count;
    }
}