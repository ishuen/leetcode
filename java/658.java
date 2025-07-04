// 658. Find K Closest Elements
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
// An integer a is closer to x than an integer b if:
//
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b
//
//
// Example 1:
//
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]
// Example 2:
//
// Input: arr = [1,2,3,4,5], k = 4, x = -1
// Output: [1,2,3,4]
//
//
// Constraints:
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 104
// arr is sorted in ascending order.
// -104 <= arr[i], x <= 104
//
// Runtime: 3 ms, faster than 97.08% of Java online submissions for Find K Closest Elements.
// Memory Usage: 40.8 MB, less than 59.39% of Java online submissions for Find K Closest Elements.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                end--;
            } else {
                start++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}

// start = 0; end = last index
// if array length from start to end > k
// remove larger diff
// if diff is the same, end--