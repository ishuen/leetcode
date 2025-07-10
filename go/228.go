// 228. Summary Ranges

// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

// Each range [a,b] in the list should be output as:

// "a->b" if a != b
// "a" if a == b
 

// Example 1:

// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:

// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"
 

// Constraints:

// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// All the values of nums are unique.
// nums is sorted in ascending order.


// Runtime 0 ms Beats 100.00%
// Memory 3.81 MB Beats 77.88%
func summaryRanges(nums []int) []string {
    if len(nums) == 0 {
        return []string{}
    }
    start := 0
    index := 0
    output := []string{}
    for end := 0; end < len(nums); end++ {
        if end != start && nums[end] != nums[end - 1] + 1 {
            output = append(output, print(start, end - 1, nums))
            if end < len(nums) {
                start = end
            }
            index++
        }
    }
    output = append(output, print(start, len(nums) - 1, nums))
    return output
}

func print(start, end int, nums []int) string {
    if start == end {
        return strconv.Itoa(nums[start])
    }
    return fmt.Sprintf(strconv.Itoa(nums[start]) + "->" + strconv.Itoa(nums[end]))
}