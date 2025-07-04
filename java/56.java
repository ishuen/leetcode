// 56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
// Example 1:
//
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:
//
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
// Constraints:
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Runtime: 10 ms, faster than 18.50% of Java online submissions for Merge Intervals.
// Memory Usage: 44.1 MB, less than 5.10% of Java online submissions for Merge Intervals.
class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Integer[]> nums = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            nums.add(new Integer[]{intervals[i][0], intervals[i][1]});
        }
        List<Integer[]> list = new ArrayList<>();
        while (!nums.isEmpty()) {
            Integer[] interval = nums.remove();
            while(!nums.isEmpty()) {
                Integer[] top = nums.peek();
                if (top[0] <= interval[1]) {
                    interval[1] = Math.max(interval[1], top[1]);
                    nums.remove();
                } else {
                    break;
                }
            }
            list.add(interval);
        }
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for (Integer[] interval : list) {
            ans[i][0] = interval[0];
            ans[i][1] = interval[1];
            i++;
        }
        return ans;
    }
}

// Runtime: 6 ms, faster than 56.88% of Java online submissions for Merge Intervals.
// Memory Usage: 41.7 MB, less than 59.20% of Java online submissions for Merge Intervals.
class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> nums = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            nums.add(intervals[i]);
        }
        List<int[]> list = new ArrayList<>();
        while (!nums.isEmpty()) {
            int[] interval = nums.remove();
            while(!nums.isEmpty()) {
                int[] top = nums.peek();
                if (top[0] <= interval[1]) {
                    interval[1] = Math.max(interval[1], top[1]);
                    nums.remove();
                } else {
                    break;
                }
            }
            list.add(interval);
        }
        return list.toArray(new int[list.size()][2]);
    }
}

