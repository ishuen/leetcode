// 698. Partition to K Equal Sum Subsets
// Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
//
// Example 1:
//
// Input: nums = [4,3,2,3,5,2,1], k = 4
// Output: true
// Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
// Example 2:
//
// Input: nums = [1,2,3,4], k = 3
// Output: false
//
//
// Constraints:
//
// 1 <= k <= nums.length <= 16
// 1 <= nums[i] <= 104
// The frequency of each element is in the range [1, 4].
//
// Runtime: 1 ms, faster than 92.34% of Java online submissions for Partition to K Equal Sum Subsets.
// Memory Usage: 36.6 MB, less than 40.02% of Java online submissions for Partition to K Equal Sum Subsets.
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        int target = sum / k;
        if (sum % k != 0) return false;
        if (max > target) return false;
        return canPartition(nums, new boolean[nums.length], 0, 0, target, k);
    }
    
    private boolean canPartition(int[] nums, boolean[] used, int startIndex, int curSum, int targetSum, int remainedSet) {
        if (curSum > targetSum) return false;
        if (curSum == targetSum) {
            if (remainedSet == 1) return true;
            curSum = 0;
            remainedSet--;
            startIndex = 0;
        } 
        for (int i = startIndex; i < nums.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            if (canPartition(nums, used, i + 1, curSum + nums[i], targetSum, remainedSet)) return true;
            used[i] = false;
        }
        return false;
    }
}