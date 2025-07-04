// 1423. Maximum Points You Can Obtain from Cards
// There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

// In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

// Your score is the sum of the points of the cards you have taken.

// Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

// Example 1:

// Input: cardPoints = [1,2,3,4,5,6,1], k = 3
// Output: 12
// Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
// Example 2:

// Input: cardPoints = [2,2,2], k = 2
// Output: 4
// Explanation: Regardless of which two cards you take, your score will always be 4.
// Example 3:

// Input: cardPoints = [9,7,7,9,7,7,9], k = 7
// Output: 55
// Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

// Constraints:

// 1 <= cardPoints.length <= 105
// 1 <= cardPoints[i] <= 104
// 1 <= k <= cardPoints.length

// Runtime: 4 ms, faster than 30.67% of Java online submissions for Maximum Points You Can Obtain from Cards.
// Memory Usage: 66.2 MB, less than 18.92% of Java online submissions for Maximum Points You Can Obtain from Cards.
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        int max = 0;
        for (int i = 1; i <= k; i++) {
            left[i] = left[i - 1] + cardPoints[i - 1];
            right[k - i] = right[k - i + 1] + cardPoints[cardPoints.length - i];
        }
        for (int i = 0; i <= k; i++) {
            if (left[i] + right[i] > max) {
                max = left[i] + right[i];
            }
        }
        return max;
    }
}


// Runtime: 3 ms, faster than 58.92% of Java online submissions for Maximum Points You Can Obtain from Cards.
// Memory Usage: 66 MB, less than 24.38% of Java online submissions for Maximum Points You Can Obtain from Cards.
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int minSubArraySum = 0;
        int total = 0;
        int curSum = 0;
        int length = cardPoints.length;
        for (int i = 0; i < length; i++) {
            total = total + cardPoints[i];
            curSum = curSum + cardPoints[i];
            if (length - k > i) {
                minSubArraySum = curSum;
            } else {
                curSum = curSum - cardPoints[i - (length - k)];
                minSubArraySum = Math.min(minSubArraySum, curSum);
            }
        }
        return total - minSubArraySum;
    }
}