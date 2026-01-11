// 345. Reverse Vowels of a String

// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "IceCreAm"

// Output: "AceCreIm"

// Explanation:

// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:

// Input: s = "leetcode"

// Output: "leotcede"

 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.



// Runtime 2 ms Beats 57.80%
// Memory 6.40 MB Beats 41.88%
func reverseVowels(s string) string {
    arr := []rune(s)
    start := 0
    end := len(s) - 1
    list := []rune("aeiouAEIOU")
    isVowel := func(char rune) bool {
        return slices.Contains(list, char)        
    }
    for ; start < end; {
        if isVowel(arr[start]) && isVowel(arr[end]) {
            arr[start], arr[end] = arr[end], arr[start]
            start++
            end--
            continue
        }
        if !isVowel(arr[start]) {
            start++
            continue
        }
        if !isVowel(arr[end]) {
            end--
            continue
        }
    }
    return string(arr)
}


// Runtime 0 ms Beats 100.00%
// Memory 6.45 MB Beats 41.88%
func reverseVowels(s string) string {
    arr := []rune(s)
    start := 0
    end := len(s) - 1
    list := []rune("aeiouAEIOU")
    isVowel := func(char rune) bool {
        return slices.Contains(list, char)        
    }
    for ; start < end; {
        if !isVowel(arr[start]) {
            start++
            continue
        }
        if !isVowel(arr[end]) {
            end--
            continue
        }
        arr[start], arr[end] = arr[end], arr[start]
        start++
        end--
    }
    return string(arr)
}
