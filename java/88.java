// 88. Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
// Example 1:
//
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:
//
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
// Example 3:
//
// Input: nums1 = [0], m = 0, nums2 = [1], n = 1
// Output: [1]
// Explanation: The arrays we are merging are [] and [1].
// The result of the merge is [1].
// Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
// Constraints:
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[j] <= 109
// Follow up: Can you come up with an algorithm that runs in O(m + n) time?
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
// Memory Usage: 39.3 MB, less than 32.87% of Java online submissions for Merge Sorted Array.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < m + n && pointer2 < n) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                if (pointer1 == m + pointer2) {
                    nums1[pointer1] = nums2[pointer2];
                    pointer2++;
                }
            }
            else {
                shift(m - pointer1 + pointer2, pointer1, nums1);
                nums1[pointer1] = nums2[pointer2];
                pointer2++;
            }
            pointer1++;
        }
    }
    
    private void shift(int count, int index, int[] nums) {
        for (int i = index + count; i > index; i--) {
            nums[i] = nums[i - 1];
        }
    }
}

// Runtime 0 ms Beats 100.00%
// Memory 42.56 MB Beats 15.59%
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len2 = nums1.length;
        for (int i = 0; i < m; i++) {
            if (len2 - i - 1 > 0) {
                nums1[len2 - i - 1] = nums1[m - i - 1];
            }
        }
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = len2 - m;
        int len = nums1.length;
        while (pointer2 < n && pointer1 < len && pointer3 < len && pointer3 > pointer1) {
            if (nums1[pointer3] <= nums2[pointer2]) {
                nums1[pointer1] = nums1[pointer3];
                pointer3++;
            } else {
                nums1[pointer1] = nums2[pointer2];
                pointer2++;
            }
			pointer1++;
        }
        while (pointer2 < n && pointer1 < len) {
            nums1[pointer1] = nums2[pointer2];
            pointer1++;
            pointer2++;
        }
        while (pointer3 < len && pointer1 < len && pointer3 > pointer1) {
            nums1[pointer1] = nums1[pointer3];
            pointer3++;
            pointer1++;
        }
    }
}