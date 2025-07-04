// 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

// You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

 

// Example 1:

// Input: nums = [1,4,3,3,2]

// Output: 2

// Explanation:

// The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

// The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

// Hence, we return 2.

// Example 2:

// Input: nums = [3,3,3,3]

// Output: 1

// Explanation:

// The strictly increasing subarrays of nums are [3], [3], [3], and [3].

// The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

// Hence, we return 1.

// Example 3:

// Input: nums = [3,2,1]

// Output: 3

// Explanation:

// The strictly increasing subarrays of nums are [3], [2], and [1].

// The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

// Hence, we return 3.

 

// Constraints:

// 1 <= nums.length <= 50
// 1 <= nums[i] <= 50

// Runtime 0 ms Beats 100.00%
// Memory 4.40 MB Beats 98.44%
import "math"
func longestMonotonicSubarray(nums []int) int {
    if len(nums) == 1 {
        return 1
    }
    var isIncrease bool 
    if nums[1] - nums[0] > 0 {
        isIncrease = true
    } else {
        isIncrease = false
    }
    start := 0
    var max float64 = 1
    for i := 1; i < len(nums); i++ {
        if nums[i] > nums[i-1] {
            if !isIncrease {
                isIncrease = true
                max = math.Max(max, float64(i - start))
                start = i - 1
            }
        } else if nums[i] < nums[i - 1] {
            if isIncrease {
                isIncrease = false
                max = math.Max(max, float64(i - start))
                start = i - 1
            }
        } else {
            max = math.Max(max, float64(i - start))
            start = i
        }
    }
    max = math.Max(max, float64(len(nums) - start))
    return int(max)
}