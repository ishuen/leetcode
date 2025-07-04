// 78. Subsets
// Given an integer array nums of unique elements, return all possible subsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// All the numbers of nums are unique.
//
// Runtime: 1 ms, faster than 58.37% of Java online submissions for Subsets.
// Memory Usage: 39.1 MB, less than 68.55% of Java online submissions for Subsets.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        subsets(nums, new ArrayList<>(), ans);
        return ans;
    }
    
    private void subsets(int[] nums, List<Integer> tempList, List<List<Integer>> ans) {
        int index = findIndex(nums, tempList);
        for (int i = index + 1; i < nums.length; i++) {
            tempList.add(nums[i]);
            ans.add(new ArrayList<>(tempList));
            subsets(nums, tempList, ans);
            tempList.remove(tempList.size() - 1);
        }
    }
    private int findIndex(int[] nums, List<Integer> list) {
        if (list.size() == 0) return -1;
        int last = list.get(list.size() - 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last) return i;
        }
        return nums.length;
    }
}