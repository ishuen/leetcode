// 315. Count of Smaller Numbers After Self
// You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//
//
// Example 1:
//
// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]
// Explanation:
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Example 2:
//
// Input: nums = [-1]
// Output: [0]
// Example 3:
//
// Input: nums = [-1,-1]
// Output: [0,0]
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
// Runtime: 69 ms, faster than 70.31% of Java online submissions for Count of Smaller Numbers After Self.
// Memory Usage: 60.3 MB, less than 22.78% of Java online submissions for Count of Smaller Numbers After Self.
class Solution {
    Integer[] counts;
    public List<Integer> countSmaller(int[] nums) {
        counts = new Integer[nums.length];
        Arrays.fill(counts, 0);
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
    	    indexes[i] = i;
        }
        mergeSort(0, nums.length - 1, nums, indexes);
        return Arrays.asList(counts);
    }

    private void mergeSort(int start, int end, int[] nums, int[] indexes) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid, nums, indexes);
        mergeSort(mid + 1, end, nums, indexes);
        merge(start, end, nums, indexes);
    }
    
    private void merge(int start, int end, int[] nums, int[] indexes) {
        int mid = (start + end) / 2;
        int leftPointer = start;
        int rightPointer = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        int index = 0;
        while (leftPointer <= mid && rightPointer <= end) {
            if (nums[indexes[leftPointer]] > nums[indexes[rightPointer]]) {
                newIndexes[index] = indexes[rightPointer];
                rightCount++;
                rightPointer++;
            } else {
                newIndexes[index] = indexes[leftPointer];
                counts[indexes[leftPointer]] += rightCount;
                leftPointer++;
            }
            index++;
        }
        while (leftPointer <= mid) {
            newIndexes[index] = indexes[leftPointer];
            counts[indexes[leftPointer]] += rightCount;
            leftPointer++;
            index++;
        }
        while (rightPointer <= end) {
            newIndexes[index] = indexes[rightPointer];
            rightPointer++;
            index++;
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
}