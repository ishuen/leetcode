// 386. Lexicographical Numbers
//
// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
//
// You must write an algorithm that runs in O(n) time and uses O(1) extra space.
//
//
//
// Example 1:
//
// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
// Example 2:
//
// Input: n = 2
// Output: [1,2]
//
//
// Constraints:
//
// 1 <= n <= 5 * 104
//
// Runtime 5 ms Beats 71.05%
// Memory 62.67 MB Beats 73.68%
function lexicalOrder(n: number): number[] {
    let output = []
    produce(n, 0, output)
    return output
};

function produce(max: number, prefix: number, output: number[]): void {
    for (let i = 0; i < 10; i++) {
        let temp = prefix * 10 + i
        if (temp > 0 && temp <= max) {
            output.push(temp)
            produce(max, temp, output)
        }
    }
}