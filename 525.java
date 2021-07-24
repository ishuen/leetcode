// 525. Contiguous Array
// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
//
// Example 1:
//
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
// Example 2:
//
// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
//
// Runtime: 2255 ms, faster than 5.24% of Java online submissions for Contiguous Array.
// Memory Usage: 48.4 MB, less than 92.95% of Java online submissions for Contiguous Array.
class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] == 1 ? sum[i] + nums[i] : sum[i] - 1;
            if (sum[i + 1] == 0) max = i + 1;
        }
        if (max >= nums.length - 2) return max;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i + max + 1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == 0) {
                    max = Math.max(j - i, max);
                }
            }
        }
        return max;
    }
}

// Runtime: 19 ms, faster than 84.33% of Java online submissions for Contiguous Array.
// Memory Usage: 48.5 MB, less than 84.69% of Java online submissions for Contiguous Array.
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] == 1 ? sum + nums[i] : sum - 1;
            if (sums.containsKey(sum)) {
                max = Math.max(max, i - sums.get(sum));
            } else {
                sums.put(sum, i);
            }
        }
        return max;
    }
}