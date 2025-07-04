// 870. Advantage Shuffle
//
// You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
//
// Return any permutation of nums1 that maximizes its advantage with respect to nums2.
//
//
//
// Example 1:
//
// Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
// Output: [2,11,7,15]
// Example 2:
//
// Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
// Output: [24,32,8,12]
//
//
// Constraints:
//
// 1 <= nums1.length <= 105
// nums2.length == nums1.length
// 0 <= nums1[i], nums2[i] <= 109
//
// Runtime 222 ms Beats 8.53%
// Memory 56.9 MB Beats 86.73%
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer key = map.higherKey(nums2[i]);
            if (key == null) {
                key = map.firstKey();
            }
            int count = map.get(key);
            if (count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }
            ans[i] = key;
        }
        return ans;
    }
}

// Runtime 78 ms Beats 75.36%
// Memory 58.2 MB Beats 79.15%
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[][] map2 = new int[nums2.length][2];
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums2.length; i++) {
            map2[i][0] = nums2[i];
            map2[i][1] = i;
        }
        Arrays.sort(map2, (a, b) -> a[0] - b[0]);
        int index1 = nums1.length - 1;
        int index2 = nums2.length - 1;
        while(index1 >= 0 && index2 >= 0) {
            while(index2 > 0 && nums1[index1] <= map2[index2][0]) {
                index2--;
            }
            ans[map2[index2][1]] = nums1[index1];
            index1--;
            index2--;
        }
        int ansIndex = nums2.length - 1;
        while (index1 >= 0) {
            if (ans[ansIndex] == -1) {
                ans[ansIndex] = nums1[index1];
                index1--;
            }
            ansIndex--;
        }
        return ans;
    }
}