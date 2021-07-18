// 209. Minimum Size Subarray Sum
// Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//
//
//
// Example 1:
//
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
// Example 2:
//
// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:
//
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
//
//
// Constraints:
//
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
//
//
// Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
// Runtime: 974 ms, faster than 5.01% of Java online submissions for Minimum Size Subarray Sum.
// Memory Usage: 42.3 MB, less than 5.64% of Java online submissions for Minimum Size Subarray Sum.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        if (prefixSum[nums.length] < target) return 0;
        int min = nums.length;
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = prefixSum[i] - prefixSum[j];
                if (sum >= target && min > i - j) {
                    min = i - j;
                } else if (sum < target) break;
            }
        }
        return min;
    }
}


// Runtime: 477 ms, faster than 5.01% of Java online submissions for Minimum Size Subarray Sum.
// Memory Usage: 39.1 MB, less than 47.84% of Java online submissions for Minimum Size Subarray Sum.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum >= target && i + 1 < min) {
                min = i + 1;
                break;
            }
        }
        if (sum < target) return 0;
        if (min == 1) return min;
        for (int i = 1; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target && j - i + 1 < min) {
                    min = j - i + 1;
                    break;
                }
            }
        }
        return min;
    }
}

// Runtime: 1 ms, faster than 99.98% of Java online submissions for Minimum Size Subarray Sum.
// Memory Usage: 38.8 MB, less than 71.37% of Java online submissions for Minimum Size Subarray Sum.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = nums[0];
        int left = 0;
        int right = 0;
        while(right < nums.length && left <= right) {
            if (sum < target) {
                right++;
                if (right < nums.length) sum = sum + nums[right];
            } else if (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return left == 0 && right == nums.length && sum < target ? 0 : min;
    }
}