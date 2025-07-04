// 1790. Check if One String Swap Can Make Strings Equal

// You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

// Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 

// Example 1:

// Input: s1 = "bank", s2 = "kanb"
// Output: true
// Explanation: For example, swap the first character with the last character of s2 to make "bank".
// Example 2:

// Input: s1 = "attack", s2 = "defend"
// Output: false
// Explanation: It is impossible to make them equal with one string swap.
// Example 3:

// Input: s1 = "kelb", s2 = "kelb"
// Output: true
// Explanation: The two strings are already equal, so no string swap operation is required.
 

// Constraints:

// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 and s2 consist of only lowercase English letters.

// Runtime 0 ms Beats 100.00%
// Memory 3.96 MB Beats 69.12%
func areAlmostEqual(s1 string, s2 string) bool {
    diffIndex1 := -1
    diffIndex2 := -1
    for i := 0; i < len(s1); i++ {
        if s1[i] != s2[i] {
            if diffIndex1 == -1 {
                diffIndex1 = i
            } else if diffIndex2 == -1 {
                diffIndex2 = i
            } else {
                return false
            }
        }
    }
    if diffIndex1 == -1 && diffIndex2 == -1 {
        return true
    } else if diffIndex1 == -1 || diffIndex2 == -1 {
        return false
    }
    if s1[diffIndex1] != s2[diffIndex2] || s1[diffIndex2] != s2[diffIndex1] {
        return false
    }
    return true
}