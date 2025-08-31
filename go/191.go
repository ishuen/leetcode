// 191. Number of 1 Bits

// Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

 

// Example 1:

// Input: n = 11

// Output: 3

// Explanation:

// The input binary string 1011 has a total of three set bits.

// Example 2:

// Input: n = 128

// Output: 1

// Explanation:

// The input binary string 10000000 has a total of one set bit.

// Example 3:

// Input: n = 2147483645

// Output: 30

// Explanation:

// The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

 

// Constraints:

// 1 <= n <= 231 - 1
 

// Follow up: If this function is called many times, how would you optimize it?

// Runtime 0 ms Beats 100.00%
// Memory 3.89 MB Beats 100.00%
func hammingWeight(n int) int {
    count := 0
    for i := 0; i < 32; i++ {
        bit := n & 1
        count = count + bit
        n = n >> 1
    }
    return count
}