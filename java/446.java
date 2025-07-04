// 446. Arithmetic Slices II - Subsequence
// Given an integer array nums, return the number of all the arithmetic subsequences of nums.
//
// A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
//
// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
// A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
//
// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
// The test cases are generated so that the answer fits in 32-bit integer.
//
//
//
// Example 1:
//
// Input: nums = [2,4,6,8,10]
// Output: 7
// Explanation: All arithmetic subsequence slices are:
// [2,4,6]
// [4,6,8]
// [6,8,10]
// [2,4,6,8]
// [4,6,8,10]
// [2,4,6,8,10]
// [2,6,10]
// Example 2:
//
// Input: nums = [7,7,7,7,7]
// Output: 16
// Explanation: Any subsequence of this array is arithmetic.
//
//
// Constraints:
//
// 1  <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
//
// Runtime: 148 ms, faster than 59.22% of Java online submissions for Arithmetic Slices II - Subsequence.
// Memory Usage: 86 MB, less than 46.12% of Java online submissions for Arithmetic Slices II - Subsequence.
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        Map<Integer, Integer>[] diffMaps = new Map[nums.length];
        diffMaps[0] = new HashMap<Integer, Integer>();
        for (int i = 1; i < nums.length; i++) {
            diffMaps[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                long d = (long)nums[i] - nums[j];
                if (d >= Integer.MAX_VALUE || d <= Integer.MIN_VALUE) continue;
                int diff = (int)d;
                int prevSeq = diffMaps[j].getOrDefault(diff, 0);
                count += prevSeq;
                diffMaps[i].put(diff, (diffMaps[i].getOrDefault(diff, 0)) + prevSeq + 1);
            }
        }
        return count;
    }
}
