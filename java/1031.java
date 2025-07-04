// 1031. Maximum Sum of Two Non-Overlapping Subarrays
//
// Given an integer array nums and two integers firstLen and secondLen, return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.
//
// The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.
//
// A subarray is a contiguous part of an array.
//
//
//
// Example 1:
//
// Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
// Output: 20
// Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
// Example 2:
//
// Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
// Output: 29
// Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
// Example 3:
//
// Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
// Output: 31
// Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] with length 3.
//
//
// Constraints:
//
// 1 <= firstLen, secondLen <= 1000
// 2 <= firstLen + secondLen <= 1000
// firstLen + secondLen <= nums.length <= 1000
// 0 <= nums[i] <= 1000
//
// Runtime 3 ms Beats 35.47%
// Memory 41.3 MB Beats 87.92%
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] memory = new int[nums.length];
        int sumB = 0;
        for (int i = 0; i < secondLen; i++) {
            sumB = sumB + nums[i];
        }
        memory[0] = sumB;
        int indexB = 0;
        while (indexB < nums.length - secondLen) {
            sumB = sumB - nums[indexB] + nums[indexB + secondLen];
            indexB++;
            memory[indexB] = sumB;
        }
        int indexA = 0;
        int sumA = 0;
        int max = 0;
        for (int i = 0; i < firstLen - 1; i++) {
            sumA = sumA + nums[i];
        }
        while (indexA <= nums.length - firstLen) {
            sumA = sumA + nums[indexA + firstLen - 1];
            int maxB = 0;
            int leftIndex = indexA - secondLen;
            if (leftIndex >= 0) {
                for (int i = 0; i <= leftIndex; i++) {
                    maxB = Math.max(maxB, memory[i]);
                }
            }
            int rightIndex = indexA + firstLen;
            if (rightIndex <= nums.length - secondLen) {
                for (int i = rightIndex; i <= nums.length - secondLen; i++) {
                    maxB = Math.max(maxB, memory[i]);
                }
            }
            max = Math.max(sumA + maxB, max);
            sumA = sumA - nums[indexA];
            indexA++;
        }
        return max;
    }
}

// Runtime 2 ms Beats 52.8%
// Memory 41.3 MB Beats 83.77%
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] memory = new int[nums.length];
        int sumB = 0;
        for (int i = 0; i < secondLen; i++) {
            sumB = sumB + nums[i];
        }
        memory[0] = sumB;
        int indexB = 0;
        while (indexB < nums.length - secondLen) {
            sumB = sumB - nums[indexB] + nums[indexB + secondLen];
            indexB++;
            memory[indexB] = sumB;
        }
        int indexA = 0;
        int sumA = 0;
        int max = 0;
        int leftIndex = indexA - secondLen;
        int lastLeftMax = memory[0];
        for (int i = 0; i < firstLen - 1; i++) {
            sumA = sumA + nums[i];
        }
        while (indexA <= nums.length - firstLen) {
            sumA = sumA + nums[indexA + firstLen - 1];
            int maxB = 0;
            if (leftIndex >= 0) {
                lastLeftMax = Math.max(lastLeftMax, memory[leftIndex]);
                maxB = Math.max(maxB, lastLeftMax);
            }
            int rightIndex = indexA + firstLen;
            if (rightIndex <= nums.length - secondLen) {
                for (int i = rightIndex; i <= nums.length - secondLen; i++) {
                    maxB = Math.max(maxB, memory[i]);
                }
            }
            max = Math.max(sumA + maxB, max);
            sumA = sumA - nums[indexA];
            indexA++;
            leftIndex++;
        }
        return max;
    }
}

// Runtime 2 ms Beats 52.8%
// Memory 41.7 MB Beats 65.28%
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = findMaxSum(nums, firstLen, secondLen);
        int max2 = findMaxSum(nums, secondLen, firstLen);
        return Math.max(max1, max2);
    }
    private int findMaxSum(int[] nums, int leftLen, int rightLen) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < leftLen - 1; i++) {
            sum = sum + nums[i];
        }
        for (int i = leftLen - 1; i < nums.length; i++) {
            sum = sum + nums[i];
            if (i > 0) {
                leftMax[i] = Math.max(leftMax[i - 1], sum);
            } else {
                leftMax[i] = sum;
            }
            sum = sum - nums[i - leftLen + 1];
        }
        sum = 0;
        for (int i = nums.length - 1; i > nums.length - rightLen; i--) {
            sum = sum + nums[i];   
        }
        for (int i = nums.length - rightLen; i >= 0; i--) {
            sum = sum + nums[i];
            if (i < nums.length - 1) {
                rightMax[i] = Math.max(rightMax[i + 1], sum);
            } else {
                rightMax[i] = sum;
            }
            sum = sum - nums[i + rightLen - 1];
        }
        int max = 0;
        for (int i = leftLen - 1; i < nums.length - rightLen; i++) {
            max = Math.max(max, leftMax[i] + rightMax[i + 1]);
        }
        return max;
    }
}