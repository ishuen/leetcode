// 128. Longest Consecutive Sequence

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

 

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Example 3:

// Input: nums = [1,0,1,2]
// Output: 3
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

// Runtime 7 ms Beats 94.54%
// Memory 10.40 MB Beats 97.83%
func longestConsecutive(nums []int) int {
    if len(nums) <= 1 {
        return len(nums)
    }
    sort.Ints(nums)
    last := nums[0]
    count := 1
    max := 1
    for i := 1; i < len(nums); i++ {
        if nums[i] == last + 1 {
            count++
            if count > max {
                max = count
            }
        } else if nums[i] > last + 1 {
            count = 1
        }
        last = nums[i]
    }
    return max
}