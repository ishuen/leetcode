// 801. Minimum Swaps To Make Sequences Increasing
// You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].
//
// For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
// Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.
//
// An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].
//
//
//
// Example 1:
//
// Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
// Output: 1
// Explanation:
// Swap nums1[3] and nums2[3]. Then the sequences are:
// nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
// which are both strictly increasing.
// Example 2:
//
// Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
// Output: 1
//
//
// Constraints:
//
// 2 <= nums1.length <= 105
// nums2.length == nums1.length
// 0 <= nums1[i], nums2[i] <= 2 * 105
//
// Runtime: 2 ms, faster than 76.88% of Java online submissions for Minimum Swaps To Make Sequences Increasing.
// Memory Usage: 55 MB, less than 23.87% of Java online submissions for Minimum Swaps To Make Sequences Increasing.
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int swapCount = 1; // min if swap current element
        int fixCount = 0; // min if not to swap current element
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] >= nums2[i] || nums2[i - 1] >= nums1[i]) {
                // if prev swap, this also has to swap
                swapCount++;
            } else if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                // must change
                int temp = swapCount;
                swapCount = fixCount + 1;
                fixCount = temp;
            } else {
                // change or not to change doesn't matter
                fixCount = Math.min(swapCount, fixCount);
                swapCount = fixCount + 1;
            }
        }
        return Math.min(swapCount, fixCount);
    }
}

