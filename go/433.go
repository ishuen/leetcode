// 433. Minimum Genetic Mutation

// A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

// Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

// For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
// There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

// Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

// Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

// Example 1:

// Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
// Output: 1
// Example 2:

// Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
// Output: 2
 

// Constraints:

// 0 <= bank.length <= 10
// startGene.length == endGene.length == bank[i].length == 8
// startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

// Runtime 0 ms Beats 100.00%
// Memory 3.84 MB Beats 91.85%
func minMutation(startGene string, endGene string, bank []string) int {
    queue := []string{}
    queue = append(queue, startGene)
    count := 0
    for ; len(queue) > 0; {
        size := len(queue)
        count++
        for i := 0; i < size; i++ {
            cur := queue[i]
            for j := 0; j < len(bank); j++ {
                if checkDiffIsOne(cur, bank[j]) {
                    if bank[j] == endGene {
                        return count
                    }
                    queue = append(queue, bank[j])
                    bank[j] = ""
                }
            }
        }
        queue = queue[size:]
    }
    return -1
}

func checkDiffIsOne(curGene string, targetGene string) bool {
    count := 0
    for index, char := range targetGene {
        if curGene[index] != byte(char) {
            count++
        }
    }
    return count == 1
}