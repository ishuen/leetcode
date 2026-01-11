// 1679. Max Number of K-Sum Pairs

// You are given an integer array nums and an integer k.

// In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

// Return the maximum number of operations you can perform on the array.

 

// Example 1:

// Input: nums = [1,2,3,4], k = 5
// Output: 2
// Explanation: Starting with nums = [1,2,3,4]:
// - Remove numbers 1 and 4, then nums = [2,3]
// - Remove numbers 2 and 3, then nums = []
// There are no more pairs that sum up to 5, hence a total of 2 operations.
// Example 2:

// Input: nums = [3,1,3,4,3], k = 6
// Output: 1
// Explanation: Starting with nums = [3,1,3,4,3]:
// - Remove the first two 3's, then nums = [1,4,3]
// There are no more pairs that sum up to 6, hence a total of 1 operation.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// 1 <= k <= 109

// Runtime 141 ms Beats 7.58%
// Memory 13.30 MB Beats 9.70%
func maxOperations(nums []int, k int) int {
    slices.Sort(nums)
    count := 0
    left := 0
    right := len(nums) - 1
    for ; left < right; {
        if nums[left] + nums[right] == k {
            count++
            left++
            right--
        } else if nums[left] + nums[right] > k {
            right--
        } else {
            left++
        }
    }
    return count
}

// Runtime 78 ms Beats 82.73%
// Memory 9.89 MB Beats 73.64%
func maxOperations(nums []int, k int) int {
    indexes := map[int]int{}
    count := 0
    for _, value := range nums {
        complement := k - value
        v, ok := indexes[complement]
        if ok && v > 0 {
            count++
            indexes[complement]--
        } else {
            indexes[value]++
        }
    }
    return count
}