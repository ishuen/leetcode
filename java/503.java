// 503. Next Greater Element II
// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
//
//
//
// Example 1:
//
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2;
// The number 2 can't find next greater number.
// The second 1's next greater number needs to search circularly, which is also 2.
// Example 2:
//
// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Runtime: 37 ms, faster than 11.28% of Java online submissions for Next Greater Element II.
// Memory Usage: 52.4 MB, less than 10.36% of Java online submissions for Next Greater Element II.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int currentMax = nums[0];
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int nextIndex = i + 1;
            while (nextIndex < nums.length && nums[nextIndex] <= nums[i]) {
                nextIndex++;
            }
            if (nextIndex == nums.length && nums[i] >= currentMax) {
                ans[i] = -1;
                currentMax = nums[i];
            } else if (nextIndex < nums.length && nums[i] < nums[nextIndex]) {
                ans[i] = nums[nextIndex];
                currentMax = Math.max(currentMax, nums[i]);
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break;
                    }
                }
            }
        }
        if (nums[0] == currentMax) ans[0] = -1;
        return ans;
    }
}

// Runtime: 21 ms, faster than 17.42% of Java online submissions for Next Greater Element II.
// Memory Usage: 52.6 MB, less than 8.08% of Java online submissions for Next Greater Element II.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        int size = nums.length;
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % size;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = nums[index];
            }
            stack.push(index);
        }
        return ans;
    }
}