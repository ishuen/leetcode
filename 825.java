// 825. Friends Of Appropriate Ages
// There are n persons on a social media website. You are given an integer array ages where ages[i] is the age of the ith person.
//
// A Person x will not send a friend request to a person y (x != y) if any of the following conditions is true:
//
// age[y] <= 0.5 * age[x] + 7
// age[y] > age[x]
// age[y] > 100 && age[x] < 100
// Otherwise, x will send a friend request to y.
//
// Note that if x sends a request to y, y will not necessarily send a request to x. Also, a person will not send a friend request to themself.
//
// Return the total number of friend requests made.
//
//
//
// Example 1:
//
// Input: ages = [16,16]
// Output: 2
// Explanation: 2 people friend request each other.
// Example 2:
//
// Input: ages = [16,17,18]
// Output: 2
// Explanation: Friend requests are made 17 -> 16, 18 -> 17.
// Example 3:
//
// Input: ages = [20,30,100,110,120]
// Output: 3
// Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
//
//
// Constraints:
//
// n == ages.length
// 1 <= n <= 2 * 104
// 1 <= ages[i] <= 120
//
// Runtime: 2 ms, faster than 86.94% of Java online submissions for Friends Of Appropriate Ages.
// Memory Usage: 42 MB, less than 30.88% of Java online submissions for Friends Of Appropriate Ages.
class Solution {
    public int numFriendRequests(int[] ages) {
        int count = 0;
        int[] combinedAges = new int[120];
        for (int i = 0; i < ages.length; i++) {
            combinedAges[ages[i] - 1]++;
        }
        int start = 0;
        for (int i = 0; i < 120; i++) {
            if (combinedAges[i] == 0) continue;
            for (int j = start; j <= i; j++) {
                if (combinedAges[j] == 0) continue;
                // i = x, j = y
                if (j + 1 <= (i + 1) / 2 + 7) {
                    start = j + 1;
                    continue;
                }
                count = i == j ? count + combinedAges[i] * (combinedAges[j] - 1) : count + combinedAges[i] * combinedAges[j];
            }
        }
        return count;
    }
}