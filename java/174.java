// 174. Dungeon Game
// The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
//
// The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
// Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
//
// To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
// Return the knight's minimum initial health so that he can rescue the princess.
//
// Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
//
//
//
// Example 1:
//
//
// Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
// Output: 7
// Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
// Example 2:
//
// Input: dungeon = [[0]]
// Output: 1
//
//
// Constraints:
//
// m == dungeon.length
// n == dungeon[i].length
// 1 <= m, n <= 200
// -1000 <= dungeon[i][j] <= 1000
//
// Runtime: 1 ms, faster than 84.85% of Java online submissions for Dungeon Game.
// Memory Usage: 41.5 MB, less than 6.16% of Java online submissions for Dungeon Game.
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] minHealth = new int[dungeon.length + 1][dungeon[0].length + 1];
        minHealth[dungeon.length][dungeon[0].length - 1] = 1;
        minHealth[dungeon.length - 1][dungeon[0].length] = 1;
        for (int i = 0; i < dungeon.length - 1; i++) {
            minHealth[i][dungeon[0].length] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dungeon[0].length - 1; i++) {
            minHealth[dungeon.length][i] = Integer.MAX_VALUE;
        }
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                minHealth[i][j] = Math.min(minHealth[i + 1][j], minHealth[i][j+1]) - dungeon[i][j];
                if (minHealth[i][j] <= 0) minHealth[i][j] = 1;
            }
        }
        return minHealth[0][0];
    }
}

// minimum initial health = max (overall negative number) * (-1) + 1
// -2 -> -5 -> -2 -> -1 -> -6 

//  7   5  2
//  6  11 5
//  1  1  6

// bottom left = negative + 1
// deduct positive -> if turns negative, set as 1
// add (-1) * negative
// take min (right and below)