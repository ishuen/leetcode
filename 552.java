// 552. Student Attendance Record II
// An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
//
// 'A': Absent.
// 'L': Late.
// 'P': Present.
// Any student is eligible for an attendance award if they meet both of the following criteria:
//
// The student was absent ('A') for strictly fewer than 2 days total.
// The student was never late ('L') for 3 or more consecutive days.
// Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: n = 2
// Output: 8
// Explanation: There are 8 records with length 2 that are eligible for an award:
// "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
// Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
// Example 2:
//
// Input: n = 1
// Output: 3
// Example 3:
//
// Input: n = 10101
// Output: 183236316
//
//
// Constraints:
//
// 1 <= n <= 105
//
// Runtime: 58 ms, faster than 80.64% of Java online submissions for Student Attendance Record II.
// Memory Usage: 40.8 MB, less than 67.23% of Java online submissions for Student Attendance Record II.
class Solution {
    public int checkRecord(int n) {
        int m = 1000000007;
        int[] p = new int[n];
        int[] a = new int[n];
        int[] l = new int[n];
        p[0] = 1;
        a[0] = 1;
        l[0] = 1;
        if (n >= 2) {
            a[1] = 2;
            l[1] = 3;
        }
        if (n >= 3) a[2] = 4; // PL, LP, PP, LL
        for (int i = 1; i < n; i++) {
            a[i - 1] = a[i - 1] % m;
            l[i - 1] = l[i - 1] % m;
            p[i - 1] = p[i - 1] % m;
            p[i] = (((a[i - 1] + l[i - 1]) % m) + p[i - 1]) % m;
            if (i >= 2) l[i] = ((a[i - 1] + p[i - 1]) % m + (a[i - 2] + p[i - 2]) % m) % m; 
            if (i >= 3) a[i] = ((a[i - 1] + a[i - 2]) % m + a [i - 3]) % m;
        }
        return (((p[n - 1] % m) + (a[n - 1] % m)) % m + (l[n - 1] % m)) % m;
    }
}

// count of A < 2
// count of L <= 3 cont.

// permutation = ending in A + ending in P + ending in L
// A[n - 1] + P[n - 1] + L[n - 1]

// P[n] = A[n - 1] + L[n - 1] + P[n - 1]
// L[n] = A[n - 1] + P[n - 1] + A[n - 2] + P[n - 2] 
// A[n] = noA[n - 1] = noAP[n - 1] + noAL[n - 1]
//      noAP[n - 1] = noAP[n - 2] + noAL[n - 2]
//      noAL[n - 1] = noAP[n - 2] + noAP[n - 3]
// A[n] = noA[n - 1] = noAP[n - 2] + noAL[n - 2] + noAP[n - 2] + noAP[n - 3]
// = A[n - 1] + noAP[n - 2] + noAP[n - 3] = A[n - 1] + A[n - 2] + A[n - 3]