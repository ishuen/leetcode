// 787. Cheapest Flights Within K Stops
// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
//
//
//
// Example 1:
//
//
// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
// Example 2:
//
//
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
// Output: 200
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
// Example 3:
//
//
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
// Output: 500
// Explanation:
// The graph is shown above.
// The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
//
//
// Constraints:
//
// 1 <= n <= 100
// 0 <= flights.length <= (n * (n - 1) / 2)
// flights[i].length == 3
// 0 <= fromi, toi < n
// fromi != toi
// 1 <= pricei <= 104
// There will not be any multiple flights between two cities.
// 0 <= src, dst, k < n
// src != dst
//
// Runtime 45 ms Beats 5.96%
// Memory 43.7 MB Beats 44.24%
class Solution {
    private Map<Integer, List<int[]>> routes;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        routes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            routes.put(i, new ArrayList<>());
        }
        for (int[] flight: flights) {
            // source: [destination, cost]
            routes.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] distanceTo = new int[n];
        Arrays.fill(distanceTo, -1);
        int[] moves = new int[n];
        Arrays.fill(moves, Integer.MAX_VALUE);
        // [curNode, cost, moves]
        PriorityQueue<int[]> paths = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        distanceTo[src] = 0;
        paths.add(new int[]{src, 0, 0});
        while (!paths.isEmpty()) {
            int[] path = paths.remove();
            if (moves[path[0]] < path[2]) continue;
            moves[path[0]] = path[2];
            for (int[] route: routes.get(path[0])) {
                int cost = path[1] + route[1];
                if (distanceTo[route[0]] == -1 || distanceTo[route[0]] > cost) {
                    distanceTo[route[0]] = cost;
                }
                if (k > path[2]) {
                    paths.add(new int[]{route[0], cost, path[2] + 1});
                }
            }
        }
        return distanceTo[dst];
    }
}