// 846. Hand of Straights
// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
//
// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
//
//
//
// Example 1:
//
// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
// Example 2:
//
// Input: hand = [1,2,3,4,5], groupSize = 4
// Output: false
// Explanation: Alice's hand can not be rearranged into groups of 4.
//
//
//
// Constraints:
//
// 1 <= hand.length <= 104
// 0 <= hand[i] <= 109
// 1 <= groupSize <= hand.length
//
//
// Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
//
// Runtime 9 ms Beats 100%
// Memory 42.9 MB Beats 92.40%
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length == 0 || hand.length % groupSize != 0) return false;
        boolean[] selected = new boolean[hand.length];
        Arrays.sort(hand);
        int startIndex = 0;
        int groupCount = 0;
        int target = hand.length / groupSize;
        while (startIndex < hand.length && groupCount < target) {
            while (selected[startIndex] == true) {
                startIndex++;
            }
            selected[startIndex] = true;
            int base = hand[startIndex];
            int curIndex = startIndex + 1;
            int count = 1;
            for (int i = 1; i < groupSize; i++) {
                while (curIndex < hand.length && count == i) {
                    if (hand[curIndex] > base + i) {
                        return false;
                    }
                    if (hand[curIndex] == base + i && selected[curIndex] == false) {
                        count++;
                        selected[curIndex] = true;
                    }
                    curIndex++;
                }
            }
            if (count != groupSize) return false;
            else groupCount++;
        }
        return groupCount == target;
    }
}