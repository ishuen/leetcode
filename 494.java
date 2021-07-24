// 494. Target Sum
// You are given an integer array nums and an integer target.
//
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.
//
//
//
// Example 1:
//
// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
// Example 2:
//
// Input: nums = [1], target = 1
// Output: 1
//
//
// Constraints:
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
// Runtime: 2 ms, faster than 97.20% of Java online submissions for Target Sum.
// Memory Usage: 36.4 MB, less than 92.26% of Java online submissions for Target Sum.
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum = sum + num;
        }
        if (sum < target) return 0;
        return (sum + target) % 2 == 1 ? 0 : findSubset(nums, (target + sum) / 2);
    }
    private int findSubset(int[] nums, int target) {
        int[] subsets = new int[target + 1];
        subsets[0] = 1;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                if (subsets[i - num] > 0) subsets[i] += subsets[i - num];
            }
        }
        return subsets[target];
    }
}

// positive + negative = target
// positive - (sum - positive) = target
// positive = (target + sum) / 2