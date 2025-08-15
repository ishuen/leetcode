// 46. Permutations

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

// Runtime 0 ms Beats 100.00%
// Memory 4.64 MB Beats 53.07%
func permute(nums []int) [][]int {
    output := [][]int{}
    length := len(nums)
    var traverse func(used []bool, temp []int)
    traverse = func(used []bool, temp []int) {
        if len(temp) == length {
            newList := make([]int, length)
            copy(newList, temp)
            output = append(output, newList)
        }
        for i := 0; i < length; i++ {
            if used[i] == false {
                used[i] = true
                temp = append(temp, nums[i])
                traverse(used, temp)
                temp = temp[:len(temp) - 1]
                used[i] = false
            }
        }
    }
    traverse(make([]bool, length), []int{})
    return output
}