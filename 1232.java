// 1232. Check If It Is a Straight Line
//
// You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
//
//
//
//
//
// Example 1:
//
//
//
// Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
// Output: true
// Example 2:
//
//
//
// Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
// Output: false
//
//
// Constraints:
//
// 2 <= coordinates.length <= 1000
// coordinates[i].length == 2
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
// coordinates contains no duplicate point.
//
// Runtime 0 ms Beats 100%
// Memory 42.9 MB Beats 17.75%
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        int xDiff = coordinates[1][0] - coordinates[0][0];
        int yDiff = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (xDiff == 0 && coordinates[i][0] - coordinates[0][0] != 0) {
                return false;
            } else if (yDiff == 0 && coordinates[i][1] - coordinates[0][1] != 0) {
                return false;
            } else if (xDiff == 0 || yDiff == 0) {
                continue;
            } else if ((coordinates[i][0] - coordinates[0][0]) / xDiff != (coordinates[i][1] - coordinates[0][1])/ yDiff) {
                return false;
            }
        }
        return true;
    }
}