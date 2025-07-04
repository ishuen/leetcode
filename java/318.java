// 318. Maximum Product of Word Lengths
// Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
//
//
// Example 1:
//
// Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
// Output: 16
// Explanation: The two words can be "abcw", "xtfn".
// Example 2:
//
// Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
// Output: 4
// Explanation: The two words can be "ab", "cd".
// Example 3:
//
// Input: words = ["a","aa","aaa","aaaa"]
// Output: 0
// Explanation: No such pair of words.
//
// Constraints:
//
// 2 <= words.length <= 1000
// 1 <= words[i].length <= 1000
// words[i] consists only of lowercase English letters.
//
// Runtime: 24 ms, faster than 44.66% of Java online submissions for Maximum Product of Word Lengths.
// Memory Usage: 39 MB, less than 72.89% of Java online submissions for Maximum Product of Word Lengths.
class Solution {
    public int maxProduct(String[] words) {
        boolean[][] chars = new boolean[words.length][26];
        for (int j = 0; j < words.length; j++) {
            for (int i = 0; i < words[j].length(); i++) {
                chars[j][words[j].charAt(i) - 'a'] = true;
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean hasSame = false;
                for (int k = 0; k < 26; k++) {
                    if (chars[i][k] == true && chars[j][k] == true) {
                        hasSame = true;
                        break;
                    }
                }
                if (hasSame == false) {
                    int product = words[i].length() * words[j].length();
                    if (product > max) max = product;
                }
            }
        }
        return max;
    }
}

// [a..z]