// 399. Evaluate Division
// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
//
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.
//
// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
//
//
//
// Example 1:
//
// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// Explanation:
// Given: a / b = 2.0, b / c = 3.0
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// Example 2:
//
// Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: [3.75000,0.40000,5.00000,0.20000]
// Example 3:
//
// Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
// Output: [0.50000,2.00000,-1.00000,-1.00000]
//
//
// Constraints:
//
// 1 <= equations.length <= 20
// equations[i].length == 2
// 1 <= Ai.length, Bi.length <= 5
// values.length == equations.length
// 0.0 < values[i] <= 20.0
// 1 <= queries.length <= 20
// queries[i].length == 2
// 1 <= Cj.length, Dj.length <= 5
// Ai, Bi, Cj, Dj consist of lower case English letters and digits.
//
// Runtime 1 ms Beats 90.73%
// Memory 41.5 MB Beats 18.88%
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            Map<String, Double> node = graph.getOrDefault(eq.get(0), new HashMap<>());
            node.put(eq.get(1), values[i]);
            graph.put(eq.get(0), node);
            Map<String, Double> nodeReversed = graph.getOrDefault(eq.get(1), new HashMap<>());
            nodeReversed.put(eq.get(0), 1 / values[i]);
            graph.put(eq.get(1), nodeReversed);
        }
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = calculate(graph, queries.get(i));
        }
        return ans;
    }

    private double calculate(Map<String, Map<String, Double>> graph, List<String> query) {
        if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))) return -1.0;
        if (query.get(0).equals(query.get(1))) return 1;
        Map<String, Double> candidates = graph.get(query.get(0));
        Double value = candidates.get(query.get(1));
        if (value != null) return value;
        
        Set<String> visited = new HashSet<>();
        Stack<Pair<String, Double>> stack = new Stack<>();
        stack.push(new Pair<>(query.get(0), 1.0));
        while (!stack.isEmpty()) {
            Pair<String, Double> cur = stack.pop();
            candidates = graph.get(cur.getKey());
            for (String dest: candidates.keySet()) {
                if (dest.equals(query.get(1))) {
                    return cur.getValue() * candidates.get(dest);
                } else if (!visited.contains(dest)) {
                    visited.add(dest);
                    stack.push(new Pair<>(dest, cur.getValue() * candidates.get(dest)));
                }
            }
        }
        return -1.0;
    }
}