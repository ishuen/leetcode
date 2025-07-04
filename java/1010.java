// 1010. Pairs of Songs With Total Durations Divisible by 60
//
// You are given a list of songs where the ith song has a duration of time[i] seconds.
//
// Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
//
//
//
// Example 1:
//
// Input: time = [30,20,150,100,40]
// Output: 3
// Explanation: Three pairs have a total duration divisible by 60:
// (time[0] = 30, time[2] = 150): total duration 180
// (time[1] = 20, time[3] = 100): total duration 120
// (time[1] = 20, time[4] = 40): total duration 60
// Example 2:
//
// Input: time = [60,60,60]
// Output: 3
// Explanation: All three pairs have a total duration of 120, which is divisible by 60.
//
//
// Constraints:
//
// 1 <= time.length <= 6 * 104
// 1 <= time[i] <= 500
//
// Runtime 2 ms Beats 100%
// Memory 53.4 MB Beats 14.57%
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] counts = new long[60];
        for (int song: time) {
            int mod = song % 60;
            counts[mod]++;
        }
        long count = 0;
        for (int i = 1; i < 30; i++) {
            count = count + counts[i] * counts[60 - i];
        }
        count = count + counts[0] * (counts[0] - 1) / 2 + counts[30] * (counts[30] - 1) / 2;
        return (int)count;
    }
}