// 201. Bitwise AND of Numbers Range

// Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

// Example 1:

// Input: left = 5, right = 7
// Output: 4
// Example 2:

// Input: left = 0, right = 0
// Output: 0
// Example 3:

// Input: left = 1, right = 2147483647
// Output: 0
 

// Constraints:

// 0 <= left <= right <= 231 - 1

// Runtime 0 ms Beats 100.00%
// Memory 6.66 MB Beats 89.23%
func rangeBitwiseAnd(left int, right int) int {
    diff := right - left
    num := left & right
    cur := diff
    count := 0
    for ; cur > 0; {
        cur = cur >> 1
        count++
    }
    num = num >> count
    num = num << count   
    return num
}