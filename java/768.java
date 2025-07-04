// 768. Max Chunks To Make Sorted II
// You are given an integer array arr.
//
// We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
//
// Return the largest number of chunks we can make to sort the array.
//
//
//
// Example 1:
//
// Input: arr = [5,4,3,2,1]
// Output: 1
// Explanation:
// Splitting into two or more chunks will not return the required result.
// For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
// Example 2:
//
// Input: arr = [2,1,3,4,4]
// Output: 4
// Explanation:
// We can split into two chunks, such as [2, 1], [3, 4, 4].
// However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
//
//
// Constraints:
//
// 1 <= arr.length <= 2000
// 0 <= arr[i] <= 108
//
// Runtime: 1 ms, faster than 76.94% of Java online submissions for Max Chunks To Make Sorted II.
// Memory Usage: 38.9 MB, less than 44.44% of Java online submissions for Max Chunks To Make Sorted II.
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];
        
        min[arr.length - 1] = arr[arr.length - 1];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min[arr.length - 1 - i] = Math.min(arr[arr.length - 1 - i], min[arr.length - i]);
            max[i] = Math.max(arr[i], max[i - 1]);
        }
        int count = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (min[i] >= max[i - 1]) count++;
        }
        return count + 1;
    }
}

// the min of i-th chunk > the max of i - 1 - th chunk