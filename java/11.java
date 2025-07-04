// 11. Container With Most Water
//     Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//     Note: You may not slant the container and n is at least 2.
//
// Example:
//     Input: [1,8,6,2,5,4,8,3,7]
//     Output: 49

// Runtime: 425 ms, faster than 8.33% of Java online submissions for Container With Most Water.
// Memory Usage: 39.9 MB, less than 94.87% of Java online submissions for Container With Most Water.

class Solution {
    public int maxArea(int[] height) {
        int x1 = 0;
        int x2 = 1;
        int cur = 0;
        int max = 0;
        int fin = height.length;
        while (x2 < fin) {
            cur = (x2 - x1) * Math.min(height[x1], height[x2]);
            if (cur > max) {
                max = cur;
            }
            if (x2 == fin - 1) {
                x1 = x1 + 1;
                x2 = x1 + 1;
            } else {
                x2 = x2 + 1;
            }
        }
        return max;
    }
}


// Runtime: 1 ms, faster than 100.00% of Java online submissions for Container With Most Water.
// Memory Usage: 40 MB, less than 94.87% of Java online submissions for Container With Most Water.
class Solution {
   public int maxArea(int[] height) {
        int x1 = 0;
        int x2 = height.length - 1;
        int max = 0;
        while (x2 != x1) {
            if (height[x1] > height[x2]) {
                max = Math.max((x2 - x1) * height[x2], max);
                x2--;
            } else {
                max = Math.max((x2 - x1) * height[x1], max);
                x1++;
            }
        }
        
        return max;
    }
}