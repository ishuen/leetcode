// 365. Water and Jug Problem
// You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
//
// If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.
//
// Operations allowed:
//
// Fill any of the jugs with water.
// Empty any of the jugs.
// Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
//
//
// Example 1:
//
// Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
// Output: true
// Explanation: The famous Die Hard example
// Example 2:
//
// Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
// Output: false
// Example 3:
//
// Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
// Output: true
//
//
// Constraints:
//
// 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106
//
// Runtime: 2 ms, faster than 51.37% of Java online submissions for Water and Jug Problem.
// Memory Usage: 37.6 MB, less than 55.60% of Java online submissions for Water and Jug Problem.
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        int gcd = gcd(jug1Capacity, jug2Capacity);
        if (targetCapacity % gcd == 0) return true;
        return false;
    }
    private int gcd (int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Water and Jug Problem.
// Memory Usage: 37.7 MB, less than 54.65% of Java online submissions for Water and Jug Problem.
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        int gcd = gcd(jug1Capacity, jug2Capacity);
        if (targetCapacity % gcd == 0) return true;
        return false;
    }
    private int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}