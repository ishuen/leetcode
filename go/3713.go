// 3713. Longest Balanced Substring I

// You are given a string s consisting of lowercase English letters.

// A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

// Return the length of the longest balanced substring of s.

 

// Example 1:

// Input: s = "abbac"

// Output: 4

// Explanation:

// The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

// Example 2:

// Input: s = "zzabccy"

// Output: 4

// Explanation:

// The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.

// Example 3:

// Input: s = "aba"

// Output: 2

// Explanation:

// One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

 

// Constraints:

// 1 <= s.length <= 1000
// s consists of lowercase English letters.



// Runtime 870 ms Beats 10.38%
// Memory 4.71 MB Beats 40.62%
func longestBalanced(s string) int {
    maxLen := 0
    for last := len(s); last > 0; last-- {
        for i := 0; i < last; i++ {
            if last - i <= maxLen {
                break
            }
            if isBalanced(s[i:last]) {
                maxLen = max(maxLen, last - i)
            }
        }
    }
    return maxLen
}

func isBalanced(s string) bool {
    var counts [26]int
    for i := 0; i < len(s); i++ {
        counts[s[i] - 'a']++
    }
    base := 0
    for i := 0; i < 26; i++ {
        if counts[i] != 0 {
            if base == 0 {
                base = counts[i]
            } else {
                if counts[i] != base {
                    return false
                }
            }
        }
    }
    return true
}