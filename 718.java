// 718. Maximum Length of Repeated Subarray
// Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
//
//
//
// Example 1:
//
// Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
// Output: 3
// Explanation: The repeated subarray with maximum length is [3,2,1].
// Example 2:
//
// Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
// Output: 5
//
//
// Constraints:
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 100
//
// Runtime: 46 ms, faster than 64.49% of Java online submissions for Maximum Length of Repeated Subarray.
// Memory Usage: 48.1 MB, less than 42.04% of Java online submissions for Maximum Length of Repeated Subarray.
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] matrix = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > max) max = matrix[i][j];
                }
            }
        }
        return max;
    }
}