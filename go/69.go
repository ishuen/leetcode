// 69. Sqrt(x)

// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

// Constraints:

// 0 <= x <= 231 - 1

// Runtime 14 ms Beats 14.22%
// Memory 4.00 MB Beats 78.26%
func mySqrt(x int) int {
    last := 0
    for i := 1; i <= x; i++ {
        product := i * i
        if product == x {
            return i
        }
        if product > x {
            return last
        }
        last = i
    }
    return last
}


// Runtime 0 ms Beats 100.00%
// Memory 4.12 MB Beats 28.35%
func mySqrt(x int) int {
    if x <= 1 {
        return x
    }
    left := 2
    right := x
    for ; left <= right; {
        mid := (left + right) / 2
        product := mid * mid
        if product == x {
            return mid
        }
        if product > x {
            right = mid - 1
        } else if product < x {
            left = mid + 1
        }
    }
    return right
}