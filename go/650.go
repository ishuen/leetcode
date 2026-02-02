// 650. 2 Keys Keyboard

// There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

// Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
// Paste: You can paste the characters which are copied last time.
// Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

// Example 1:

// Input: n = 3
// Output: 3
// Explanation: Initially, we have one character 'A'.
// In step 1, we use Copy All operation.
// In step 2, we use Paste operation to get 'AA'.
// In step 3, we use Paste operation to get 'AAA'.
// Example 2:

// Input: n = 1
// Output: 0
 

// Constraints:

// 1 <= n <= 1000

// Runtime 5 ms Beats 44.83%
// Memory 4.34 MB Beats 48.28%
func minSteps(n int) int {
    mapping := make([]int, n + 1)
    for i := 2; i <= n; i++ {
        mapping[i] = i
        for j := i / 2; j > 1; j-- {
            if i % j == 0 {
                mapping[i] = min(mapping[i], i / j + mapping[j])
                break
            }
        }
    }
    return mapping[n]
}

// Runtime 0 ms Beats 100.00%
// Memory 3.88 MB Beats 82.76%
func minSteps(n int) int {
    if n == 1 {
        return 0
    }
    base := 2
    step := 0
    for base * base <= n {
        for n % base == 0 {
            step = step + base
            n = n / base
        }
        base++
    }
    if n > 1 {
        step = step + n
    }
    return step
}