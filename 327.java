// 327. Count of Range Sum
// Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.
//
// Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.
//
//
//
// Example 1:
//
// Input: nums = [-2,5,-1], lower = -2, upper = 2
// Output: 3
// Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
// Example 2:
//
// Input: nums = [0], lower = 0, upper = 0
// Output: 1
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// -105 <= lower <= upper <= 105
// The answer is guaranteed to fit in a 32-bit integer.
//
// Runtime: 53 ms, faster than 80.50% of Java online submissions for Count of Range Sum.
// Memory Usage: 53.3 MB, less than 61.25% of Java online submissions for Count of Range Sum.
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return countRangeSum(prefixSums, 0, nums.length + 1, lower, upper);
    }
    
    private int countRangeSum(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countRangeSum(sums, start, mid, lower, upper) 
              + countRangeSum(sums, mid, end, lower, upper);
        int j = mid;
        int k = mid;
        int t = mid;
        int r = 0;
        long[] sorted = new long[end - start];
        for (int i = start; i < mid; i++) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) {
                sorted[r] = sums[t];
                r++;
                t++;
            }
            sorted[r] = sums[i];
            count += j - k;
            r++;
        }
        System.arraycopy(sorted, 0, sums, start, t - start);
        return count;
    }
}


// prefixSums: [(0), -2, 3, 2]
// sum = prefixSums[i] - prefixSums[j]
// prefixSums [ ...|...]
//              i    j
// 3 posibilities: i at 1st group, j at 2nd group; i, j at 1st group; 1, j at 2nd group