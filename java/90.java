// 90. Subsets II
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
// Example 1:
//
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:
//
// Input: nums = [0]
// Output: [[],[0]]
//
//
// Constraints:
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
// Runtime: 1 ms, faster than 99.59% of Java online submissions for Subsets II.
// Memory Usage: 39.1 MB, less than 71.59% of Java online submissions for Subsets II.
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void subset(int[] nums, int startIndex, List<Integer> tempList, List<List<Integer>> ans) {
        for (int i = startIndex; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(tempList);
            newList.add(nums[i]);
            ans.add(newList);
            subset(nums, i + 1, newList, ans);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}

