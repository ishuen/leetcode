// 2785. Sort Vowels in a String
//
// Given a 0-indexed string s, permute s to get a new string t such that:
//
// All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
// The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
// Return the resulting string.
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
//
//
//
// Example 1:
//
// Input: s = "lEetcOde"
// Output: "lEOtcede"
// Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
// Example 2:
//
// Input: s = "lYmpH"
// Output: "lYmpH"
// Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists only of letters of the English alphabet in uppercase and lowercase.
//
// Runtime 16ms Beats 91.65%of users with Java
// Memory 44.67MB Beats 80.46%of users with Java
class Solution {
    private char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    public String sortVowels(String s) {
        int[] occurrences = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int index = getIndex(s.charAt(i));
            if (index != -1) {
                occurrences[index]++;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int cur = 0;
        for (int i = 0; i < sb.length(); i++) {
            while(cur < occurrences.length && occurrences[cur] == 0) {
                cur++;
            }
            int index = getIndex(s.charAt(i));
            if (index != -1) {
                sb.setCharAt(i, vowels[cur]);
                occurrences[cur]--;
            }
        }
        return sb.toString();
    }

    private int getIndex(char c) {
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return i;
            }
        }
        return -1;
    }
}


// Runtime 9ms Beats 95.48%of users with Java
// Memory 44.66MB Beats 80.46%of users with Java
class Solution {
    private char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    private int[] vowelMap = new int[80];
    public String sortVowels(String s) {
        int[] occurrences = new int[11];
        for (int i = 0; i < vowels.length; i++) {
            vowelMap[vowels[i] - 'A'] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            occurrences[vowelMap[s.charAt(i) - 'A']]++;
        }
        StringBuilder sb = new StringBuilder(s);
        int cur = 1;
        int index = 0;
        while (cur < occurrences.length) {
            if (occurrences[cur] == 0) {
                cur++;
                continue;
            }
            while (vowelMap[sb.charAt(index) - 'A'] == 0) {
                index++;
            }
            sb.setCharAt(index, vowels[cur - 1]);
            occurrences[cur]--;
            index++;
        }
        return sb.toString();
    }
}