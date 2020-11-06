// 605. Can Place Flowers
// Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
// Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
//
// Example 1:
//
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: True
// Example 2:
//
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False
// Note:
//
// The input array won't violate no-adjacent-flowers rule.
// The input array size is in the range of [1, 20000].
// n is a non-negative integer which won't exceed the input array size.
//
// Runtime: 1 ms, faster than 94.80% of Java online submissions for Can Place Flowers.
// Memory Usage: 40.4 MB, less than 13.32% of Java online submissions for Can Place Flowers.
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        int next = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (n == 0) break;
            prev = i == 0 ? 0 : flowerbed[i - 1];
            next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (prev == 0 && next == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        if (n == 0) return true;
        return false;
    }
}

