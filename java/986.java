// 986. Interval List Intersections
//
// You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
//
// Return the intersection of these two interval lists.
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
//
// The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
//
//
//
// Example 1:
//
//
// Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// Example 2:
//
// Input: firstList = [[1,3],[5,9]], secondList = []
// Output: []
//
//
// Constraints:
//
// 0 <= firstList.length, secondList.length <= 1000
// firstList.length + secondList.length >= 1
// 0 <= starti < endi <= 109
// endi < starti+1
// 0 <= startj < endj <= 109
// endj < startj+1
//
// Runtime 3 ms Beats 96.1%
// Memory 45.1 MB Beats 7.25%
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < firstList.length && index2 < secondList.length) {
            if (firstList[index1][0] > secondList[index2][1]) {
                index2++;
                continue;
            }
            if (secondList[index2][0] > firstList[index1][1]) {
                index1++;
                continue;
            }
            int maxStart = Math.max(firstList[index1][0], secondList[index2][0]);
            int minEnd = Math.min(firstList[index1][1], secondList[index2][1]);
            list.add(new int[]{maxStart, minEnd});
            if (minEnd == firstList[index1][1]) {
                index1++;
            } else {
                index2++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}