// 611. Valid Triangle Number

// Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

// Example 1:

// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are: 
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3
// Example 2:

// Input: nums = [4,2,3,4]
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000

// Runtime 18 ms Beats 82.11%
// Memory 4.89 MB Beats 61.09%
func triangleNumber(nums []int) int {
    sort.Ints(nums)
    count := 0
    for i := 2; i < len(nums); i++ {
        left := 0
        for right := i - 1; right > left; {
            if nums[left] + nums[right] > nums[i] {
                count = count + right - left
                right--
            } else {
                left++
            }
        }
    }
    return count
}