// 15. 3Sum

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
 

// Constraints:

// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105

// Runtime 33 ms Beats 29.31%
// Memory 9.32 MB Beats 86.39%
func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    ans := [][]int{}
    for i := 0; i < len(nums) - 2; i = moveLeft(i, nums) {
        left := i + 1
        right := len(nums) - 1
        target := - nums[i]
        for ; left < right; {
            sum := nums[left] + nums[right]
            if sum == target {
                ans = append(ans, []int{nums[i], nums[left], nums[right]})
                left = moveLeft(left, nums)
                right = moveRight(right, nums)
            } else if sum < target {
                left = moveLeft(left, nums)
            } else {
                right = moveRight(right, nums)
            }
        }
    }
    return ans
}

func moveLeft(left int, nums []int) int {
    val := nums[left]
    for ; left < len(nums) && val == nums[left]; {
        left++
    }
    return left
}

func moveRight(right int, nums []int) int {
    val := nums[right]
    for ; right >= 0 && val == nums[right]; {
        right--
    }
    return right
}