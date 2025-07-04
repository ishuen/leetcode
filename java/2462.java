// 2462. Total Cost to Hire K Workers
//
// You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
//
// You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
//
// You will run k sessions and hire exactly one worker in each session.
// In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
// For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
// In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
// If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
// A worker can only be chosen once.
// Return the total cost to hire exactly k workers.
//
//
//
// Example 1:
//
// Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
// Output: 11
// Explanation: We hire 3 workers in total. The total cost is initially 0.
// - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
// - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
// - In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
// The total hiring cost is 11.
// Example 2:
//
// Input: costs = [1,2,4,1], k = 3, candidates = 3
// Output: 4
// Explanation: We hire 3 workers in total. The total cost is initially 0.
// - In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
// - In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
// - In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
// The total hiring cost is 4.
//
//
// Constraints:
//
// 1 <= costs.length <= 105
// 1 <= costs[i] <= 105
// 1 <= k, candidates <= costs.length
//
// Runtime 99 ms Beats 7.96% of users with Java
// Memory 57.72 MB Beats 54.45% of users with Java
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total = 0;
        boolean[] selected = new boolean[costs.length];
        int nextHeadIndex = 0;
        int nextTailIndex = costs.length - 1;
        Comparator<Info> comparator = (a, b) -> {
            if (a.cost == b.cost) return a.index - b.index;
            return a.cost - b.cost;
        };
        PriorityQueue<Info> headQueue = new PriorityQueue<>( comparator);
        PriorityQueue<Info> tailQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < candidates; i++) {
            headQueue.add(new Info(costs[nextHeadIndex], nextHeadIndex));
            nextHeadIndex++;
        }
        for (int i = 0; i < candidates; i++) {
            tailQueue.add(new Info(costs[nextTailIndex], nextTailIndex));
            nextTailIndex--;
        }
        int count = 0;
        while (count < k) {
            Info h = headQueue.peek();
            Info t = tailQueue.peek();
            if ((h != null && t == null) || (h != null && t != null && h.cost <= t.cost)) {
                if (selected[h.index] == true) {
                    headQueue.remove();
                    continue;
                }
                total = total + h.cost;
                headQueue.remove();
                selected[h.index] = true;
                while (nextHeadIndex < selected.length && selected[nextHeadIndex] == true) {
                    nextHeadIndex++;
                }
                if (nextHeadIndex < selected.length) {
                    headQueue.add(new Info(costs[nextHeadIndex], nextHeadIndex));
                    nextHeadIndex++;
                } 
            } else if ((h == null && t != null) || (h != null && t != null && h.cost > t.cost)) {
                if (selected[t.index] == true) {
                    tailQueue.remove();
                    continue;
                }
                total = total + t.cost;
                tailQueue.remove();
                selected[t.index] = true;
                while (nextTailIndex >= 0 && selected[nextTailIndex] == true) {
                    nextTailIndex--;
                }
                if (nextTailIndex >= 0) {
                    tailQueue.add(new Info(costs[nextTailIndex], nextTailIndex));
                    nextTailIndex--;
                }
            }
            count++;
        }
        return total;
    }

    class Info {
        int cost;
        int index;
        public Info(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}


// Runtime 51 ms Beats 28.03% of users with Java
// Memory 60.64 MB Beats 6.44% of users with Java
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total = 0;
        int nextHeadIndex = 0;
        int nextTailIndex = costs.length - 1;
        PriorityQueue<Integer> headQueue = new PriorityQueue<>();
        PriorityQueue<Integer> tailQueue = new PriorityQueue<>();
        int count = 0;
        while (count < k) {
            while (headQueue.size() < candidates && nextHeadIndex <= nextTailIndex) {
                headQueue.add(costs[nextHeadIndex]);
                nextHeadIndex++;  
            }
            while (tailQueue.size() < candidates && nextHeadIndex <= nextTailIndex) {
                tailQueue.add(costs[nextTailIndex]);
                nextTailIndex--;
            }
            Integer h = headQueue.isEmpty() ? Integer.MAX_VALUE : headQueue.peek();
            Integer t = tailQueue.isEmpty() ? Integer.MAX_VALUE: tailQueue.peek();
            if (h <= t) {
                total = total + h;
                headQueue.remove();
            } else {
                total = total + t;
                tailQueue.remove();
            }
            count++;
        }
        return total;
    }
}