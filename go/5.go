// 5. Longest Palindromic Substring

// Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters.


// Runtime 43 ms Beats 30.94%
// Memory 4.57 MB Beats 39.29%
func check(start, end int, s string) bool {
    half := (end - start) / 2
    for i := 0; i <= half; i++ {
        if s[start + i] != s[end - i] {
            return false
        }
    }
    return true
}
func longestPalindrome(s string) string {
    longest := string(s[0])
    for i := 0; i < len(s); i++ {
        for j := len(s) - 1; j > i; j-- {
            if j - i < len(longest) {
                break
            }
            if check(i, j, s) {
                str := s[i : j + 1]
                if len(str) > len(longest) {
                    longest = str
                }
                break
            }
        } 
    }
    return longest
}

// Runtime 1 ms Beats 84.63%
// Memory 4.44 MB Beats 61.20%
func longestPalindrome(s string) string {
    var expand func(left, right int) string
    expand = func(left, right int) string {
        for ; left >= 0 && right < len(s) && s[left] == s[right]; {
            left--;
            right++
        }
        return s[left + 1: right]
    }
    longest := string(s[0])
    for i := 0; i < len(s) - 1; i++ {
        odd := expand(i, i)
        even := expand(i, i + 1)
        if len(odd) > len(longest) {
            longest = odd
        }
        if len(even) > len(longest) {
            longest = even
        }
    }
    return longest
}