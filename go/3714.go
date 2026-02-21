// 3714. Longest Balanced Substring II

// You are given a string s consisting only of the characters 'a', 'b', and 'c'.

// A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

// Return the length of the longest balanced substring of s.

 

// Example 1:

// Input: s = "abbac"

// Output: 4

// Explanation:

// The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

// Example 2:

// Input: s = "aabcc"

// Output: 3

// Explanation:

// The longest balanced substring is "abc" because all distinct characters 'a', 'b' and 'c' each appear exactly 1 time.

// Example 3:

// Input: s = "aba"

// Output: 2

// Explanation:

// One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

 

// Constraints:

// 1 <= s.length <= 105
// s contains only the characters 'a', 'b', and 'c'.

// Runtime 359 ms Beats 41.22%
// Memory 22.52 MB Beats 43.70%
func longestBalanced(s string) int {
    maxLen := 1
    maxLen = max(maxLen, singleLetter(s))
    maxLen = max(maxLen, twoLetter('a', 'b', s))
    maxLen = max(maxLen, twoLetter('c', 'b', s))
    maxLen = max(maxLen, twoLetter('a', 'c', s))
    maxLen = max(maxLen, threeLetter(s))
    return maxLen
}

func singleLetter(s string) int {
    maxLen := 1
    base := s[0]
    current := 1
    for i := 1; i < len(s); i++ {
        if s[i] == base {
            current++
        } else {
            maxLen = max(maxLen, current)
            current = 1
            base = s[i]
        }
    }
    return max(maxLen, current)
}

func twoLetter(x byte, y byte, s string) int {
    maxLen := 0
    i := 0
    length := len(s)
    for i < length {
        if s[i] != x && s[i] != y {
            i++
            continue
        }
        diffCounts := make(map[int]int)
        diff := 0
        diffCounts[0] = i - 1
        for ; i < length && (s[i] == x || s[i] == y); i++ {
            if s[i] == x {
                diff += 1
            } else {
                diff -= 1
            }
            index, ok := diffCounts[diff]
            if ok {
                maxLen = max(maxLen, i - index)
            } else {
                diffCounts[diff] = i
            }
        }
    }
    return maxLen
}

func threeLetter(s string) int {
    diffCountPairs := make(map[string]int)
    maxLen := 0
    countA := 0
    countB := 0
    countC := 0
    diffCountPairs["0-0"] = -1
    for i := 0; i < len(s); i++ {
        if s[i] == 'a' {
            countA++
        } else if s[i] == 'b' {
            countB++
        } else {
            countC++
        }
        diffAB := countA - countB
        diffAC := countA - countC
        pair := strconv.Itoa(diffAB) + "-" + strconv.Itoa(diffAC)
        index, ok := diffCountPairs[pair]
        if ok {
            maxLen = max(maxLen, i - index)
        } else {
            diffCountPairs[pair] = i
        }
    }
    return maxLen
}