// 97. Interleaving String

// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

// An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.

 

// Example 1:


// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Explanation: One way to obtain s3 is:
// Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
// Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
// Since s3 can be obtained by interleaving s1 and s2, we return true.
// Example 2:

// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
// Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
// Example 3:

// Input: s1 = "", s2 = "", s3 = ""
// Output: true
 

// Constraints:

// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.
 

// Follow up: Could you solve it using only O(s2.length) additional memory space?

// Runtime 2 ms Beats 54.17%
// Memory 4.25 MB Beats 48.75%
func isInterleave(s1 string, s2 string, s3 string) bool {
    if len(s3) != len(s1) + len(s2) {
        return false
    } 
    mappings := make([][]bool, len(s1) + 1)
    for i := 0; i < len(mappings); i++ {
        mappings[i] = make([]bool, len(s2) + 1)
    }
    mappings[0][0] = true
    for i := 1; i <= len(s1); i++ {
        mappings[i][0] = mappings[i - 1][0] && s3[i - 1] == s1[i - 1]
    }
    for i := 1; i <= len(s2); i++ {
        mappings[0][i] = mappings[0][i - 1] && s3[i - 1] == s2[i - 1]
    }
    for i := 1; i <= len(s1); i++ {
        for j := 1; j <= len(s2); j++ {
            mappings[i][j] = (mappings[i - 1][j] && s3[i + j - 1] == s1[i - 1]) || (mappings[i][j - 1] && s3[i + j - 1] == s2[j - 1])
        }
    }
    return mappings[len(s1)][len(s2)]
}


// Runtime 2 ms Beats 54.17%
// Memory 3.90 MB Beats 97.08%
func isInterleave(s1 string, s2 string, s3 string) bool {
    if len(s3) != len(s1) + len(s2) {
        return false
    } 
    mappings := make([]bool, len(s2) + 1)
    mappings[0] = true
    for i := 1; i <= len(s2); i++ {
        mappings[i] = mappings[i - 1] && s3[i - 1] == s2[i - 1]
    }
    for i := 1; i <= len(s1); i++ {
        mappings[0] = mappings[0] && s3[i - 1] == s1[i - 1]
        for j := 1; j <= len(s2); j++ {
            mappings[j] = (mappings[j] && s3[i + j - 1] == s1[i - 1]) || (mappings[j - 1] && s3[i + j - 1] == s2[j - 1])
        }
    }
    return mappings[len(s2)]
}
