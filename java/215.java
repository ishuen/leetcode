// 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.
//
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// Example 1:
//
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:
//
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
//
// Constraints:
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104

// Runtime: 1 ms, faster than 97.76% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.6 MB, less than 20.81% of Java online submissions for Kth Largest Element in an Array.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// Runtime: 17 ms, faster than 12.29% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.7 MB, less than 14.25% of Java online submissions for Kth Largest Element in an Array.
class Solution {
public int findKthLargest(int[] nums, int k) {
	if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
}

public int findKthLargest(int[] nums, int start, int end, int k) {
    if (start > end) return Integer.MAX_VALUE;
    int pivot = nums[end];
    int left = start;
    for (int i = start; i < end; i++) {
        if (nums[i] <= pivot) {
            swap(nums, left++, i);
        }
    }
    swap(nums, left, end);
    
    if (left == k)
        return nums[left];
    else if (left < k)
        return findKthLargest(nums, left + 1, end, k);
    else
        return findKthLargest(nums, start, left - 1, k);
} 

    
    private void swap(int[] nums, int sourceIndex, int targetIndex) {
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }
}
// partial quick sort