// 441. Arranging Coins
// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
// Given n, find the total number of full staircase rows that can be formed.
//
// n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
// Example 1:
// n = 5
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤
// Because the 3rd row is incomplete, we return 2.
//
// Example 2:
// n = 8
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
// Because the 4th row is incomplete, we return 3.

// 36 ms
class Solution {
public:
    int arrangeCoins(int n) {
        int iter = n / 2 + 1;
        for (int i = 1; i <= iter; i++) {
            if ((i+2) * (i+1) > 2 * n && 2 * n >= (i+1) * i) return i;

        }
        return n;
    }
};

// 32 ms
class Solution {
public:
    int arrangeCoins(int n) {
        int iter = n / 2 + 1;
        for (int i = 1; i <= iter; i++) {
            n = n - i;
            if (n == 0) return i;
            else if (n < 0) return i-1;
        }
        return iter;
    }
};

// 28 ms, faster than 46.07%
class Solution {
public:
    int arrangeCoins(int n) {
        return int(sqrt(2*double(n) + 0.25) - 0.5);
    }
};