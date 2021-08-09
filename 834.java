// 834. Sum of Distances in Tree
// There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
//
// You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//
// Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
//
//
//
// Example 1:
//
//
// Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
// Output: [8,12,6,10,10,10]
// Explanation: The tree is shown above.
// We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
// equals 1 + 1 + 2 + 2 + 2 = 8.
// Hence, answer[0] = 8, and so on.
// Example 2:
//
//
// Input: n = 1, edges = []
// Output: [0]
// Example 3:
//
//
// Input: n = 2, edges = [[1,0]]
// Output: [1,1]
//
//
// Constraints:
//
// 1 <= n <= 3 * 104
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// The given input represents a valid tree.
//
// Runtime: 137 ms, faster than 5.13% of Java online submissions for Sum of Distances in Tree.
// Memory Usage: 187.4 MB, less than 5.14% of Java online submissions for Sum of Distances in Tree.
class Solution {
    int[] dist;
    int[] counts;
    Map<Integer, Set<Integer>> nodes;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[]{0};
        dist = new int[n];
        counts = new int[n];
        nodes = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> set1 = nodes.getOrDefault(edges[i][0], new HashSet<>());
            set1.add(edges[i][1]);
            nodes.put(edges[i][0], set1);
            Set<Integer> set2 = nodes.getOrDefault(edges[i][1], new HashSet<>());
            set2.add(edges[i][0]);
            nodes.put(edges[i][1], set2);
        }
        traverseDown(0, -1);
        traverseUp(0, -1);
        return dist;
    }
    
    private void traverseDown(int root, int last) {
        for(int child: nodes.get(root)) {
            if (child == last) continue;
            traverseDown(child, root);
            counts[root] = counts[root] + counts[child];
            dist[root] = dist[root] + dist[child] + counts[child];
            // dist[child]: total distance from child node
            // counts[child]: number of node needs to pass from edges[root][child]
        }
        counts[root]++;
    }
    private void traverseUp(int root, int last) {
        for (int child : nodes.get(root)) {
            if (child == last) continue;
            dist[child] = dist[root] + counts.length - 2 * counts[child];
            // dist[child] = (dist[root] - counts[child]) + (counts.length - counts[child]);
            // dist[root] - counts[child]: total distance from root - number of nodes needs to pass from edge[root][child] due to the subtree of child node
            // counts.length - counts[child]: additional change to the number of visit at edge[root][child]
            traverseUp(child, root);
        }
    }
}