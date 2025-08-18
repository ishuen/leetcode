// 35. Search Insert Position

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104

// Runtime 0 ms Beats 100.00%
// Memory 4.84 MB Beats 34.72%
func searchInsert(nums []int, target int) int {
    left := 0
    right := len(nums) - 1
    if nums[left] > target {
        return 0
    } else if nums[right] < target {
        return right + 1
    }
    mid := (left + right) / 2
    for ; nums[mid] != target; {
        if nums[mid] > target && nums[mid - 1] < target {
            return mid
        }
        if nums[mid] > target {
            right = mid - 1
        } else {
            left = mid + 1
        }
        mid = (left + right) / 2
    }
    return mid
}

// Runtime 0 ms Beats 100.00%
// Memory 4.95 MB Beats 3.19%
func searchInsert(nums []int, target int) int {
    left := 0
    right := len(nums)
    mid := (left + right) / 2
    for ;left < right; {
        if nums[mid] >= target {
            right = mid
        } else {
            left = mid + 1
        }
        mid = (left + right) / 2
    }
    return left
}