// 2976. Minimum Cost to Convert String I

// You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].

// You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.

// Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.

// Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].

 

// Example 1:

// Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
// Output: 28
// Explanation: To convert the string "abcd" to string "acbe":
// - Change value at index 1 from 'b' to 'c' at a cost of 5.
// - Change value at index 2 from 'c' to 'e' at a cost of 1.
// - Change value at index 2 from 'e' to 'b' at a cost of 2.
// - Change value at index 3 from 'd' to 'e' at a cost of 20.
// The total cost incurred is 5 + 1 + 2 + 20 = 28.
// It can be shown that this is the minimum possible cost.
// Example 2:

// Input: source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
// Output: 12
// Explanation: To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.
// Example 3:

// Input: source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
// Output: -1
// Explanation: It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'.
 

// Constraints:

// 1 <= source.length == target.length <= 105
// source, target consist of lowercase English letters.
// 1 <= cost.length == original.length == changed.length <= 2000
// original[i], changed[i] are lowercase English letters.
// 1 <= cost[i] <= 106
// original[i] != changed[i]


// Runtime 9 ms Beats 67.31%
// Memory 9.19 MB Beats 62.31%
func minimumCost(source string, target string, original []byte, changed []byte, cost []int) int64 {
    matrix := make([][]int64, 26)
    for i := 0; i < 26; i++ {
        matrix[i] = make([]int64, 26)
        for j := 0; j < 26; j++ {
            if i == j {
                matrix[i][j] = 0
            } else {
                matrix[i][j] = math.MaxInt64
            }
        }
    }
    for i := 0; i < len(original); i++ {
        start := original[i] - 'a'
        end := changed[i] - 'a'
        matrix[start][end] = min(matrix[start][end], int64(cost[i]))
    }

    // Check the nodes with in and out edges exist
    for i := 0; i < 26; i++ {
        for j := 0; j < 26; j++ {
            if matrix[j][i] == math.MaxInt64 {
                continue
            }
            for k := 0; k < 26; k++ {
                if matrix[i][k] != math.MaxInt64 {
                    matrix[j][k] = min(matrix[j][k], matrix[j][i] + matrix[i][k])
                }
            }
        }
    }

    var total int64 = 0
    for i := 0; i < len(source); i++ {
        start := source[i] - 'a'
        end := target[i] - 'a'
        if start == end {
            continue
        }
        if matrix[start][end] == math.MaxInt64 {
            return int64(-1)
        }
        total += int64(matrix[start][end])
    }
    return total
}