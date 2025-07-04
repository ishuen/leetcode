// 826. Most Profit Assigning Work
// You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
//
// difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
// worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
// Every worker can be assigned at most one job, but one job can be completed multiple times.
//
// For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
// Return the maximum profit we can achieve after assigning the workers to the jobs.
//
//
//
// Example 1:
//
// Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
// Output: 100
// Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
// Example 2:
//
// Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
// Output: 0
//
//
// Constraints:
//
// n == difficulty.length
// n == profit.length
// m == worker.length
// 1 <= n, m <= 104
// 1 <= difficulty[i], profit[i], worker[i] <= 105
//
// Runtime 1342 ms Beats 5.6%
// Memory 44.1 MB Beats 54.40%
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        for (int w: worker) {
            int max = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (w < difficulty[i]) continue;
                if (profit[i] > max) {
                    max = profit[i];
                }
            }
            sum = sum + max;
        }
        return sum;
    }
}

// Runtime 1299 ms Beats 5.6%
// Memory 44.2 MB Beats 48.80%
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> workerAbilities = new HashMap<>();
        for (int w: worker) {
            workerAbilities.put(w, workerAbilities.getOrDefault(w, 0) + 1);
        }
        int sum = 0;
        for (int w: workerAbilities.keySet()) {
            int max = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (w < difficulty[i]) continue;
                if (profit[i] > max) {
                    max = profit[i];
                }
            }
            sum = sum + max * workerAbilities.get(w);
        }
        return sum;
    }
}

// Runtime 37 ms Beats 32.27%
// Memory 45.2 MB Beats 19.73%
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        Map<Integer, Integer> diffToProfit = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            diffToProfit.put(difficulty[i], Math.max(profit[i], diffToProfit.getOrDefault(difficulty[i], 0)));
        } 
        int sum = 0;
        List<Integer> diffs = new ArrayList<>(diffToProfit.keySet());
        Collections.sort(diffs);
        int index = 0;
        int max = 0;
        for (int w: worker) {
            while (index < diffs.size() && w >= diffs.get(index)) {
                max = Math.max(max, diffToProfit.get(diffs.get(index)));
                // System.out.println(max + " " + w + " " + index);
                index++;
            }
            sum = sum + max;
        }
        return sum;
    }
}