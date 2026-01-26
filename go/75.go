// 75. Sort Colors

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.
 

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

// Runtime 0 ms Beats 100.00%
// Memory 3.98 MB Beats 95.36%
func sortColors(nums []int)  {
    zero := 0
    one := 0
    for _, num := range nums {
        if num == 0 {
            zero++
        } else if num == 1 {
            one++
        }
    }
    for i := 0; i < len(nums); i++ {
        if i < zero {
            nums[i] = 0
        } else if i < zero + one {
            nums[i] = 1
        } else {
            nums[i] = 2
        }
    }
}