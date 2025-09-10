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

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

// Runtime 0 ms Beats 100.00%
// Memory 7.84 MB Beats 80.74%
func trap(height []int) int {
    minHeight := 0
    left := 0
    for ; left < len(height) && height[left] == 0; {
        left++
    }
    right := len(height) - 1
    for ; right >= 0 && height[right] == 0; {
        right--
    }
    total := 0
    for ; left < right; {
        if height[left] < height[right] {
            minHeight = height[left]
            left++
            for ; height[left] < minHeight; left++ {
                total = total + minHeight - height[left]
            }
        } else {
            minHeight = height[right]
            right--
            for ; height[right] < minHeight; right-- {
                total = total + minHeight - height[right]
            }
        }
    }
    return total
}
