// 219. Contains Duplicate II

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105

// Runtime 32 ms Beats 75.00%
// Memory 14.44 MB Beats 27.42%
func containsNearbyDuplicate(nums []int, k int) bool {
    if len(nums) == 1 || k == 0 {
        return false
    }
    set := make(map[int]int)
    for index, value := range nums {
        prevIndex, ok := set[value]
        if !ok {
            set[value] = index
        } else if index - prevIndex <= k {
            return true
        } else if index - prevIndex > k {
            set[value] = index
        }
    }
    return false
}
