// 190. Reverse Bits

// Reverse bits of a given 32 bits signed integer.

 

// Example 1:

// Input: n = 43261596

// Output: 964176192

// Explanation:

// Integer Binary
// 43261596    00000010100101000001111010011100
// 964176192   00111001011110000010100101000000
// Example 2:

// Input: n = 2147483644

// Output: 1073741822

// Explanation:

// Integer Binary
// 2147483644  01111111111111111111111111111100
// 1073741822  00111111111111111111111111111110
 

// Constraints:

// 0 <= n <= 231 - 2
// n is even.
 

// Follow up: If this function is called many times, how would you optimize it?

// Runtime 4 ms Beats 27.60%
// Memory 3.89 MB Beats 95.25%
func reverseBits(n int) int {
    var result int
    for i := 0; i < 32; i++ {
        bit := n & 1
        result = result << 1
        result = result | bit
        n = n >> 1
    }
    return result
}

// Runtime 0 ms Beats 100.00%
// Memory 3.90 MB Beats 95.25%
func reverseBits(n int) int {
    var result int
    for i := 0; i < 32; i++ {
        bit := n & 1
        bit = bit << (31 - i)
        result = result | bit
        n = n >> 1
    }
    return result
}