// 16. 3Sum Closest
// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//
//
// Example 1:
//
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//
// Constraints:
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Runtime: 4 ms, faster than 86.56% of Java online submissions for 3Sum Closest.
// Memory Usage: 38.4 MB, less than 89.18% of Java online submissions for 3Sum Closest.
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int mid = start + 1;
        int closest = nums[start] + nums[mid] + nums[end];
        while(start < nums.length - 2) {
            mid = start + 1;
            end = nums.length - 1;
            while (mid < end) {
                int sum = nums[start] + nums[mid] + nums[end];
                if (sum < target) {
                    mid++;
                } else if (sum == target) return sum;
                else {
                    end--;
                }
                if (Math.abs(sum - target) < Math.abs(closest - target))
                closest = sum;
            }
            start++;
        }
        return closest;
    } 
}