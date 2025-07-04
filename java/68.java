// 68. Text Justification
// Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
// For the last line of text, it should be left justified and no extra space is inserted between words.
//
// Note:
//
// A word is defined as a character sequence consisting of non-space characters only.
// Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
// The input array words contains at least one word.
//
//
// Example 1:
//
// Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
// Output:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Example 2:
//
// Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
// Output:
// [
//   "What   must   be",
//   "acknowledgment  ",
//   "shall be        "
// ]
// Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
// Note that the second line is also left-justified becase it contains only one word.
// Example 3:
//
// Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
// Output:
// [
//   "Science  is  what we",
//   "understand      well",
//   "enough to explain to",
//   "a  computer.  Art is",
//   "everything  else  we",
//   "do                  "
// ]
//
//
// Constraints:
//
// 1 <= words.length <= 300
// 1 <= words[i].length <= 20
// words[i] consists of only English letters and symbols.
// 1 <= maxWidth <= 100
// words[i].length <= maxWidth
//
// Runtime: 1 ms, faster than 54.75% of Java online submissions for Text Justification.
// Memory Usage: 37.3 MB, less than 80.73% of Java online submissions for Text Justification.
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            if (sb.length() == 0) {
                sb.append(word);
            } else {
                if (maxWidth - sb.length() >= word.length() + 1) {
                    sb.append(" " + word);
                } else {
                    ans.add(insertSpaces(sb, maxWidth));
                    sb = new StringBuilder();
                    sb.append(word);
                }
            }
        }
        if (sb.length() > 0) {
            int num = maxWidth - sb.length();
             for (int i = 0; i < num; i++) {
                sb.append(" ");
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    
    private String insertSpaces(StringBuilder sb, int maxWidth) {
        int num = maxWidth - sb.length();
        int count = 0;
        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) != ' ') index++;
            else break;
        }
        if (index == sb.length()) {
            for (int i = 0; i < num; i++) {
                sb.append(" ");
            }
        } else {
            while(count < num) {
                if (sb.charAt(index) == ' ') {
                    sb.insert(index, ' ');
                    count++;
                    index++;
                    while(sb.charAt(index) == ' ' && index < sb.length()) index++;
                } else index++;
                if (index > sb.length() - 1) index = 0;
            }
        }
        
        return sb.toString();
    }
}

// if at the beginning - add word
// else spaces > 1 + word.length => add
//      else go back and expand the spaces
// if EOL add spaces