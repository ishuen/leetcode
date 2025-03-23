// 2594. Minimum Time to Repair Cars
//
// You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
//
// You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
//
// Return the minimum time taken to repair all the cars.
//
// Note: All the mechanics can repair the cars simultaneously.
//
//
//
// Example 1:
//
// Input: ranks = [4,2,3,1], cars = 10
// Output: 16
// Explanation:
// - The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
// - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
// - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
// - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
// It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
// Example 2:
//
// Input: ranks = [5,1,8], cars = 6
// Output: 16
// Explanation:
// - The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
// - The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
// - The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
// It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
//
//
// Constraints:
//
// 1 <= ranks.length <= 105
// 1 <= ranks[i] <= 100
// 1 <= cars <= 106
//
// Runtime 9 ms Beats 92.20%
// Memory 56.20 MB Beats 57.26%
class Solution {
    public long repairCars(int[] ranks, int cars) {
        int[] rankCount = new int[101];
        Arrays.fill(rankCount, 0);
        int minRank = Integer.MAX_VALUE;
        for (int i = 0; i < ranks.length; i++) {
            rankCount[ranks[i]]++;
            minRank = Math.min(ranks[i], minRank);
        }
        long low = 1;
        long high = (long) minRank * cars * cars;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canFinish(mid, cars, rankCount)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canFinish(long time, int cars, int[] rankCount) {
        long count = 0;
        for (int i = 1; i < rankCount.length; i++) {
            count = count + (long) Math.floor(Math.sqrt(time / i)) * rankCount[i];
        }
        return count >= cars;
    }
}


/*
rank * numOfCar ^ 2 <= mid
numOfCar = floor (sqrt(mid / rank))
*/