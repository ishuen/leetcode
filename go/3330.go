// 3330. Find the Original Typed String I
//
// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
//
// Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
//
// You are given a string word, which represents the final output displayed on Alice's screen.
//
// Return the total number of possible original strings that Alice might have intended to type.
//
//
//
// Example 1:
//
// Input: word = "abbcccc"
//
// Output: 5
//
// Explanation:
//
// The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
//
// Example 2:
//
// Input: word = "abcd"
//
// Output: 1
//
// Explanation:
//
// The only possible string is "abcd".
//
// Example 3:
//
// Input: word = "aaaa"
//
// Output: 4
//
//
//
// Constraints:
//
// 1 <= word.length <= 100
// word consists only of lowercase English letters.
//
// Runtime 0 ms Beats 100.00%
// Memory 4.02 MB Beats 19.05%
func possibleStringCount(word string) int {
    count := 1
    charCount := 0
    var lastChar byte
    for i := range len(word) {
        if word[i] == lastChar {
            charCount++
        } else {
            count += charCount
            lastChar = word[i]
            charCount = 0
        }
    }
    if (charCount > 0) {
        count += charCount
    }
    return count
}