// 383. Ransom Note

// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

 

// Example 1:

// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:

// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:

// Input: ransomNote = "aa", magazine = "aab"
// Output: true
 

// Constraints:

// 1 <= ransomNote.length, magazine.length <= 105
// ransomNote and magazine consist of lowercase English letters.

// Runtime 10 ms Beats 45.17%
// Memory 5.85 MB Beats 51.50%
func canConstruct(ransomNote string, magazine string) bool {
    counts := make(map[rune]int)
    for _, char := range magazine {
        counts[char]++
    }
    for _, char := range ransomNote {
        if counts[char] > 0 {
            counts[char]--
        } else {
            return false
        }
    }
    return true
}


// Runtime 0 ms Beats 100.00%
// Memory 5.69 MB Beats 99.42%
func canConstruct(ransomNote string, magazine string) bool {
    var counts [26]int
    for _, char := range magazine {
        counts[char - rune('a')]++
    }
    for _, char := range ransomNote {
        if counts[char - rune('a')] > 0 {
            counts[char - rune('a')]--
        } else {
            return false
        }
    }
    return true
}