// 18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:
//
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
//
//
// Constraints:
//
// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
//
// Runtime: 24 ms, faster than 29.95% of Java online submissions for 4Sum.
// Memory Usage: 39.8 MB, less than 38.34% of Java online submissions for 4Sum.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        ans.add(temp);
                        start = findNextStart(start, nums);
                        end = findNextEnd(end, nums);
                    } else if (sum < target) {
                        start = findNextStart(start, nums);
                    } else {
                        end = findNextEnd(end, nums);
                    }
                }
                j = findNextStart(j, nums);
            }
            i = findNextStart(i, nums);
        }
        return ans;
    }
    
    private int findNextStart(int start, int[] nums) {
        if (start >= nums.length - 1) return nums.length;
        while (start < nums.length - 1 && nums[start] == nums[start + 1])
            start++;
        return start + 1;
    }
    
    private int findNextEnd(int end, int[] nums) {
        if (end < 1) return - 1;
        while (end > 0 && nums[end] == nums[end - 1])
            end--;
        return end - 1;
    }
}

