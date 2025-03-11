// 3208. Alternating Groups II
//
// There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
//
// colors[i] == 0 means that tile i is red.
// colors[i] == 1 means that tile i is blue.
// An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
//
// Return the number of alternating groups.
//
// Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
//
//
// Example 1:
//
// Input: colors = [0,1,0,1,0], k = 3
//
// Output: 3
//
// Example 2:
//
// Input: colors = [0,1,0,0,1,0,1], k = 6
//
// Output: 2
//
//
// Example 3:
//
// Input: colors = [1,1,0,1], k = 4
//
// Output: 0
//
// Constraints:
//
// 3 <= colors.length <= 105
// 0 <= colors[i] <= 1
// 3 <= k <= colors.length
//
// Runtime 2 ms Beats 98.04%
// Memory 56.54 MB Beats 90.22%
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] full = new int[colors.length + k - 1];
		System.arraycopy(colors, 0, full, 0, colors.length);
		System.arraycopy(colors, 0, full, colors.length, k - 1); 

        int count = 0;
        int left = 0;
        int last = full[0] - 1;
        for (int right = 0; right < full.length; right++) {
            if (full[right] == last) {
                left = right;
                continue;
            }
            if (right - left + 1 == k) {
                count++;
                left++;
            }
            last = full[right];
        }
        return count;
    }
}
