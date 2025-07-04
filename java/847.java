// 847. Shortest Path Visiting All Nodes
// You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
//
// Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
//
//
//
// Example 1:
//
//
// Input: graph = [[1,2,3],[0],[0],[0]]
// Output: 4
// Explanation: One possible path is [1,0,2,0,3]
// Example 2:
//
//
// Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
// Output: 4
// Explanation: One possible path is [0,1,4,2,3]
//
//
// Constraints:
//
// n == graph.length
// 1 <= n <= 12
// 0 <= graph[i].length < n
// graph[i] does not contain i.
// If graph[a] contains b, then graph[b] contains a.
// The input graph is always connected.
//
// Runtime 12 ms Beats 40.93%
// Memory 43.3 MB Beats 33.24%
class Solution {
    public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] matrix = new int[(int)Math.pow(2, graph.length)][graph.length];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < graph.length; i++) {
            int set = binaryToInt(0, i);
            queue.add(new int[]{set, i});
            matrix[set][i] = 0;
        }
        while(!queue.isEmpty()) {
            int[] current = queue.remove();
            if (current[0] == matrix.length - 1) return matrix[current[0]][current[1]];
            for (int next: graph[current[1]]) {
                int nextSet = binaryToInt(current[0], next);
                if (matrix[nextSet][next] != -1) {
                    continue;
                }
                matrix[nextSet][next] = matrix[current[0]][current[1]] + 1;
                queue.add(new int[]{nextSet, next});
            }
        }
        return 9999;
    }

    private int binaryToInt(int number, int index) {
        return number | 1 << index;
    }
}