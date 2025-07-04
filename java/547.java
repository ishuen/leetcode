// 547. Number of Provinces
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//
// Return the total number of provinces.
//
//
//
// Example 1:
//
//
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
// Example 2:
//
//
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
//
//
// Constraints:
//
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]
//
// Runtime 2 ms Beats 55.40%
// Memory 43.6 MB Beats 35.71%
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == true) continue;
            visited[i] = true;
            count++;
            Queue<Integer> toCheck = new LinkedList<>();
            toCheck.add(i);
            while (!toCheck.isEmpty()) {
                int city = toCheck.remove();
                for (int j = 0; j < isConnected[city].length; j++) {
                    if (isConnected[city][j] == 1 && j != city && visited[j] == false) {
                        toCheck.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
