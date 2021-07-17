// 953. Verifying an Alien Dictionary
// In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
//
//
//
// Example 1:
//
// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
// Example 2:
//
// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
// Example 3:
//
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
//
//
// Constraints:
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// All characters in words[i] and order are English lowercase letters.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Verifying an Alien Dictionary.
// Memory Usage: 38.6 MB, less than 79.49% of Java online submissions for Verifying an Alien Dictionary.
class Solution {
    char[] dicOrder;
    public boolean isAlienSorted(String[] words, String order) {
        dicOrder = order.toCharArray();
        for (int i = 0; i < words.length - 1; i++) {
            if (!isAsec(words[i], words[i + 1])) return false;
        }
        return true;
    }
    
    private boolean isAsec(String word1, String word2) {
        int maxIndex = Math.min(word1.length(), word2.length()) - 1;
        int index = 0;
        while (index <= maxIndex) {
            int index1 = findIndex(word1.charAt(index));
            int index2 = findIndex(word2.charAt(index));
            if (index1 < index2) return true;
            else if (index1 > index2) return false;
            index++;
        }
        return word1.length() <= word2.length();
    }
    
    private int findIndex(char c) {
        for (int i = 0; i < dicOrder.length; i++) {
            if (dicOrder[i] == c) return i;
        }
        return -1;
    }
}

