// 646. Maximum Length of Pair Chain
// You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
//
// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
//
// Return the length longest chain which can be formed.
//
// You do not need to use up all the given intervals. You can select pairs in any order.
//
//
//
// Example 1:
//
// Input: pairs = [[1,2],[2,3],[3,4]]
// Output: 2
// Explanation: The longest chain is [1,2] -> [3,4].
// Example 2:
//
// Input: pairs = [[1,2],[7,8],[4,5]]
// Output: 3
// Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
//
//
// Constraints:
//
// n == pairs.length
// 1 <= n <= 1000
// -1000 <= lefti < righti < 1000
//
// Runtime: 22 ms, faster than 50.18% of Java online submissions for Maximum Length of Pair Chain.
// Memory Usage: 39.4 MB, less than 56.08% of Java online submissions for Maximum Length of Pair Chain.
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 1) return 1;
        int[] counts = new int[pairs.length];
        Arrays.fill(counts, 1);
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int max = 1;
        for (int i = pairs.length - 2; i >= 0; i--) {
            int next = findNext(i, pairs, counts);
            if (next != -1) {
                counts[i] += counts[next];
            }
            if (counts[i] > max) max = counts[i];
        }
        return max;
    }
    
    private int findNext(int index, int[][] pairs, int[] counts) {
        int right = pairs[index][1];
        int max = 0;
        int maxIndex = index;
        for (int i = index + 1; i < pairs.length; i++) {
            if (pairs[i][0] > right && counts[i] > max) {
                max = counts[i];
                maxIndex = i;
            }
        }
        return max == 0 ? -1 : maxIndex;
    }
}

// Runtime: 9 ms, faster than 83.01% of Java online submissions for Maximum Length of Pair Chain.
// Memory Usage: 39.3 MB, less than 67.67% of Java online submissions for Maximum Length of Pair Chain.
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int count = 0;
        int i = 0;
        while (i < pairs.length) {
            count++;
            int right = pairs[i][1];
            while (i < pairs.length && pairs[i][0] <= right) i++;
        }
        return count;
    }
}