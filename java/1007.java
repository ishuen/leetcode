// 1007. Minimum Domino Rotations For Equal Row
//
// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
//
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
//
// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
//
// If it cannot be done, return -1.
//
//
//
// Example 1:
//
//
// Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// Output: 2
// Explanation:
// The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
// If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
// Example 2:
//
// Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
// Output: -1
// Explanation:
// In this case, it is not possible to rotate the dominoes to make one row of values equal.
//
//
// Constraints:
//
// 2 <= tops.length <= 2 * 104
// bottoms.length == tops.length
// 1 <= tops[i], bottoms[i] <= 6
//
// Runtime 9 ms Beats 22.53%
// Memory 49.4 MB Beats 70.31%
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int majority = tops[0];
        int count = 1;
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = tops[i];
                    count = 1;
                }
            }
        }
        count = 0;
        boolean canFit = true;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != majority) {
                if (bottoms[i] == majority) {
                    count++;
                } else {
                    canFit = false;
                    break;
                }
            }
        }
        int topCount = Integer.MAX_VALUE;
        if (canFit == true) topCount = count;
        majority = bottoms[0];
        count = 1;
        for (int i = 1; i < bottoms.length; i++) {
            if (bottoms[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = bottoms[i];
                    count = 1;
                }
            }
        }
        canFit = true;
        count = 0;
        for (int i = 0; i < bottoms.length; i++) {
            if (bottoms[i] != majority) {
                if (tops[i] == majority) {
                    count++;
                } else {
                    canFit = false;
                    break;
                }
            }
        }
        if (canFit == true) return Math.min(topCount, count);
        return topCount == Integer.MAX_VALUE ? -1 : topCount;
    }
}

// Runtime 5 ms Beats 61.77%
// Memory 49.5 MB Beats 66.55%
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < tops.length; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == tops.length) {
                min = Math.min(tops.length - Math.max(countA[i], countB[i]), min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}