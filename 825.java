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



// Runtime 22 ms Beats 46.97%
// Memory 46.8 MB Beats 13.13%
class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> ageCount = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            ageCount.put(ages[i], ageCount.getOrDefault(ages[i], 0) + 1);
        }
        Set<Integer> keys = ageCount.keySet();
        for (Integer key1: keys) {
            for (Integer key2: keys) {
                if (key2 <= 0.5 * key1 + 7) continue;
                else if (key2 > key1) continue;
                else if (key2 > 100 && key1 < 100) continue;
                else if (key1 == key2) {
                    int count = ageCount.get(key1);
                    sum = sum + count * (count - 1);
                }
                else {
                    sum = sum + ageCount.get(key1) * ageCount.get(key2);
                }
            }
        }
        return sum;
    }
}

// Runtime 4 ms Beats 68.69%
// Memory 45.2 MB Beats 94.44%
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            ageCount[ages[i]]++;
        }
        for (int i = 1; i < ageCount.length; i++) {
            if (ageCount[i] == 0) continue;
            for (int j = 1; j < ageCount.length; j++) {
                if (ageCount[j] == 0) continue;
                if (j <= 0.5 * i + 7) continue;
                else if (j > i) continue;
                else if (j > 100 && i < 100) continue;
                else if (i == j) {
                    sum = sum + ageCount[i] * (ageCount[i] - 1);
                }
                else {
                    sum = sum + ageCount[i] * ageCount[j];
                }
            }
        }
        return sum;
    }
}
