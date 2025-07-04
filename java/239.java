// 239. Sliding Window Maximum
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// Return the max sliding window.
//
//
//
// Example 1:
//
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:
//
// Input: nums = [1], k = 1
// Output: [1]
// Example 3:
//
// Input: nums = [1,-1], k = 1
// Output: [1,-1]
// Example 4:
//
// Input: nums = [9,11], k = 2
// Output: [11]
// Example 5:
//
// Input: nums = [4,-2], k = 2
// Output: [4]
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Runtime: 10 ms, faster than 97.08% of Java online submissions for Sliding Window Maximum.
// Memory Usage: 53.9 MB, less than 74.48% of Java online submissions for Sliding Window Maximum.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
            int back = nums.length - i - 1;
            rightMax[back] = back % k == 0 || i == 0 ? nums[back] : Math.max(rightMax[back + 1], nums[back]);
        }
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }
        return ans;
    }
}

//                [1,3,-1|-3,5,3|6,7] 3
// left max array [1,3,3,-3,5,5,6,7]
// right max array[3,3,-1,5,5,3,7,7]
// left: i + k - 1, right: i
//                [3,3,5,5,6,7]