// 1283. Find the Smallest Divisor Given a Threshold
//
// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
//
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
//
// The test cases are generated so that there will be an answer.
//
//
//
// Example 1:
//
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
// Example 2:
//
// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44
//
//
// Constraints:
//
// 1 <= nums.length <= 5 * 104
// 1 <= nums[i] <= 106
// nums.length <= threshold <= 106
//
// Runtime 11ms Beats 87.88%of users with Java
// Memory 47.29MB Beats 26.02%of users with Java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = findMax(nums);

        int minMid = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i] / mid;
                if (nums[i] % mid != 0) {
                    val++;
                }
                sum = sum + val;
            }
            if (sum <= threshold) {
                minMid = Math.min(mid, minMid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return minMid;
    }

    private int findMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}

// Runtime 29ms Beats 65.81%of users with Java
// Memory 46.52MB Beats 89.53%of users with Java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = findMax(nums);

        int minMid = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int val = (int) Math.ceil((double)nums[i] / mid);
                sum = sum + val;
            }
            if (sum <= threshold) {
                minMid = Math.min(mid, minMid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return minMid;
    }

    private int findMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}