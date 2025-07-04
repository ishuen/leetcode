// 659. Split Array into Consecutive Subsequences
// You are given an integer array nums that is sorted in non-decreasing order.
//
// Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:
//
// Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
// All subsequences have a length of 3 or more.
// Return true if you can split nums according to the above conditions, or false otherwise.
//
// A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
//
//
//
// Example 1:
//
// Input: nums = [1,2,3,3,4,5]
// Output: true
// Explanation: nums can be split into the following subsequences:
// [1,2,3,3,4,5] --> 1, 2, 3
// [1,2,3,3,4,5] --> 3, 4, 5
// Example 2:
//
// Input: nums = [1,2,3,3,4,4,5,5]
// Output: true
// Explanation: nums can be split into the following subsequences:
// [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
// [1,2,3,3,4,4,5,5] --> 3, 4, 5
// Example 3:
//
// Input: nums = [1,2,3,4,4,5]
// Output: false
// Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
// nums is sorted in non-decreasing order.
//
// Runtime: 13 ms, faster than 78.88% of Java online submissions for Split Array into Consecutive Subsequences.
// Memory Usage: 39.8 MB, less than 91.24% of Java online submissions for Split Array into Consecutive Subsequences.
class Solution {
    public boolean isPossible(int[] nums) {
        Queue<Interval> queue = new PriorityQueue<>((Interval a, Interval b) -> {
            if (a.end == b.end) {
                return Integer.compare(a.length, b.length);
            }
            return Integer.compare(a.end, b.end);
        }); 
        for (int num : nums) {
            while (!queue.isEmpty() && queue.peek().end + 1 < num) {
                if (queue.poll().length < 3)
                    return false;
            }
            if (queue.isEmpty() || queue.peek().end == num) {
                queue.add(new Interval(num, num));
            } else {
                queue.add(new Interval(queue.poll().start, num));
            }
        } 
        while (!queue.isEmpty()) {
            if (queue.poll().length < 3) return false;
        }
        
        return true;
    }
    
    class Interval {
        int start;
        int end;
        int length;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            length = end - start + 1;
        }
    }
}


