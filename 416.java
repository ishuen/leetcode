// 416. Partition Equal Subset Sum
// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
// Example 1:
//
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:
//
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
//
// Constraints:
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Runtime: 39 ms, faster than 52.11% of Java online submissions for Partition Equal Subset Sum.
// Memory Usage: 39.2 MB, less than 73.09% of Java online submissions for Partition Equal Subset Sum.
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[] canFit = new boolean[sum + 1];
        Arrays.fill(canFit, false);
        canFit[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (j >= nums[i]) {
                    canFit[j] = canFit[j] || canFit[j - nums[i]];
                }
            }
        }
        return canFit[sum];
    }
}

//        [1, 2, 3, 4, 5, 6, 7.. 15]
// i = 0   1  0  0  0  0  0  0
// i = 1   1  0  0  0  1  1
// i = 2   1  0  0  0  1  1     