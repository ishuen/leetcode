// 97. Interleaving String
// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//
// An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.
//
//
//
// Example 1:
//
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Example 2:
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
// Example 3:
//
// Input: s1 = "", s2 = "", s3 = ""
// Output: true
//
//
// Constraints:
//
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.
//
// Runtime: 866 ms, faster than 10.23% of Java online submissions for Interleaving String.
// Memory Usage: 38.7 MB, less than 14.73% of Java online submissions for Interleaving String.
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        if (c3.length != c1.length + c2.length) return false;
        return checkInterleave(0, 0, 0, c1, c2, c3);
    }
    
    private boolean checkInterleave(int pointer1, int pointer2, int index, char[] c1, char[] c2, char[] c3) {
        int len1 = c1.length;
        int len2 = c2.length;
        for (int i = index; i < c3.length; i++) {
            char cur = c3[i];
            if (pointer1 < len1 && pointer2 < len2 && cur == c1[pointer1] && cur == c2[pointer2]) {
                return checkInterleave(pointer1 + 1, pointer2, i + 1, c1, c2, c3) || checkInterleave(pointer1, pointer2 + 1, i + 1, c1, c2, c3);
            } else if (pointer1 < len1 && cur == c1[pointer1]) {
                pointer1++;
            } else if (pointer2 < len2 && cur == c2[pointer2]) {
                pointer2++;
            } else {
                return false;
            }
        }
        return true;
    }
}

// Runtime: 1 ms, faster than 84.83% of Java online submissions for Interleaving String.
// Memory Usage: 38.8 MB, less than 13.35% of Java online submissions for Interleaving String.
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        if (c3.length != len1 + len2) return false;
        return checkInterleave(0, 0, 0, c1, c2, c3, new boolean[len1 + 1][len2 + 1]);
    }
    
    private boolean checkInterleave(int pointer1, int pointer2, int index, char[] c1, char[] c2, char[] c3, boolean[][] invalid) {
        if (invalid[pointer1][pointer2] == true) return false;
        if(index == c3.length) return true;
        boolean isValid = (pointer1 < c1.length && c1[pointer1] == c3[index] && checkInterleave(pointer1 + 1, pointer2, index + 1, c1, c2, c3, invalid)) || pointer2 < c2.length && c2[pointer2] == c3[index] && checkInterleave(pointer1, pointer2 + 1, index + 1, c1, c2, c3, invalid);
        invalid[pointer1][pointer2] = !isValid;
        return isValid;
    }
}
