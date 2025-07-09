// 202. Happy Number

// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

 

// Example 1:

// Input: n = 19
// Output: true
// Explanation:
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// Example 2:

// Input: n = 2
// Output: false
 

// Constraints:

// 1 <= n <= 231 - 1

// Runtime 0 ms Beats 100.00%
// Memory 3.96 MB Beats 87.41%
func isHappy(n int) bool {
    if n == 1 {
        return true
    }
    records := make(map[int]bool)
    sum := 0
    for ; sum != 1; {
        sum = 0
        for ; n > 0; {
            digit := n % 10
            sum += digit * digit
            n = n / 10
        }
        if records[sum] == true {
            break
        }
        records[sum] = true
        n = sum
    }
    return sum == 1
}