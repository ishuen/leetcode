// 242. Valid Anagram

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false

 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
 

// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

// Runtime 0 ms Beats 100.00%
// Memory 4.67 MB Beats 99.29%
func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    var arr [26]int
    for _, char := range s {
        arr[char - rune('a')]++
    }
    for _, char := range t {
        if arr[char - rune('a')] > 0 {
            arr[char - rune('a')]--
        } else {
            return false
        }
    }
    return true
}