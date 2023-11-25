// 1094. Car Pooling
//
// There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
//
// You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
//
// Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
//
//
//
// Example 1:
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 4
// Output: false
// Example 2:
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 5
// Output: true
//
//
// Constraints:
//
// 1 <= trips.length <= 1000
// trips[i].length == 3
// 1 <= numPassengersi <= 100
// 0 <= fromi < toi <= 1000
// 1 <= capacity <= 105
//
// Runtime 6 ms Beats 50.24% of users with Java
// Memory 43.14 MB Beats 53.01% of users with Java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Change> pq = new PriorityQueue<>((a, b) -> a.position - b.position);
        for (int[] trip: trips) {
            pq.add(new Change(trip[1], trip[0]));
            pq.add(new Change(trip[2], -1 * trip[0]));
        }
        int total = 0;
        while (!pq.isEmpty()) {
            Change cur = pq.remove();
            while (!pq.isEmpty() && pq.peek().position == cur.position) {
                Change top = pq.remove();
                cur.passenger = cur.passenger + top.passenger;
            }
            total = total + cur.passenger;
            if (total > capacity) return false;
        }
        return true;
    }

    private class Change {
        int position = 0;
        int passenger = 0;
        Change(int position, int passenger) {
            this.position = position;
            this.passenger = passenger;
        }
    }
}
