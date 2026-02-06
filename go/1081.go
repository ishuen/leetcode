// 1081. Smallest Subsequence of Distinct Characters

// Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of lowercase English letters.
 

// Runtime 0 ms Beats 100.00%
// Memory 3.90 MB Beats 100.00%
func smallestSubsequence(s string) string {
    lastOccur := make([]int, 26)
    seen := make([]int, 26)
    stack := []byte{}
    for i := range s {
        lastOccur[s[i] - 'a'] = i
    }
    for i := range s {
        charIndex := s[i] - 'a'
        if seen[charIndex] > 0 {
            continue
        }
        seen[charIndex]++
        for len(stack) > 0 && stack[len(stack) - 1] - 'a' > s[i] - 'a' && lastOccur[stack[len(stack) - 1] - 'a'] > i {
            out := stack[len(stack) - 1]
            stack = stack[0:len(stack) - 1]
            seen[out - 'a']--
        }
        stack = append(stack, s[i])
    }
    return string(stack)
}