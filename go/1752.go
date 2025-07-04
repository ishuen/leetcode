// 1752. Check if Array Is Sorted and Rotated

// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

// There may be duplicates in the original array.

// Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
// Example 2:

// Input: nums = [2,1,3,4]
// Output: false
// Explanation: There is no sorted array once rotated that can make nums.
// Example 3:

// Input: nums = [1,2,3]
// Output: true
// Explanation: [1,2,3] is the original sorted array.
// You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.


// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

// Runtime 0 ms Beats 100.00%
// Memory 4.08 MB Beats 51.53%
func check(nums []int) bool {
    if len(nums) == 1 {
        return true
    }
    isStart := false
    max := nums[0]
    for i := 0; i < len(nums) - 1; i++ {
        if nums[i + 1] - nums[i] < 0 {
            if isStart == true {
                return false
            } else {
                isStart = true
                max = nums[i]
            }
        } else if isStart == true && nums[i + 1] > max {
            return false
        }
    }
    if (isStart == true && nums[0] < nums[len(nums) - 1]) {
        return false
    } 
    return true
}

// Runtime 0 ms Beats 100.00%
// Memory 3.96 MB Beats 93.25%
func check(nums []int) bool {
    isStart := false
    for i := 1; i < len(nums); i++ {
        if nums[i] < nums[i - 1] {
            if isStart == true {
                return false
            } else {
                isStart = true
            }
        }
    }
    if (isStart == true && nums[0] < nums[len(nums) - 1]) {
        return false
    } 
    return true
}