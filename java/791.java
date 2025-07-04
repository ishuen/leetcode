// 791. Custom Sort String
// order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
//
// order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
//
// Return any permutation of str (as a string) that satisfies this property.
//
// Example:
// Input:
// order = "cba"
// str = "abcd"
// Output: "cbad"
// Explanation:
// "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
// Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
//
//
// Note:
//
// order has length at most 26, and no character is repeated in order.
// str has length at most 200.
// order and str consist of lowercase letters only.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
// Memory Usage: 37.5 MB, less than 45.63% of Java online submissions for Custom Sort String.
class Solution {
    public String customSortString(String order, String str) {
        int[] occurrance = new int[26];
        for (char c : str.toCharArray()) {
            occurrance[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c: order.toCharArray()) {
            if (occurrance[c - 'a'] > 0) {
                for (int i = 0; i < occurrance[c - 'a']; i++) {
                    sb.append(c);
                }
                occurrance[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (occurrance[i] > 0) {
                for (int j = 0; j < occurrance[i]; j++) {
                    sb.append((char)('a' + i));
                }
                occurrance[i] = 0;
            }
        }
        return sb.toString();
    }
}