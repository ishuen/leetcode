// 131. Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

// Runtime 26 ms Beats 44.78%
// Memory 22.14 MB Beats 67.83%
func partition(s string) [][]string {
    matrix := make([][]bool, len(s))
    for i := range matrix {
        matrix[i] = make([]bool, len(s))
    }
    for i := 0; i < len(s); i++ {
        matrix[i][i] = true
        for j := 0; j < i; j++ {
            if s[i] == s[j] && (matrix[i - 1][j + 1] == true || i == j + 1) {
                matrix[i][j] = true
            }
        }
    }

    answer := make([][]string, 0)
    var backtracking func(start int, tempList []string)
    backtracking = func(start int, tempList []string) {
        if start == len(s) {
            newList := make([]string, len(tempList))
            copy(newList, tempList)
            answer = append(answer, newList)
            return
        }
        for i := start; i < len(s); i++ {
            if matrix[i][start] == true {
                tempList = append(tempList, s[start:i + 1])
                backtracking(i + 1, tempList)
                tempList = tempList[:len(tempList) - 1]
            }
        }
    }
    backtracking(0, []string{})
    return answer
}


// Runtime 20 ms Beats 77.39%
// Memory 21.97 MB Beats 71.74%
func partition(s string) [][]string {
    isPalindrome := func(start, end int) bool {
        for left, right := start, end; left < right; {
            if s[left] == s[right] {
                left++
                right--
            } else {
                return false
            }
        }
        return true
    }
    answer := make([][]string, 0)
    var backtracking func(start int, tempList []string)
    backtracking = func(start int, tempList []string) {
        if start == len(s) {
            newList := make([]string, len(tempList))
            copy(newList, tempList)
            answer = append(answer, newList)
            return
        }
        for i := start; i < len(s); i++ {
            if isPalindrome(start, i) {
                tempList = append(tempList, s[start:i + 1])
                backtracking(i + 1, tempList)
                tempList = tempList[:len(tempList) - 1]
            }
        }
    }
    backtracking(0, []string{})
    return answer
}
