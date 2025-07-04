// 875. Koko Eating Bananas
// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.
//
// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
//
//
// Constraints:
// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109


// Runtime: 15 ms, faster than 60.07% of Java online submissions for Koko Eating Bananas.
// Memory Usage: 39.7 MB, less than 96.73% of Java online submissions for Koko Eating Bananas.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minBoundry = 1;
        int maxBoundry = max(piles);
        return checkBanana(minBoundry, maxBoundry, h, piles);
    }
    
    private int checkBanana(int min, int max, int h, int[] piles) {
        int count = (min + max) / 2;
        int actual = 0;
        for (int i = 0; i < piles.length; i++) {
            actual = actual + piles[i] / count;
            if (piles[i] % count != 0) actual++;
        }
        if (actual > h && min < count) {
            return checkBanana(count, max, h, piles);
        }
        else if (actual <= h && max > count) {
            return checkBanana(min, count, h, piles);
        } else if (actual > h && min == count) {
            return max;
        }
        return count;
    }
    
    private int max(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }
}


// Runtime: 14 ms, faster than 71.65% of Java online submissions for Koko Eating Bananas.
// Memory Usage: 39.9 MB, less than 81.40% of Java online submissions for Koko Eating Bananas.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minBoundry = 1;
        int maxBoundry = max(piles);
        int count = 0;
        while (minBoundry < maxBoundry) {
            count = (minBoundry + maxBoundry) / 2;
            if (isDoable(count, h, piles)) {
                maxBoundry = count;
            } else {
                minBoundry = count + 1;
            }
        }
        return minBoundry;
    }
    
    private Boolean isDoable(int count, int h, int[] piles) {
        int actual = 0;
        for (int i = 0; i < piles.length; i++) {
            actual = actual + piles[i] / count;
            if (piles[i] % count != 0) actual++;
        }
        return actual <= h;
    }
    
    private int max(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }
}