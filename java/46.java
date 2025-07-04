// 46. Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:
//
// Input: nums = [1]
// Output: [[1]]
//
//
// Constraints:
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
//
// Runtime: 1 ms, faster than 92.86% of Java online submissions for Permutations.
// Memory Usage: 39.1 MB, less than 71.18% of Java online submissions for Permutations.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> baseList = new ArrayList<Integer>();
        baseList.add(nums[0]);
        ans.add(baseList);
        if (nums.length == 1) return ans;
        for (int i = 1; i < nums.length; i++) {
            int ansSize = ans.size();
            for (int j = 0; j < ansSize; j++) {
                List<Integer> curList = ans.get(j);
                int curSize = curList.size();
                for (int k = 0; k <= curSize; k++) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.addAll(curList);
                    tempList.add(k, nums[i]);
                    if (k == 0) ans.set(j, tempList);
                    else ans.add(tempList);
                }
            }
            
        }
        return ans;
    }
}

// 2 elements + 1 element
// [a, b] + [c] => [c, a, b], [a, c, b], [a, b, c]
// [b, a] + [c] => [c, b, a], [b, c, a], [b, a, c]