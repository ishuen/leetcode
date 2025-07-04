// 524. Longest Word in Dictionary through Deleting
// Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
//
//
//
// Example 1:
//
// Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
// Output: "apple"
// Example 2:
//
// Input: s = "abpcplea", dictionary = ["a","b","c"]
// Output: "a"
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s and dictionary[i] consist of lowercase English letters.
//
// Runtime: 26 ms, faster than 30.72% of Java online submissions for Longest Word in Dictionary through Deleting.
// Memory Usage: 40 MB, less than 52.05% of Java online submissions for Longest Word in Dictionary through Deleting.
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (String word: dictionary) {
            int sIndex = 0;
            int dIndex = 0;
            while (dIndex < word.length() && sIndex < s.length()) {
                if (s.charAt(sIndex) == word.charAt(dIndex)) {
                    dIndex++;
                }
                sIndex++;
            }
            if (dIndex == word.length()) return word;
        }
        return "";
    }
    
}
// check dictionary content is faster than composing different string and match