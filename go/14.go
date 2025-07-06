// 14. Longest Common Prefix

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters if it is non-empty.

// Runtime 0 ms Beats 100.00%
// Memory 4.36 MB Beats 31.75%
func longestCommonPrefix(strs []string) string {
    if len(strs) == 1 {
        return strs[0]
    }
    prefix := ""
    for index, char := range strs[0] {
        for i := 1; i < len(strs); i++ {
            if index >= len(strs[i]) || strs[i][index] != byte(char) {
                return prefix
            }
        }
        prefix = prefix + string(char)
    }
    return prefix
}