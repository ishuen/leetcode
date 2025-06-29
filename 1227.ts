// 1227. Airplane Seat Assignment Probability
//
// n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of the passengers will:
//
// Take their own seat if it is still available, and
// Pick other seats randomly when they find their seat occupied
// Return the probability that the nth person gets his own seat.
//
//
//
// Example 1:
//
// Input: n = 1
// Output: 1.00000
// Explanation: The first person can only get the first seat.
// Example 2:
//
// Input: n = 2
// Output: 0.50000
// Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).
//
//
// Constraints:
//
// 1 <= n <= 105
//
// Runtime 0 ms Beats 100.00%
// Memory 55.11 MB Beats 83.33%
function nthPersonGetsNthSeat(n: number): number {
    return n == 1 ? 1 : 0.5
};
/*
In the seated group, there is always someone sits on another person's seat except for 1 person. This indicates a cancellation effect. So at the end, it's a problem to select a seat from 2, 1 correct and 1 wrong.
*/