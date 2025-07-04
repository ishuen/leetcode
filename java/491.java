// 491. Increasing Subsequences
// Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.
//
// The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.
//
//
//
// Example 1:
//
// Input: nums = [4,6,7,7]
// Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// Example 2:
//
// Input: nums = [4,4,3,2,1]
// Output: [[4,4]]
//
//
// Constraints:
//
// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100
//
// Runtime: 4 ms, faster than 92.43% of Java online submissions for Increasing Subsequences.
// Memory Usage: 45.7 MB, less than 75.44% of Java online submissions for Increasing Subsequences.
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsequences(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void findSubsequences(int start, int[] nums, List<Integer> tempList, List<List<Integer>> ans) {
        Set<Integer> last = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (tempList.size() > 0 && nums[i] < tempList.get(tempList.size() - 1)) continue;
            int curSize = last.size();
            last.add(nums[i]);
            if (curSize == last.size()) continue;
            tempList.add(nums[i]);
            if (tempList.size() >= 2) ans.add(new ArrayList<>(tempList));
            findSubsequences(i + 1, nums, tempList, ans);
            tempList.remove(tempList.size() - 1);
        }
    }
}