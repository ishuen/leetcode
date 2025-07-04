// 307. Range Sum Query - Mutable
// Given an integer array nums, handle multiple queries of the following types:
//
// Update the value of an element in nums.
// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// Implement the NumArray class:
//
// NumArray(int[] nums) Initializes the object with the integer array nums.
// void update(int index, int val) Updates the value of nums[index] to be val.
// int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
//
//
// Example 1:
//
// Input
// ["NumArray", "sumRange", "update", "sumRange"]
// [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
// Output
// [null, 9, null, 8]
//
// Explanation
// NumArray numArray = new NumArray([1, 3, 5]);
// numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
// numArray.update(1, 2);   // nums = [1, 2, 5]
// numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// 0 <= index < nums.length
// -100 <= val <= 100
// 0 <= left <= right < nums.length
// At most 3 * 104 calls will be made to update and sumRange.
//
// Runtime: 63 ms, faster than 83.02% of Java online submissions for Range Sum Query - Mutable.
// Memory Usage: 69.2 MB, less than 92.10% of Java online submissions for Range Sum Query - Mutable.
class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
        this.nums = nums;
    }

    public void update(int index, int val) {
        int diff = nums != null ? val - this.nums[index] : val;
        if (nums != null) nums[index] = val;
        index++;
        while(index < tree.length) {
            tree[index] = tree[index] + diff;
            index = index + (index & (-index));
        }
    }
    
    public int sumRange(int left, int right) {
        right++;
        int leftSum = 0;
        int rightSum = 0;
        while (left > 0) {
            leftSum = leftSum + tree[left];
            left = left - (left & (-left));
        }
        while (right > 0) {
            rightSum = rightSum + tree[right];
            right = right - (right & (-right));
        }
        return rightSum - leftSum;
    }
}