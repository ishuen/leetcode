// 162. Find Peak Element

// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

// Constraints:

// 1 <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
// nums[i] != nums[i + 1] for all valid i.

// Runtime 0 ms Beats 100.00%
// Memory 4.74 MB Beats 1.23%
func findPeakElement(nums []int) int {
    arr := []int{math.MinInt}
    arr = append(arr, nums...)
    arr = append(arr, math.MinInt)
    for i := 1; i <= len(nums); i++ {
        if arr[i - 1] < arr[i] && arr[i] > arr[i + 1] {
            return i - 1
        }
    }
    return 0
}

// Runtime 0 ms Beats 100.00%
// Memory 4.57 MB Beats 64.78%
func findPeakElement(nums []int) int {
    nums = slices.Insert(nums, 0, math.MinInt)
    nums = append(nums, math.MinInt)
    for i := 1; i < len(nums) - 1; i++ {
        if nums[i - 1] < nums[i] && nums[i] > nums[i + 1] {
            return i - 1
        }
    }
    return 0
}