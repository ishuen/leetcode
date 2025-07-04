// 1319. Number of Operations to Make Network Connected
//
// There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
//
// You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
//
// Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
//
//
//
// Example 1:
//
//
// Input: n = 4, connections = [[0,1],[0,2],[1,2]]
// Output: 1
// Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
// Example 2:
//
//
// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
// Output: 2
// Example 3:
//
// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
// Output: -1
// Explanation: There are not enough cables.
//
//
// Constraints:
//
// 1 <= n <= 105
// 1 <= connections.length <= min(n * (n - 1) / 2, 105)
// connections[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// There are no repeated connections.
// No two computers are connected by more than one cable.
//
// Runtime 12 ms Beats 57.29% of users with Java
// Memory 64.33 MB Beats 85.51% of users with Java
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1) return -1;
        List<Integer>[] relations = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            relations[i] = new ArrayList<>();
        }
        for (int[] connection: connections) {
            relations[connection[0]].add(connection[1]);
            relations[connection[1]].add(connection[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                queue.add(i);
                while(!queue.isEmpty()) {
                    int cur = queue.remove();
                    if (visited[cur]) continue;
                    visited[cur] = true;
                    List<Integer> nextList = relations[cur];
                    for (int next: nextList) {
                        if (visited[next] == false)
                        queue.add(next);  
                    }
                }
                count++;
            }
        }
        return count - 1;
    }
}