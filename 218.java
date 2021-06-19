// 218. The Skyline Problem
// A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
//
// The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
//
// lefti is the x coordinate of the left edge of the ith building.
// righti is the x coordinate of the right edge of the ith building.
// heighti is the height of the ith building.
// You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
//
// The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
//
// Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
//
//
//
// Example 1:
//
//
// Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
// Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
// Explanation:
// Figure A shows the buildings of the input.
// Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
// Example 2:
//
// Input: buildings = [[0,2,3],[2,5,3]]
// Output: [[0,3],[5,0]]
//
//
// Constraints:
//
// 1 <= buildings.length <= 104
// 0 <= lefti < righti <= 231 - 1
// 1 <= heighti <= 231 - 1
// buildings is sorted by lefti in non-decreasing order.
//
// Runtime: 16 ms, faster than 78.21% of Java online submissions for The Skyline Problem.
// Memory Usage: 44.3 MB, less than 15.41% of Java online submissions for The Skyline Problem.
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> changingPoints = new ArrayList<>();
        for (int[] building: buildings) {
            List<Integer> start = Arrays.asList(new Integer[]{building[0], -building[2]});
            List<Integer> end = Arrays.asList(new Integer[]{building[1], building[2]});
            changingPoints.add(start);
            changingPoints.add(end);
        }
        Collections.sort(changingPoints, (a, b) -> {
            if (a.get(0) == b.get(0)) return a.get(1) - b.get(1);
            else return a.get(0) - b.get(0);
        });
        PriorityQueue<Integer> maxHeights = new PriorityQueue<>((a, b) -> b - a);
        maxHeights.add(0);
        int prev = 0;
        for (int i = 0; i < changingPoints.size(); i++) {
            List<Integer> point = changingPoints.get(i);
            if (point.get(1) < 0) {
                maxHeights.add(-1 * point.get(1));
            } else {
                maxHeights.remove(point.get(1));
                if (i < changingPoints.size() - 1 && point.get(0).equals(changingPoints.get(i + 1).get(0))) {
                    continue;
                }
            }
            int cur = maxHeights.peek();
            if (cur != prev) {
                ans.add(Arrays.asList(new Integer[]{point.get(0), cur}));
                prev = cur;
            }
        }
        return ans;
    }
} 

