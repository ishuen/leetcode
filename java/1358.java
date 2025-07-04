// 1358. Number of Substrings Containing All Three Characters
//
// Given a string s consisting only of characters a, b and c.
//
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.
//
//
//
// Example 1:
//
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
// Example 2:
//
// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
// Example 3:
//
// Input: s = "abc"
// Output: 1
//
//
// Constraints:
//
// 3 <= s.length <= 5 x 10^4
// s only consists of a, b or c characters.
//
// Runtime 14 ms Beats 48.13%
// Memory 44.86 MB Beats 37.47%
class Solution {
    public int numberOfSubstrings(String s) {
        int[] record = new int[3];
        int l = 0;
        int count = 0;
        int len = s.length();
        for (int r = 0; r < len; r++) {
            char c = s.charAt(r);
            record[c - 'a']++;
            if (checkCount(record)) {
                count = count + len - r;
                char left = s.charAt(l);
                record[left - 'a']--;
                record[c - 'a']--;
                r--;
                l++;
            }
        }
        return count;
    }
    private boolean checkCount(int[] record) {
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 0) return false;
        }
        return true;
    }
}

// Runtime 6 ms Beats 99.62%
// Memory 44.82 MB Beats 37.47%
class Solution {
    public int numberOfSubstrings(String s) {
        int[] record = new int[3];
        Arrays.fill(record, -1);
        int count = 0;
        int len = s.length();
        for (int r = 0; r < len; r++) {
            char c = s.charAt(r);
            record[c - 'a'] = r;
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                minIndex = Math.min(record[i], minIndex);
            }
            count = count + minIndex + 1;
        }
        return count;
    }
}