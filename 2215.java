// 2215. Find the Difference of Two Arrays
//
// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
//
// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note that the integers in the lists may be returned in any order.
//
//
//
// Example 1:
//
// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
// Example 2:
//
// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
//
//
// Constraints:
//
// 1 <= nums1.length, nums2.length <= 1000
// -1000 <= nums1[i], nums2[i] <= 1000
//
// Runtime 14 ms Beats 27.38% of users with Java
// Memory 44.53 MB Beats 56.64% of users with Java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums2) {
            set2.add(num);
        }
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        set1.removeAll(intersection);
        set2.removeAll(intersection);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer num: set1) {
            list1.add(num);
        }
        for (Integer num: set2) {
            list2.add(num);
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}


// Runtime 9 ms Beats 91.65% of users with Java
// Memory 45.02 MB Beats 7.61% of users with Java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums2) {
            set2.add(num);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer num: set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        for (Integer num: set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}