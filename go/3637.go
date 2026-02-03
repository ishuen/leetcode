// 3637. Trionic Array I

// You are given an integer array nums of length n.

// An array is trionic if there exist indices 0 < p < q < n − 1 such that:

// nums[0...p] is strictly increasing,
// nums[p...q] is strictly decreasing,
// nums[q...n − 1] is strictly increasing.
// Return true if nums is trionic, otherwise return false.

 

// Example 1:

// Input: nums = [1,3,5,4,2,6]

// Output: true

// Explanation:

// Pick p = 2, q = 4:

// nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
// nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
// nums[4...5] = [2, 6] is strictly increasing (2 < 6).
// Example 2:

// Input: nums = [2,1,3]

// Output: false

// Explanation:

// There is no way to pick p and q to form the required three segments.

 

// Constraints:

// 3 <= n <= 100
// -1000 <= nums[i] <= 1000

// Runtime 0 ms Beats 100.00%
// Memory 4.60 MB Beats 30.00%
func isTrionic(nums []int) bool {
    length := len(nums)
    if length < 4 {
        return false
    }
    if nums[0] >= nums[1] || nums[length - 1] <= nums[length - 2] {
        return false
    }
    p := 1
    for ; p < length - 2; p++ {
        if nums[p] >= nums[p + 1] {
            break;
        }
    }
    q := length - 2
    for ; q > 1; q-- {
        if nums[q] <= nums[q - 1] {
            break
        }
    }
    if p >= q {
        return false
    }
    for i := p; i < q; i++ {
        if nums[i] <= nums[i + 1] {
            return false
        }
    }
    return true
}


// Runtime 0 ms Beats 100.00%
// Memory 4.67 MB Beats 30.00%
func isTrionic(nums []int) bool {
    first := false
    second := false
    third := false
    i := 0
    for ; i < len(nums) - 1; i++ {
        if nums[i] < nums[i + 1] {
            first = true
        } else {
            break
        }
    }
    for ; i < len(nums) - 1; i++ {
        if nums[i] > nums[i + 1] {
            second = true
        } else {
            break
        }
    }
    for ; i < len(nums) - 1; i++ {
        if nums[i] < nums[i + 1] {
            third = true
        } else {
            return false
        }
    }
    if first == second && second == third && third == true && i == len(nums) - 1 {
        return true
    }
    return false
}