
// 349. Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

// Runtime: 5 ms, faster than 47.26% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 44.2 MB, less than 21.24% of Java online submissions for Intersection of Two Arrays.
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] ans = new int[set2.size()];
        Iterator it = set2.iterator();
        int i = 0;
        while(it.hasNext()) {
            ans[i] = (int)it.next();
            i++;
        }
        return ans;
    }
}