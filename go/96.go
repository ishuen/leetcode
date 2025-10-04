// 96. Unique Binary Search Trees

// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

// Example 1:


// Input: n = 3
// Output: 5
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 19

// Runtime 0 ms Beats 100.00%
// Memory 3.81 MB Beats 79.41%
func numTrees(n int) int {
    memory := make(map[int]int)
    var findTree func(start int, end int) int
    findTree = func(start int, end int) int {
        if start > end {
            return 0
        }
        c, ok := memory[end - start]
        if ok {
            return c
        }
        count := 0
        for i := start; i <= end; i++ {
            left := findTree(start, i - 1)
            right := findTree(i + 1, end)
            if left > 0 && right > 0 {
                count = count + left * right 
            } else if left <= 1 && right > 0 {
                count = count + right
            } else if right <= 1 && left > 0 {
                count = count + left
            } else {
                count = count + 1
            }
        }
        memory[end - start] = count
        return count
    }
    return findTree(1, n)
}

// Runtime 0 ms Beats 100.00%
// Memory 3.99 MB Beats 30.15%
func numTrees(n int) int {
    counts := make([]int, n + 1)
    counts[0] = 1
    counts[1] = 1
    for i := 2; i <= n; i++ {
        for j := 1; j <= i; j++ {
            counts[i] = counts[i] + counts[j - 1] * counts[i - j]
        }
    }
    return counts[n]
}