// 2531. Make Number of Distinct Characters Equal

// You are given two 0-indexed strings word1 and word2.

// A move consists of choosing two indices i and j such that 0 <= i < word1.length and 0 <= j < word2.length and swapping word1[i] with word2[j].

// Return true if it is possible to get the number of distinct characters in word1 and word2 to be equal with exactly one move. Return false otherwise.

 

// Example 1:

// Input: word1 = "ac", word2 = "b"
// Output: false
// Explanation: Any pair of swaps would yield two distinct characters in the first string, and one in the second string.
// Example 2:

// Input: word1 = "abcc", word2 = "aab"
// Output: true
// Explanation: We swap index 2 of the first string with index 0 of the second string. The resulting strings are word1 = "abac" and word2 = "cab", which both have 3 distinct characters.
// Example 3:

// Input: word1 = "abcde", word2 = "fghij"
// Output: true
// Explanation: Both resulting strings will have 5 distinct characters, regardless of which indices we swap.
 

// Constraints:

// 1 <= word1.length, word2.length <= 105
// word1 and word2 consist of only lowercase English letters.

// Runtime 15 ms Beats -%
// Memory 8.57 MB Beats 75.00%
func isItPossible(word1 string, word2 string) bool {
    map1 := make(map[rune]int)
    map2 := make(map[rune]int)
    for _, c := range word1 {
        map1[c]++
    }
    for _, c := range word2 {
        map2[c]++
    }
    count1 := len(map1)
    count2 := len(map2)
    if count1 == count2 && len(word1) == len(word2) {
        return true
    }
    for k1, v1 := range map1 {
        for k2, v2 := range map2 {
            temp1 := count1
            temp2 := count2
            if v1 == 1 {
                temp1--
            }
            map1[k1]--
            if map1[k2] == 0 {
                temp1++
            }
            if v2 == 1 {
                temp2--
                
            }
            map2[k2]--
            if map2[k1] == 0 {
                temp2++
            }
            if temp1 == temp2 {
                return true
            }
            map1[k1]++
            map2[k2]++
        }
    }
    return false
}

// Runtime 4 ms Beats 12.50%
// Memory 8.92 MB Beats -%
func isItPossible(word1 string, word2 string) bool {
    map1, map2 := [26]int{}, [26]int{}
    for _, c := range word1 {
        map1[c - 'a']++
    }
    for _, c := range word2 {
        map2[c - 'a']++
    }
    
    for i := range 26 {
        for j := range 26 {
            if map1[i] == 0 || map2[j] == 0 {
                continue
            }
            map1[i], map2[i] = map1[i] - 1, map2[i] + 1 
            map1[j], map2[j] = map1[j] + 1,  map2[j] - 1
            count1, count2 := 0, 0
            for k := 0; k < 26; k++ {
                if map1[k] > 0 {
                    count1++
                }
                if map2[k] > 0 {
                    count2++
                }
            }
            if count1 == count2 {
                return true
            }
            map1[i], map2[i] = map1[i] + 1, map2[i] - 1 
            map1[j], map2[j] = map1[j] - 1,  map2[j] + 1
        }
    }
    return false
}