// 473. Matchsticks to Square
// You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
// Return true if you can make this square and false otherwise.
//
//
//
// Example 1:
//
//
// Input: matchsticks = [1,1,2,2,2]
// Output: true
// Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
// Example 2:
//
// Input: matchsticks = [3,3,3,3,4]
// Output: false
// Explanation: You cannot find a way to form a square with all the matchsticks.
//
//
// Constraints:
//
// 1 <= matchsticks.length <= 15
// 1 <= matchsticks[i] <= 108
//
// Runtime: 306 ms, faster than 31.08% of Java online submissions for Matchsticks to Square.
// Memory Usage: 36.6 MB, less than 63.20% of Java online submissions for Matchsticks to Square.
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        sum = sum / 4;
        int[] curSum = new int[4];
        curSum[0] = matchsticks[0];
        return checkSum(curSum, 1, sum, matchsticks);
    }
    
    private boolean checkSum(int[] curSum, int curIndex, int targetSum, int[] sticks) {
        if (curSum[0] == curSum[1] && curSum[1] == curSum[2] && curSum[2] == targetSum) return true;
        boolean isMatched = false;
        for (int i = 0; i < 4; i++) {
            if (curSum[i] + sticks[curIndex] > targetSum) continue;
            curSum[i] += sticks[curIndex];
            isMatched = isMatched || checkSum(curSum, curIndex + 1, targetSum, sticks);
            curSum[i] -= sticks[curIndex];
        }
        return isMatched;
    }
}

// Runtime: 7 ms, faster than 79.58% of Java online submissions for Matchsticks to Square.
// Memory Usage: 36.5 MB, less than 63.20% of Java online submissions for Matchsticks to Square.
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        sum = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] curSum = new int[4];
        curSum[0] = matchsticks[0];
        return checkSum(curSum, 1, sum, matchsticks);
    }
    
    private boolean checkSum(int[] curSum, int curIndex, int targetSum, int[] sticks) {
        if (curSum[0] == curSum[1] && curSum[1] == curSum[2] && curSum[2] == targetSum) return true;
        if (curIndex >= sticks.length) return false;
        boolean isMatched = false;
        for (int i = 0; i < 4; i++) {
            if (curSum[i] + sticks[curIndex] > targetSum) continue;
            curSum[i] += sticks[curIndex];
            isMatched = isMatched || checkSum(curSum, curIndex + 1, targetSum, sticks);
            curSum[i] -= sticks[curIndex];
        }
        return isMatched;
    }
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}