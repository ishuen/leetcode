// 1584. Min Cost to Connect All Points
// You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
//
// Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
//
//
//
// Example 1:
//
//
//
// Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
// Output: 20
// Explanation:
//
// We can connect the points as shown above to get the minimum cost of 20.
// Notice that there is a unique path between every pair of points.
// Example 2:
//
// Input: points = [[3,12],[-2,5],[-4,1]]
// Output: 18
// Example 3:
//
// Input: points = [[0,0],[1,1],[1,0],[-1,1]]
// Output: 4
// Example 4:
//
// Input: points = [[-1000000,-1000000],[1000000,1000000]]
// Output: 4000000
// Example 5:
//
// Input: points = [[0,0]]
// Output: 0
//
//
// Constraints:
//
// 1 <= points.length <= 1000
// -106 <= xi, yi <= 106
// All pairs (xi, yi) are distinct.
//
// Runtime: 297 ms, faster than 46.69% of Java online submissions for Min Cost to Connect All Points.
// Memory Usage: 51.6 MB, less than 90.29% of Java online submissions for Min Cost to Connect All Points.
class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) return 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] base = points[0];
        int total = 0;
        for (int i = 1; i < points.length; i++) {
            int cost = (int) (Math.abs(points[i][0] - base[0]) + Math.abs(points[i][1] - base[1]));
            Point point = new Point(points[i], cost);
            pq.add(point);
        }
        while (!pq.isEmpty()) {
            Point closest = pq.remove();
            total += closest.cost;
            PriorityQueue<Point> temp = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            while(!pq.isEmpty()) {
                Point des = pq.remove();
                int cost = (int) (Math.abs(des.loc[0] - closest.loc[0]) + Math.abs(des.loc[1] - closest.loc[1]));
                des.cost = Math.min(des.cost, cost);
                temp.add(des);
            }
            pq = temp;
        }
        return total;
    }
    
    class Point {
        int[] loc;
        int cost;
        public Point(int[] loc, int cost) {
            this.loc = loc;
            this.cost = cost;
        }
    }
}