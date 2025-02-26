// 354. Russian Doll Envelopes
//
// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
//
// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
//
// Note: You cannot rotate an envelope.
//
//
//
// Example 1:
//
// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
// Example 2:
//
// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1
//
//
// Constraints:
//
// 1 <= envelopes.length <= 105
// envelopes[i].length == 2
// 1 <= wi, hi <= 105
//
// Runtime 37 ms Beats 96.18% of users with Java
// Memory 104.64 MB Beats 22.62% of users with Java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int len = 0;
        int[] layers = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int index = Arrays.binarySearch(layers, 0, len, envelopes[i][1]);
            if (index < 0) index = -(index + 1);
            layers[index] = envelopes[i][1];
            if (index == len) len++;
        }
        return len;
    }
}