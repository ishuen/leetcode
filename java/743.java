// 743. Network Delay Time
// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
//
// We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
//
// Example 1:
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
//
// Constraints:
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
//
// Runtime: 37 ms, faster than 16.08% of Java online submissions for Network Delay Time.
// Memory Usage: 45.3 MB, less than 6.81% of Java online submissions for Network Delay Time.
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            Map<Integer, Integer> sub = map.getOrDefault(time[0], new HashMap<>());
            sub.put(time[1], time[2]);
            map.put(time[0], sub);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        pq.add(new int[]{0, k});
        
        boolean[] visited = new boolean[n];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode - 1]) continue;
            visited[curNode - 1] = true;
            res = curDist;
            n--;
            if (map.containsKey(curNode)){
                Map<Integer, Integer> sub = map.get(curNode);
                for (int next : sub.keySet()){
                    pq.add(new int[]{curDist + sub.get(next), next});
                }
            }
        }
        return n == 0 ? res : -1;
            
    }
}