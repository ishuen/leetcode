// 134. Gas Station
// There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
//
// Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
//
//
//
// Example 1:
//
// Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
// Output: 3
// Explanation:
// Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
// Travel to station 4. Your tank = 4 - 1 + 5 = 8
// Travel to station 0. Your tank = 8 - 2 + 1 = 7
// Travel to station 1. Your tank = 7 - 3 + 2 = 6
// Travel to station 2. Your tank = 6 - 4 + 3 = 5
// Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
// Therefore, return 3 as the starting index.
// Example 2:
//
// Input: gas = [2,3,4], cost = [3,4,3]
// Output: -1
// Explanation:
// You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
// Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
// Travel to station 0. Your tank = 4 - 3 + 2 = 3
// Travel to station 1. Your tank = 3 - 3 + 3 = 3
// You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
// Therefore, you can't travel around the circuit once no matter where you start.
//
//
// Constraints:
//
// gas.length == n
// cost.length == n
// 1 <= n <= 104
// 0 <= gas[i], cost[i] <= 104

// Runtime: 104 ms, faster than 10.19% of Java online submissions for Gas Station.
// Memory Usage: 39.3 MB, less than 48.94% of Java online submissions for Gas Station.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int init = 0;
        int size = gas.length;
        boolean achieved = true;
        while (init < size) {
            if (gas[init] < cost[init]) {
                init++;
                continue;
            }
            int tank = gas[init];
            for (int i = 1; i <= size; i++) {
                tank = tank - cost[(init + i - 1) % size];
                if (tank < 0) break;
                tank = tank + gas[(init + i) % size];
            }
            if (tank >= 0) {
                return init;
            }
            init++;
        }
        return -1;
    }
}

// + gas[i] (- cost[i] + gas[i + 1]) .. (- cost[i - 1]) go back to gas[i]
// gas[i] > cost[i], initial condition

// Runtime: 57 ms, faster than 15.63% of Java online submissions for Gas Station.
// Memory Usage: 39.4 MB, less than 38.10% of Java online submissions for Gas Station.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int init = 0;
        int size = gas.length;
        boolean achieved = true;
        int[] net = new int[size];
        for (int i = 0; i < size; i++) {
            net[i] = gas[i] - cost[i];
        }
        while (init < size) {
            if (net[init] < 0) {
                init++;
                continue;
            }
            int tank = net[init];
            for (int i = 1; i <= size; i++) {
                tank = tank + net[(init + i) % size];
                if (tank < 0) break;
            }
            if (tank >= 0) {
                return init;
            }
            init++;
        }
        return -1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
// Memory Usage: 39.1 MB, less than 60.78% of Java online submissions for Gas Station.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank >= 0) {
                tank = tank + gas[end] - cost[end];
                end++;
            } else {
             start--;
             tank = tank + gas[start] - cost[start];
            }
       }
       return tank >= 0 ? start : -1;
    }
}