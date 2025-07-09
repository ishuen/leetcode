// 49. Group Anagrams

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]

// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Explanation:

// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
// Example 2:

// Input: strs = [""]

// Output: [[""]]

// Example 3:

// Input: strs = ["a"]

// Output: [["a"]]

 

// Constraints:

// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.

// Runtime 18 ms Beats 20.91%
// Memory 9.40 MB Beats 78.64%
func groupAnagrams(strs []string) [][]string {
    mappings := make(map[string][]string)
    for _, str := range strs {
        var arr [26]int
        for _, char := range str {
            arr[char - rune('a')]++
        }
        var key strings.Builder
        key.WriteByte(byte(arr[0]))
        for i := 1; i < 26; i++ {
            key.WriteString(":" + string(arr[i]))
        }
        mappings[key.String()] = append(mappings[key.String()], str)
    }
    numKeys := len(mappings)
    output := make([][]string, numKeys)
    i := 0
    for _, value := range mappings {
        output[i] = value
        i++
    }
    return output
}

// Runtime 11 ms Beats 54.93%
// Memory 10.79 MB Beats 21.75%
func groupAnagrams(strs []string) [][]string {
    mappings := make(map[[26]int][]string)
    for _, str := range strs {
        var arr [26]int
        for _, char := range str {
            arr[char - rune('a')]++
        }
        mappings[arr] = append(mappings[arr], str)
    }
    numKeys := len(mappings)
    output := make([][]string, numKeys)
    i := 0
    for _, value := range mappings {
        output[i] = value
        i++
    }
    return output
}

// Runtime 13 ms Beats 39.69%
// Memory 11.32 MB Beats 13.01%
func groupAnagrams(strs []string) [][]string {
    mappings := make(map[[26]int][]string)
    for _, str := range strs {
        var arr [26]int
        for _, char := range str {
            arr[char - rune('a')]++
        }
        mappings[arr] = append(mappings[arr], str)
    }
    var output [][]string
    for _, value := range mappings {
        output = append(output, value)
    }
    return output
}