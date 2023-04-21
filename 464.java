// 464. Can I Win
// In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
//
// What if we change the game so that players cannot re-use integers?
//
// For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
//
// Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.
//
//
//
// Example 1:
//
// Input: maxChoosableInteger = 10, desiredTotal = 11
// Output: false
// Explanation:
// No matter which integer the first player choose, the first player will lose.
// The first player can choose an integer from 1 up to 10.
// If the first player choose 1, the second player can only choose integers from 2 up to 10.
// The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
// Same with other integers chosen by the first player, the second player will always win.
// Example 2:
//
// Input: maxChoosableInteger = 10, desiredTotal = 0
// Output: true
// Example 3:
//
// Input: maxChoosableInteger = 10, desiredTotal = 1
// Output: true
//
//
// Constraints:
//
// 1 <= maxChoosableInteger <= 20
// 0 <= desiredTotal <= 300
//
// Runtime 1695 ms Beats 5.2%
// Memory 103.7 MB Beats 11.30%
class Solution {
    Map<Integer, Boolean> memory = new HashMap<>();
    boolean[] choosables;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        choosables = new boolean[maxChoosableInteger + 1];
        return canWin(desiredTotal);
    }

    private boolean canWin(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int key = convertKey(choosables);
        Boolean checkMemory = memory.get(key);
        if (checkMemory != null) return checkMemory;
        for (int i = choosables.length - 1; i >= 1; i--) {
            if (choosables[i] == true) continue;
            choosables[i] = true;
            if (!canWin(desiredTotal - i)) {
                memory.put(key, true);
                choosables[i] = false;
                return true;
            }
            choosables[i] = false;
        }
        memory.put(key, false);
        return false;
    }

    private Integer convertKey(boolean[] choosables) {
        Integer num = 0;
        for (int i = 0; i < choosables.length; i++) {
            num <<= 1;
            if(choosables[i]) num |= 1;
        }
        return num;
    }
}