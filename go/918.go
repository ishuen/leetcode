// 918. Maximum Sum Circular Subarray

// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

// Example 1:

// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.
// Example 2:

// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// Example 3:

// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.
 

// Constraints:

// n == nums.length
// 1 <= n <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104

// Runtime 2 ms Beats 18.18%
// Memory 10.15 MB Beats 11.36%
func maxSubarraySumCircular(nums []int) int {
    nonCircular := maxSubArray(nums)
    sum := 0
    for i := 0; i < len(nums); i++ {
        sum = sum + nums[i]
        nums[i] = -nums[i]
    }
    circular := sum + maxSubArray(nums)
    if circular == 0 {
        return nonCircular
    }
    return max(circular, nonCircular)
}

func maxSubArray(nums []int) int {
    total := nums[0]
    ans := total
    for i := 1; i < len(nums); i++ {
        if total < 0 {
            total = 0
        }
        total = total + nums[i]
        ans = max(ans, total)
    }
    return ans
}

// Runtime 0 ms Beats 100.00%
// Memory 8.82 MB Beats 70.45%
func maxSubarraySumCircular(nums []int) int {
    nonCircular := nums[0]
    sum := nums[0]
    localSum := nonCircular
    for i := 1; i < len(nums); i++ {
        sum = sum + nums[i]
        localSum = max(localSum + nums[i], nums[i])
        nonCircular = max(nonCircular, localSum)
    }

    minSum := nums[0]
    localSum = nums[0]
    for i := 1; i < len(nums); i++ {
        localSum = min(localSum + nums[i], nums[i])
        minSum = min(minSum, localSum)
    }
    if sum == minSum {
        return nonCircular
    }
    return max(sum - minSum, nonCircular)
}