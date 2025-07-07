// 28. Find the Index of the First Occurrence in a String

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

// Constraints:

// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.

// Runtime 0 ms Beats 100.00%
// Memory 3.99 MB Beats 49.47%
func strStr(haystack string, needle string) int {
    if len(haystack) < len(needle) {
        return -1
    }
    needleIndex := 0
    init := 0
    for i := 0; i < len(haystack); i++ {
        if haystack[i] != needle[needleIndex] {
            if needleIndex != 0 {
                i = init
            }
            needleIndex = 0
        } else {
            if needleIndex == 0 {
                init = i
            }
            needleIndex++
            if needleIndex == len(needle) {
                return init
            } 
        }
    }
    return -1
}


// Runtime 0 ms Beats 100.00%
// Memory 3.95 MB Beats 49.47%
func strStr(haystack string, needle string) int {
    if len(haystack) < len(needle) {
        return -1
    }
    for i := 0; i < len(haystack); i++ {
        if haystack[i] == needle[0] && i + len(needle) <= len(haystack) {
            if haystack[i: (i + len(needle))] == needle {
                return i
            }
        }
    }
    return -1
}