// 1743. Restore the Array From Adjacent Pairs
//
// There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
//
// You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
//
// It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
//
// Return the original array nums. If there are multiple solutions, return any of them.
//
//
//
// Example 1:
//
// Input: adjacentPairs = [[2,1],[3,4],[3,2]]
// Output: [1,2,3,4]
// Explanation: This array has all its adjacent pairs in adjacentPairs.
// Notice that adjacentPairs[i] may not be in left-to-right order.
// Example 2:
//
// Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
// Output: [-2,4,1,-3]
// Explanation: There can be negative numbers.
// Another solution is [-3,1,4,-2], which would also be accepted.
// Example 3:
//
// Input: adjacentPairs = [[100000,-100000]]
// Output: [100000,-100000]
//
//
// Constraints:
//
// nums.length == n
// adjacentPairs.length == n - 1
// adjacentPairs[i].length == 2
// 2 <= n <= 105
// -105 <= nums[i], ui, vi <= 105
// There exists some nums that has adjacentPairs as its pairs.
//
// Runtime 77ms Beats 86.89%of users with Java
// Memory 80.45MB Beats 97.13%of users with Java
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            Integer[] pair1 = map.getOrDefault(adjacentPairs[i][0], new Integer[]{adjacentPairs[i][1], Integer.MIN_VALUE});
            if (pair1[0] != adjacentPairs[i][1]) {
                pair1[1] = adjacentPairs[i][1];
            }
            map.put(adjacentPairs[i][0], pair1);

             Integer[] pair2 = map.getOrDefault(adjacentPairs[i][1], new Integer[]{adjacentPairs[i][0], Integer.MIN_VALUE});
            if (pair2[0] != adjacentPairs[i][0]) {
                pair2[1] = adjacentPairs[i][0];
            }
            map.put(adjacentPairs[i][1], pair2);
        }

        int start = 0;
        for (Map.Entry<Integer, Integer[]> entry: map.entrySet()) {
            if (entry.getValue()[1] == Integer.MIN_VALUE) {
                start = entry.getKey();
                break;
            }
        }

        int[] output = new int[adjacentPairs.length + 1];
        output[0] = start;
        int prev = Integer.MIN_VALUE;
        for (int i = 1; i < output.length; i++) {
            Integer[] connected = map.get(start);
            if (connected[0] != prev) {
                output[i] = connected[0];
            } else {
                output[i] = connected[1];
            }
            prev = start;
            start = output[i];
        }
        return output;
    }
}