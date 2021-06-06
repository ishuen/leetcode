// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9
// Constraints:
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.3 MB, less than 83.32% of Java online submissions for Trapping Rain Water.
class Solution {
    public int trap(int[] height) {
        int count = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[left + 1]) left++;
            else {
                break;
            }
        }
        while (left < right) {
            if (height[right] < height[right - 1]) right--;
            else {
                break;
            }
        }
        while (left < right) {
            if (height[left] <= height[right]) {
                int l = left + 1;
                while (height[l] < height[left]) {
                    count = count + height[left] - height[l];
                    l++;
                }
                left = l;
            } else {
                int r = right - 1;
                while (height[right] > height[r]) {
                    count = count + height[right] - height[r];
                    r--;
                }
                right = r;
            }
        }
        return count;
    }
}

