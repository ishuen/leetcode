// 820. Short Encoding of Words
// A valid encoding of an array of words is any reference string s and array of indices indices such that:
//
// words.length == indices.length
// The reference string s ends with the '#' character.
// For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
// Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
//
//
//
// Example 1:
//
// Input: words = ["time", "me", "bell"]
// Output: 10
// Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
// words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
// words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
// words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
// Example 2:
//
// Input: words = ["t"]
// Output: 2
// Explanation: A valid encoding would be s = "t#" and indices = [0].
//
//
// Constraints:
//
// 1 <= words.length <= 2000
// 1 <= words[i].length <= 7
// words[i] consists of only lowercase letters.
//
// Runtime 18 ms Beats 67.33%
// Memory 42.7 MB Beats 84%
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word: words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int count = 0;
        for (String word: set) {
            count = count + word.length() + 1;
        }
        return count;
    }
}

// Runtime 21 ms Beats 50.67%
// Memory 42.8 MB Beats 80%
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Set<String> wordSet = new HashSet<>(set);
        int count = 0;
        for (String word: wordSet) {
            count = count + word.length() + 1;
            for (int i = 1; i < word.length(); i++) {
                String sub = word.substring(i);
                if (set.remove(sub)) {
                    count = count - sub.length() - 1;
                }
            }
        }
        return count;
    }
}