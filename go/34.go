// 34. Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

// Runtime 0 ms Beats 100.00%
// Memory 6.41 MB Beats 32.69%
func searchRange(nums []int, target int) []int {
    left := 0
    right := len(nums) - 1
    for ; left <= right; {
        mid := (left + right) / 2
        if nums[mid] == target {
            return findRange(mid, nums, target)
        } else if nums[mid] > target {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return []int{-1, -1}
}

func findRange(mid int, nums []int, target int) []int {
    left := mid
    for i := mid - 1; i >= 0; i-- {
        if nums[i] != target {
            left = i + 1
            break;
        }
        left--
    }
    right := mid
    for i := mid + 1; i < len(nums); i++ {
        if nums[i] != target {
            right = i - 1
            break;
        }
        right++
    }
    return []int{left, right}
}
