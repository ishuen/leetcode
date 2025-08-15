// 77. Combinations

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

 

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.
 

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n

// Runtime 122 ms Beats 8.67%
// Memory 91.41 MB Beats 5.10%
func combine(n int, k int) [][]int {
    pool := make([]int, n)
    for i := 1; i <= n; i++ {
        pool[i - 1] = i
    }
    output := [][]int{}
    var findComb func(index int, current []int)
    findComb = func(index int, current []int) {
        for i := index; i < len(pool); i++ {
            next := make([]int, len(current))
            copy(next, current)
            next = append(next, pool[i])
            if len(next) == k {
                output = append(output, next)
            } else {
                findComb(i + 1, next)
            }
        }
    }
    findComb(0, []int{})
    return output
}

// Runtime 35 ms Beats 78.57%
// Memory 51.07 MB Beats 98.72%
func combine(n int, k int) [][]int {
    output := [][]int{}
    current := []int{}
    var findComb func(index int)
    findComb = func(num int) {
        if len(current) == k {
            cur := make([]int, len(current))
            copy(cur, current)
            output = append(output, cur)
            return
        }
        for i := num; i <= n; i++ {
            current = append(current, i)
            findComb(i + 1)
            current = current[:len(current) - 1]
        }
    }
    findComb(1)
    return output
}