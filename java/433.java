// 433. Minimum Genetic Mutation
// A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
//
// Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
//
// For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
// There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
//
// Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
//
// Note that the starting point is assumed to be valid, so it might not be included in the bank.
//
//
//
// Example 1:
//
// Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
// Output: 1
// Example 2:
//
// Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
// Output: 2
//
//
// Constraints:
//
// 0 <= bank.length <= 10
// startGene.length == endGene.length == bank[i].length == 8
// startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
//
// Runtime 0 ms Beats 100%
// Memory 40.3 MB Beats 87.46%
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (!containsGene(endGene, bank)) return -1;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];
        queue.add(startGene);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String base = queue.remove();
                if (base.equals(endGene)) return count;
                for (int i = 0; i < bank.length; i++) {
                    if (visited[i] == true) continue;
                    if (isDiffOne(bank[i], base)) {
                        visited[i] = true;
                        queue.add(bank[i]);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private boolean containsGene(String endGene, String[] bank) {
        for (int i = 0; i < bank.length; i++) {
            if (endGene.equals(bank[i])) return true;
        }
        return false;
    }
    private boolean isDiffOne(String toCompare, String base) {
        int count = 0;
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) != toCompare.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
