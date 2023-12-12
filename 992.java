// 992. Subarrays with K Different Integers
//
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
// A good array is an array where the number of different integers in that array is exactly k.
//
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.
//
//
//
// Example 1:
//
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
// Example 2:
//
// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
//
//
// Constraints:
//
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i], k <= nums.length
//
// Runtime 39 ms Beats 67.87% of users with Java
// Memory 45.24 MB Beats 47.37% of users with Java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtMostK(k, nums) - findAtMostK(k - 1, nums);
    }
    private int findAtMostK(int k, int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int occurrence = occurrences.getOrDefault(nums[right], 0);
            if (occurrence == 0) {
                k--;
            }
            occurrences.put(nums[right], occurrence + 1);
            while (k < 0) {
                int leftCount = occurrences.get(nums[left]) - 1;
                occurrences.put(nums[left], leftCount);
                left++;
                if (leftCount == 0) k++;
            }
            count = count + right - left + 1;
            right++;
        }
        return count;
    }
}