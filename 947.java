// 947. Most Stones Removed with Same Row or Column
//
// On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
//
// A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
//
// Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
//
//
//
// Example 1:
//
// Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
// Output: 5
// Explanation: One way to remove 5 stones is as follows:
// 1. Remove stone [2,2] because it shares the same row as [2,1].
// 2. Remove stone [2,1] because it shares the same column as [0,1].
// 3. Remove stone [1,2] because it shares the same row as [1,0].
// 4. Remove stone [1,0] because it shares the same column as [0,0].
// 5. Remove stone [0,1] because it shares the same row as [0,0].
// Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
// Example 2:
//
// Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
// Output: 3
// Explanation: One way to make 3 moves is as follows:
// 1. Remove stone [2,2] because it shares the same row as [2,0].
// 2. Remove stone [2,0] because it shares the same column as [0,0].
// 3. Remove stone [0,2] because it shares the same row as [0,0].
// Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
// Example 3:
//
// Input: stones = [[0,0]]
// Output: 0
// Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
//
//
// Constraints:
//
// 1 <= stones.length <= 1000
// 0 <= xi, yi <= 104
// No two stones are at the same coordinate point.
//
// Runtime 71 ms Beats 17.8%
// Memory 43.6 MB Beats 32.22%
class Solution {
    public int removeStones(int[][] stones) {
        int[] removed = new int[stones.length]; // never check 0, remove 1, keep -1
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stones.length; i++) {
            if (removed[i] == 1 || removed[i] == 1) continue;
            stack.push(i);
            removed[i] = -1;
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                for (int j = 0; j < stones.length; j++) {
                    if (j == i || removed[j] != 0) continue;
                    if ((stones[j][0] == stones[cur][0] || stones[j][1] == stones[cur][1])) {
                        removed[j] = 1;
                        stack.push(j);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

// Runtime 20 ms Beats 71.3%
// Memory 44.3 MB Beats 9.28%
class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            List<Integer> rowList = rowMap.getOrDefault(stones[i][0], new ArrayList<>());
            rowList.add(i);
            rowMap.put(stones[i][0], rowList);
            List<Integer> colList = colMap.getOrDefault(stones[i][1], new ArrayList<>());
            colList.add(i);
            colMap.put(stones[i][1], colList);
        }
        int[] removed = new int[stones.length]; // never check 0, remove 1, keep -1
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stones.length; i++) {
            if (removed[i] == 0) {
                stack.push(i);
                removed[i] = -1;
            }
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                for (int r: rowMap.get(stones[cur][0])) {
                    if (removed[r] == 0) {
                        stack.push(r);
                        removed[r] = 1;
                        count++;
                    }
                }
                for (int c: colMap.get(stones[cur][1])) {
                    if (removed[c] == 0) {
                        stack.push(c);
                        removed[c] = 1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}