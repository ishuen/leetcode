// 881. Boats to Save People
//
// You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//
// Return the minimum number of boats to carry every given person.
//
//
//
// Example 1:
//
// Input: people = [1,2], limit = 3
// Output: 1
// Explanation: 1 boat (1, 2)
// Example 2:
//
// Input: people = [3,2,2,1], limit = 3
// Output: 3
// Explanation: 3 boats (1, 2), (2) and (3)
// Example 3:
//
// Input: people = [3,5,3,4], limit = 5
// Output: 4
// Explanation: 4 boats (3), (3), (4), (5)
//
//
// Constraints:
//
// 1 <= people.length <= 5 * 104
// 1 <= people[i] <= limit <= 3 * 104
//
// Runtime 12 ms Beats 98.15%
// Memory 54.3 MB Beats 6.59%
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] weights = new int[limit + 1];
        for (int person: people) {
            weights[person]++;
        }
        int count = weights[limit];
        weights[limit] = 0;
        int index = limit - 1;
        while (index > 0) {
            if (weights[index] == 0) {
                index--;
                continue;
            }
            weights[index]--;
            count++;
            int next = limit - index;
            while (next > 0 && weights[next] == 0) {
                next--;
            }
            if (next > 0 && weights[next] > 0) {
                weights[next]--;
            }
            if (next != index && weights[index] > 0 && weights[next] > 0) {
                int min = Math.min(weights[index], weights[next]);
                weights[index] = weights[index] - min;
                weights[next] = weights[next] - min;
                count = count + min;
            } else if (next == index && weights[index] >= 2) {
                int c = weights[index] / 2;
                count = count + c;
                weights[index] = weights[index] - 2 * c;
            }
        }
        return count;
    }
}

// Runtime 17 ms Beats 98.3%
// Memory 54.4 MB Beats 6.59%
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;                
            }
            right--;
            count++;
        }
        return count;
    }
}