// 886. Possible Bipartition
//
// We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
//
// Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
//
//
//
// Example 1:
//
// Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
// Output: true
// Explanation: The first group has [1,4], and the second group has [2,3].
// Example 2:
//
// Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
// Output: false
// Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
//
//
// Constraints:
//
// 1 <= n <= 2000
// 0 <= dislikes.length <= 104
// dislikes[i].length == 2
// 1 <= ai < bi <= n
// All the pairs of dislikes are unique.
//
// Runtime 39 ms Beats 24.59%
// Memory 53.4 MB Beats 6.9%
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike: dislikes) {
            List<Integer> list1 = map.getOrDefault(dislike[0], new ArrayList<>());
            list1.add(dislike[1]);
            map.put(dislike[0], list1);
            List<Integer> list2 = map.getOrDefault(dislike[1], new ArrayList<>());
            list2.add(dislike[0]);
            map.put(dislike[1], list2);
        }
        int[] groups = new int[n + 1];
        for (int node : map.keySet()) {
            if (groups[node] == 0 && !canFit(node, groups, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFit(int node, int[] groups, Map<Integer, List<Integer>> map) {
        if (groups[node] == 0) {
            groups[node] = 1;
        }
        for (int destination: map.get(node)) {
            if (groups[destination] == groups[node]) return false;
            if (groups[destination] == 0) {
                groups[destination] = -1 * groups[node];
                if(!canFit(destination, groups, map)) return false;
            }
        }
        return true;
    }
}
