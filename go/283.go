// 283. Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

// Runtime 0 ms Beats 100.00%
// Memory 8.87 MB Beats 46.42%
func moveZeroes(nums []int)  {
    z := 0
    for i := 0; i < len(nums); i++ {
        for j := z; j < i; j++ {
            if nums[j] == 0 {
                z = j
                break
            }
        }
        if nums[i] != 0 && z < len(nums) && nums[z] == 0 {
            nums[z] = nums[i]
            nums[i] = 0
            z++
        }
    }
}