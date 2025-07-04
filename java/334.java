// 334. Increasing Triplet Subsequence
// Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3,4,5]
// Output: true
// Explanation: Any triplet where i < j < k is valid.
// Example 2:
//
// Input: nums = [5,4,3,2,1]
// Output: false
// Explanation: No triplet exists.
// Example 3:
//
// Input: nums = [2,1,5,0,4,6]
// Output: true
// Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
//
//
// Constraints:
//
// 1 <= nums.length <= 5 * 105
// -231 <= nums[i] <= 231 - 1
//
//
// Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
//
// Runtime 5 ms Beats 19.52%
// Memory 93.2 MB Beats 77.38%
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] lastElement = new int[3];
        Arrays.fill(lastElement, Integer.MIN_VALUE);
        lastElement[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (lastElement[index] < nums[i] && index < lastElement.length - 1) {
                index++;
                lastElement[index] = nums[i];
                if (index == lastElement.length - 1) return true;
            } else {
                for (int j = index; j > 0; j--) {
                    if (lastElement[j - 1] < nums[i] && lastElement[j] > nums[i]) {
                        lastElement[j] = nums[i];
                        break;
                    }
                }
                if (lastElement[0] > nums[i]) lastElement[0] = nums[i];
            }
            
        }
        return lastElement[lastElement.length - 1] != Integer.MIN_VALUE;
    }
}

// Runtime 13 ms Beats 5.53%
// Memory 91.8 MB Beats 93.85%
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] lastElement = new int[nums.length];
        Arrays.fill(lastElement, Integer.MIN_VALUE);
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(lastElement, 0, end, nums[i]);
            if (index < 0) {
                index = -index -1;
            }
            lastElement[index] = nums[i];
            if (index == end) end++;
        }
        return end >= 3;
    }
}

// Runtime 9 ms Beats 8.73%
// Memory 93.9 MB Beats 24.79%
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(nums, 0, end, nums[i]);
            if (index < 0) {
                index = -index -1;
            }
            nums[index] = nums[i];
            if (index == end) {
                end++;
                if (end >= 3) return true;
            }
        }
        return end >= 3;
    }
}