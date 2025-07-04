// 31. Next Permutation
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
// The replacement must be in place and use only constant extra memory.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
//
// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:
//
// Input: nums = [1,1,5]
// Output: [1,5,1]
// Example 4:
//
// Input: nums = [1]
// Output: [1]
//
//
// Constraints:
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Runtime: 1 ms, faster than 41.42% of Java online submissions for Next Permutation.
// Memory Usage: 39.1 MB, less than 54.61% of Java online submissions for Next Permutation.
class Solution {
    public void nextPermutation(int[] nums) {
        int swapTarget = nums.length - 1;
        boolean found = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= 1 && found == false && nums[i] > nums[i - 1]) {
                swapTarget = i - 1;
                found = true;
                break;
            }
        }
        if (found == false) Arrays.sort(nums);
        else {
            int next = nums[nums.length - 1];
            int nextIndex = nums.length - 1;
            while (next <= nums[swapTarget] && nextIndex > swapTarget) {
                nextIndex--;
                next = nums[nextIndex];
            }
            for (int i = nextIndex; i > swapTarget; i--) {
                if (next > nums[i] && nums[swapTarget] < nums[i]) {
                    next = nums[i];
                    nextIndex = i;
                }
            }
            nums[nextIndex] = nums[swapTarget];
            nums[swapTarget] = next;
            Arrays.sort(nums, swapTarget + 1, nums.length);
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
// Memory Usage: 39.3 MB, less than 30.33% of Java online submissions for Next Permutation.
class Solution {
    public void nextPermutation(int[] nums) {
        int swapTarget = nums.length - 1;
        boolean found = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= 1 && found == false && nums[i] > nums[i - 1]) {
                swapTarget = i - 1;
                found = true;
                break;
            }
        }
        if (found == false) reverse(nums, 0, nums.length - 1);
        else {
            int next = nums[nums.length - 1];
            int nextIndex = nums.length - 1;
            while (next <= nums[swapTarget] && nextIndex > swapTarget) {
                nextIndex--;
                next = nums[nextIndex];
            }
            for (int i = nextIndex; i > swapTarget; i--) {
                if (next > nums[i] && nums[swapTarget] < nums[i]) {
                    next = nums[i];
                    nextIndex = i;
                }
            }
            swap(nums, nextIndex, swapTarget);
            
            reverse(nums, swapTarget + 1, nums.length - 1);
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
}