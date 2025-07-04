// 454. 4Sum II
// Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
//
// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//
// Example 1:
//
// Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
// Output: 2
// Explanation:
// The two tuples are:
// 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
// 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
// Example 2:
//
// Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
// Output: 1
//
//
// Constraints:
//
// n == nums1.length
// n == nums2.length
// n == nums3.length
// n == nums4.length
// 1 <= n <= 200
// -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
//
// Runtime 131 ms Beats 65.52%
// Memory 43 MB Beats 32.50%
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        Map<Integer, Integer> sumCount = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = nums3[i] + nums4[j];
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                count = count + sumCount.getOrDefault(-1 * (nums1[i] + nums2[j]), 0);
            }
        }
        return count;
    }
}


// Runtime 176 ms Beats 13.54%
// Memory 42.6 MB Beats 73.35%
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        Map<Integer, Integer> sumCount12 = new HashMap<>();
        Map<Integer, Integer> sumCount34 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum12 = nums1[i] + nums2[j];
                sumCount12.put(sum12, sumCount12.getOrDefault(sum12, 0) + 1);
                int sum34 = nums3[i] + nums4[j];
                sumCount34.put(sum34, sumCount34.getOrDefault(sum34, 0) + 1);
            }
        }
        int count = 0;
        for (int base: sumCount12.keySet()) {
            count = count + sumCount12.get(base) * sumCount34.getOrDefault((-1) * base, 0);
        }
        return count;
    }
}
