// 10. Regular Expression Matching
// Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
//
// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).
//
//
//
// Example 1:
//
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:
//
// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
// Example 3:
//
// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".
// Example 4:
//
// Input: s = "aab", p = "c*a*b"
// Output: true
// Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
// Example 5:
//
// Input: s = "mississippi", p = "mis*is*p*."
// Output: false
//
//
// Constraints:
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s contains only lowercase English letters.
// p contains only lowercase English letters, '.', and '*'.
// It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
//
// Runtime: 31 ms, faster than 30.84% of Java online submissions for Regular Expression Matching.
// Memory Usage: 37.7 MB, less than 92.19% of Java online submissions for Regular Expression Matching.
class Solution {
    public boolean isMatch(String s, String p) {
       return isMatch(0, 0, s, p);
    }
    
    private boolean isMatch(int sIndex, int pIndex, String s, String p) {
        if (sIndex >= s.length() && pIndex >= p.length()) return true;
        if (sIndex < s.length() && pIndex >= p.length()) return false;
        boolean isSame = sIndex < s.length() && pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            return isMatch(sIndex, pIndex + 2, s, p)
                || (isSame == true && isMatch(sIndex + 1, pIndex, s, p));
        }
        return isSame == true ? isMatch(sIndex + 1, pIndex + 1, s, p) : false; 
    }
}

// Runtime: 761 ms, faster than 5.04% of Java online submissions for Regular Expression Matching.
// Memory Usage: 259.6 MB, less than 5.28% of Java online submissions for Regular Expression Matching.
class Solution {
    public boolean isMatch(String s, String p) {
       return isMatch(0, 0, s, p, new HashMap<Integer[], Boolean>());
    }

    private boolean isMatch(int sIndex, int pIndex, String s, String p, Map<Integer[], Boolean> cache) {
        Integer[] key = new Integer[]{sIndex, pIndex};
        if (cache.containsKey(key)) return cache.get(key);
        if (sIndex >= s.length() && pIndex >= p.length()) return true;
        if (sIndex < s.length() && pIndex >= p.length()) return false;
        boolean isSame = sIndex < s.length() && pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            cache.put(key, isMatch(sIndex, pIndex + 2, s, p, cache)
                || (isSame == true && isMatch(sIndex + 1, pIndex, s, p, cache)));
            return cache.get(key);
        }
        cache.put(key, isSame == true ? isMatch(sIndex + 1, pIndex + 1, s, p, cache) : false); 
        return cache.get(key);
    }
}

// Runtime: 5 ms, faster than 50.10% of Java online submissions for Regular Expression Matching.
// Memory Usage: 39.1 MB, less than 50.38% of Java online submissions for Regular Expression Matching.
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] matrix = new boolean[sLen + 1][pLen + 1];
        matrix[0][0] = true;
        for (int j = 2; j < pLen + 1; j += 2) {
            if (p.charAt(j - 1) == '*' && matrix[0][j - 2]) { // empty string pattern
                matrix[0][j] = true;
            }
        }
        // min edit distance
       for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if (curS == curP || curP == '.') {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if(curP == '*') {
                    char preCurP = p.charAt(j - 2);
                    if (preCurP != '.' && preCurP != curS) {
                        matrix[i][j] = matrix[i][j - 2];
                    } else {
                        matrix[i][j] = (matrix[i][j - 2] || matrix[i - 1][j - 2] || matrix[i - 1][j]); // * = 0 occurance, * = 1, * > 1
                    }
                }
            }
        }
        return matrix[sLen][pLen];
    }
    
}