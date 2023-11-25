// 1424. Diagonal Traverse II
//
// Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
//
//
//
// Example 1:
//
//
// Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,4,2,7,5,3,8,6,9]
// Example 2:
//
//
// Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
// Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 1 <= nums[i].length <= 105
// 1 <= sum(nums[i].length) <= 105
// 1 <= nums[i][j] <= 105
//
// Runtime 17 ms Beats 98.30% of users with Java
// Memory 61.91 MB Beats 93.11% of users with Java
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> traverseList = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int group = i + j;
                if (group >= traverseList.size()) {
                    traverseList.add(new ArrayList<>());
                }
                traverseList.get(group).add(nums.get(i).get(j));
                size++;
            }
        }
        int[] output = new int[size];
        int index = 0;
        for (int i = 0; i < traverseList.size(); i++) {
            List<Integer> list = traverseList.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                output[index] = list.get(j);
                index++;
            }
        }
        return output;
    }
}

/*
(0, 0)
(1, 0), (0, 1) i + j = 1
(2, 0), (1, 1), (0, 2) i + j = 2
*/