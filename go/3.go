// 3. Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

// Runtime 3 ms Beats 76.50%
// Memory 5.10 MB Beats 48.57%
func lengthOfLongestSubstring(s string) int {
    if len(s) == 0 {
        return 0
    }
    characters := make(map[byte]bool, len(s))
    left, right := 0, 0
    max := 1
    for ; right < len(s); right++ {
        if characters[s[right]] == true {
            for ; s[left] != s[right]; {
                characters[s[left]] = false
                left++
            }
            left++
        } else {
            characters[s[right]] = true
            length := right - left + 1
            if length > max {
                max = length
            }
        }
    }
    return max
}


// Runtime 2 ms Beats 81.77%
// Memory 5.84 MB Beats 21.82%
func lengthOfLongestSubstring(s string) int {
    if len(s) == 0 {
        return 0
    }
    characters := make(map[byte]int, len(s))
    left, right := 0, 0
    max := 1
    for ; right < len(s); right++ {
        if characters[s[right]] > left {
            left = characters[s[right]]
            characters[s[right]] = right + 1
        } else {
            characters[s[right]] = right + 1
            length := right - left + 1
            if length > max {
                max = length
            }
        }
    }
    return max
}