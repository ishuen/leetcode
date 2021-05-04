// 58. Length of Last Word
// Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
//
// A word is a maximal substring consisting of non-space characters only.
//
//
// Example 1:
//
// Input: s = "Hello World"
// Output: 5
// Example 2:
//
// Input: s = " "
// Output: 0
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
//
// Runtime: 1 ms, faster than 51.99% of Java online submissions for Length of Last Word.
// Memory Usage: 37.3 MB, less than 48.30% of Java online submissions for Length of Last Word.
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length > 0 ? words[words.length - 1].length() : 0;
    }
}


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
// Memory Usage: 37.4 MB, less than 48.30% of Java online submissions for Length of Last Word.
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}