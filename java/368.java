// 368. Largest Divisible Subset
// Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.
// Example 2:
//
// Input: nums = [1,2,4,8]
// Output: [1,2,4,8]
//
//
// Constraints:
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2 * 109
// All the integers in nums are unique.
//
// Runtime: 15 ms, faster than 96.08% of Java online submissions for Largest Divisible Subset.
// Memory Usage: 39.1 MB, less than 53.97% of Java online submissions for Largest Divisible Subset.
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] numOfElements = new int[nums.length];
        numOfElements[0] = 1;
        int max = numOfElements[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            numOfElements[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    numOfElements[i] = Math.max(numOfElements[i], numOfElements[j] + 1);
                    if (numOfElements[i] > max) {
                        max = numOfElements[i];
                        maxIndex = i;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int count = numOfElements[maxIndex];
        int index = maxIndex;
        for (int i = index; i >= 0; i--) {
            if (nums[index] % nums[i] == 0 && numOfElements[i] == count) {
                ans.add(nums[i]);
                count--;
                index = i;
            }
        }
        return ans;
    }
}


