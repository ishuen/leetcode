// 560. Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
//
// Example 1:
//
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
//
// Input: nums = [1,2,3], k = 3
// Output: 2
//
//
// Constraints:
//
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
//
// Runtime: 1266 ms, faster than 11.43% of Java online submissions for Subarray Sum Equals K.
// Memory Usage: 41.4 MB, less than 66.01% of Java online submissions for Subarray Sum Equals K.
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) count++;
            }
        }
        return count;
    }
}

// prefixSum [1st, 1st+2nd, 1..3rd, .. 1..last]
// the sum of any subarray = prefixSum[m] - prefixSum[n]


// Runtime: 1220 ms, faster than 18.52% of Java online submissions for Subarray Sum Equals K.
// Memory Usage: 41.4 MB, less than 66.01% of Java online submissions for Subarray Sum Equals K.
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int count = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) count++;
            }
        }
        return count;
    }
}

// Runtime: 18 ms, faster than 71.28% of Java online submissions for Subarray Sum Equals K.
// Memory Usage: 40.8 MB, less than 99.17% of Java online submissions for Subarray Sum Equals K.
class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            if (prefix.containsKey(prefixSum - k)) {
                count = count + prefix.get(prefixSum - k);
            }
            prefix.put(prefixSum, prefix.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}