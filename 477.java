// 477. Total Hamming Distance
// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
// Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
//
//
//
// Example 1:
//
// Input: nums = [4,14,2]
// Output: 6
// Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
// showing the four bits relevant in this case).
// The answer will be:
// HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
// Example 2:
//
// Input: nums = [4,14,4]
// Output: 4
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
//
// Runtime: 13 ms, faster than 56.45% of Java online submissions for Total Hamming Distance.
// Memory Usage: 40.4 MB, less than 19.85% of Java online submissions for Total Hamming Distance.
class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            int k = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & k) != 0) {
                    one++;
                } else {
                    zero++;
                }
            }
            count = count + one * zero;
        }
        return count;
    }
}