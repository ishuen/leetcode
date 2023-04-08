// 841. Keys and Rooms
// There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
//
// When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
//
// Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
//
//
//
// Example 1:
//
// Input: rooms = [[1],[2],[3],[]]
// Output: true
// Explanation:
// We visit room 0 and pick up key 1.
// We then visit room 1 and pick up key 2.
// We then visit room 2 and pick up key 3.
// We then visit room 3.
// Since we were able to visit every room, we return true.
// Example 2:
//
// Input: rooms = [[1,3],[3,0,1],[2],[0]]
// Output: false
// Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
//
//
// Constraints:
//
// n == rooms.length
// 2 <= n <= 1000
// 0 <= rooms[i].length <= 1000
// 1 <= sum(rooms[i].length) <= 3000
// 0 <= rooms[i][j] < n
// All the values of rooms[i] are unique.
//
// Runtime: 1 ms, faster than 82.66% of Java online submissions for Keys and Rooms.
// Memory Usage: 38.8 MB, less than 69.75% of Java online submissions for Keys and Rooms.
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            visited[cur] = true;
            List<Integer> keyList = rooms.get(cur);
            for (int key: keyList) {
                if (visited[key] == false) stack.push(key);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) return false;
        }
        return true;
    }
}

// Runtime 3 ms Beats 24.68%
// Memory 42.7 MB Beats 30.29%
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> roomToVisit = new Stack<>();
        roomToVisit.push(0);
        Set<Integer> visited = new HashSet<>();
        while(!roomToVisit.isEmpty()) {
            Integer cur = roomToVisit.pop();
            visited.add(cur);
            List<Integer> keys = rooms.get(cur);
            for (Integer key: keys) {
                if (!visited.contains(key)) {
                    roomToVisit.push(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}