// 377. Combination Sum IV
// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//
// The answer is guaranteed to fit in a 32-bit integer.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
// Example 2:
//
// Input: nums = [9], target = 3
// Output: 0
//
//
// Constraints:
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// All the elements of nums are unique.
// 1 <= target <= 1000
//
//
// Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
//
// Runtime: 1 ms, faster than 79.24% of Java online submissions for Combination Sum IV.
// Memory Usage: 36 MB, less than 89.37% of Java online submissions for Combination Sum IV.
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int[] permutations = new int[target + 1];
        permutations[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    permutations[i] = permutations[i] + permutations[i - nums[j]];
                }
            }
        }
        return permutations[target];
    }
}

// target 4
// 1 + 3
// 2 + 2
// 3 + 1

// [1, 2, 3]
//   1 2 3 4
// [ 1 1 1  ]
//     2 4

// 1: 1
// 2: 1 + 1, 2
// 3: 1 + 1 + 1, 1 + 2, 2 + 1, 3