// 974. Subarray Sums Divisible by K
//
// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//
// A subarray is a contiguous part of an array.
//
//
//
// Example 1:
//
// Input: nums = [4,5,0,-2,-3,1], k = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by k = 5:
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// Example 2:
//
// Input: nums = [5], k = 9
// Output: 0
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// 2 <= k <= 104
//
// Runtime 20 ms Beats 67.24%
// Memory 48.7 MB Beats 5.39%
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num: nums) {
            sum = ((sum + num) % k + k) % k;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        for (int key: map.keySet()) {
            int occurence = map.get(key);
            count = count + occurence * (occurence - 1) / 2;
        }
        return count + map.getOrDefault(0, 0);
    }
}

// Runtime 5 ms Beats 75.13%
// Memory 46.1 MB Beats 64.60%
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int[] map = new int[k];
        int sum = 0;
        for (int num: nums) {
            sum = ((sum + num) % k + k) % k;
            map[sum]++;
        }
        count = map[0];
        for (int i = 0; i < k; i++) {
            count = count + map[i] * (map[i] - 1) / 2;
        }
        return count;
    }
}