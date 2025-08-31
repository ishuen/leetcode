// 9. Palindrome Number

// Given an integer x, return true if x is a palindrome, and false otherwise.

 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

// Constraints:

// -231 <= x <= 231 - 1

// Runtime 8 ms Beats 18.57%
// Memory 6.26 MB Beats 36.23%
func isPalindrome(x int) bool {
    str := strconv.Itoa(x)
    half := len(str) / 2
    for i := 0; i < half; i++ {
        if str[i] != str[len(str) - 1 - i] {
            return false
        }
    }
    return true
}