// 47. Permutations II
// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
// Example 1:
//
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:
//
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// Constraints:
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Runtime: 1 ms, faster than 99.36% of Java online submissions for Permutations II.
// Memory Usage: 39.3 MB, less than 97.20% of Java online submissions for Permutations II.
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    
    private void permutation(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> ans) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] == nums[i] && used[i + 1] == used[i]) continue;
            if (used[i] == true) continue;
            used[i] = true;
            tempList.add(nums[i]);
            permutation(nums, used, tempList, ans);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }
}


