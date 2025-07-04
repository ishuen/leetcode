// 403. Frog Jump
// A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
// Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
//
// If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
//
//
//
// Example 1:
//
// Input: stones = [0,1,3,5,6,8,12,17]
// Output: true
// Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
// Example 2:
//
// Input: stones = [0,1,2,3,4,8,9,11]
// Output: false
// Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
//
//
// Constraints:
//
// 2 <= stones.length <= 2000
// 0 <= stones[i] <= 231 - 1
// stones[0] == 0
// stones is sorted in a strictly increasing order.
//
// Runtime: 67 ms, faster than 25.16% of Java online submissions for Frog Jump.
// Memory Usage: 46.6 MB, less than 43.89% of Java online submissions for Frog Jump.
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> jumps = new HashMap<>();
        int index = 0;
        jumps.put(0, new HashSet<>(Arrays.asList(new Integer[]{1})));
        while (index < stones.length - 1) {
            Set<Integer> list = jumps.get(stones[index]);
            if (list == null) {
                index++;
                continue;
            }
            for (int step: list) {
                if (step <= 0) continue;
                int next = getNext(index, step, stones);
                if (next == stones.length - 1) return true;
                if (next == -1) continue;
                Set<Integer> additionalList = jumps.getOrDefault(stones[next], new HashSet<>());
                additionalList.addAll(Arrays.asList(new Integer[]{step - 1, step, step + 1}));
                jumps.put(stones[next], additionalList);
            }
            index++;
        }
        return false;
    }
    private int getNext(int index, int step, int[] stones) {
        for (int i = index + 1; i < stones.length; i++) {
            if (stones[index] + step == stones[i]) return i;
            if (stones[index] + step < stones[i]) return -1;
        }
        return -1;
    }
}

// Runtime: 55 ms, faster than 32.70% of Java online submissions for Frog Jump.
// Memory Usage: 46.4 MB, less than 47.83% of Java online submissions for Frog Jump.
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> jumps = new HashMap<>();
        int index = 0;
        jumps.put(0, new HashSet<>(Arrays.asList(new Integer[]{1})));
        for (int i = 1; i < stones.length - 1; i++) {
            jumps.put(stones[i], new HashSet<>());
        }
        while (index < stones.length - 1) {
            for (int step: jumps.get(stones[index])) {
                if (step <= 0) continue;
                if (stones[index] + step == stones[stones.length - 1]) return true;
                Set<Integer> additionalList = jumps.get(stones[index] + step);
                if (additionalList == null) continue;
                additionalList.addAll(Arrays.asList(new Integer[]{step - 1, step, step + 1}));
                jumps.put(stones[index] + step, additionalList);
            }
            index++;
        }
        return false;
    }
}