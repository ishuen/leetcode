// 818. Race Car
// Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):
//
// When you get an instruction 'A', your car does the following:
// position += speed
// speed *= 2
// When you get an instruction 'R', your car does the following:
// If your speed is positive then speed = -1
// otherwise speed = 1
// Your position stays the same.
// For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.
//
// Given a target position target, return the length of the shortest sequence of instructions to get there.
//
//
//
// Example 1:
//
// Input: target = 3
// Output: 2
// Explanation:
// The shortest instruction sequence is "AA".
// Your position goes from 0 --> 1 --> 3.
// Example 2:
//
// Input: target = 6
// Output: 5
// Explanation:
// The shortest instruction sequence is "AAARA".
// Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.
//
//
// Constraints:
//
// 1 <= target <= 104
//
// Runtime: 12 ms, faster than 60.10% of Java online submissions for Race Car.
// Memory Usage: 37.1 MB, less than 83.89% of Java online submissions for Race Car.
class Solution {
    public int racecar(int target) {
        int[] steps = new int[target + 1];
        Arrays.fill(steps, 1, target + 1, -1);
        return racecar(target, steps);
    }

    private int racecar(int target, int[] steps) {
        if (steps[target] >= 0) return steps[target];
        steps[target] = Integer.MAX_VALUE;
        int aCount = 1;
        int position = 1;
        while (position < target) {
            int a = 0; // back accelerate count
            int p = 0; // back position
            while (p < position) {
                steps[target] = Math.min(steps[target],  aCount + 1 + a + 1 + racecar(target - (position - p), steps));
                a++;
                p = (1 << a) - 1; // back position = 2 ^ a - 1
            }
            aCount++;
            position = (1 << aCount) - 1; // position = 2 ^ aCount - 1
        }
    
        steps[target] = Math.min(steps[target], aCount + (target == position ? 0 : 1 + racecar(position - target, steps)));
    
        return steps[target];
    }
}

// target > 0
// target = A * l (+ R) - A' * m + (+R) + A'' * n