// 1679. Max Number of K-Sum Pairs
//
// You are given an integer array nums and an integer k.
//
// In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
//
// Return the maximum number of operations you can perform on the array.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3,4], k = 5
// Output: 2
// Explanation: Starting with nums = [1,2,3,4]:
// - Remove numbers 1 and 4, then nums = [2,3]
// - Remove numbers 2 and 3, then nums = []
// There are no more pairs that sum up to 5, hence a total of 2 operations.
// Example 2:
//
// Input: nums = [3,1,3,4,3], k = 6
// Output: 1
// Explanation: Starting with nums = [3,1,3,4,3]:
// - Remove the first two 3's, then nums = [1,4,3]
// There are no more pairs that sum up to 6, hence a total of 1 operation.
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// 1 <= k <= 109
//
//
// Runtime 32 ms Beats 41.97% of users with Java
// Memory 57.83 MB Beats 13.61% of users with Java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> number = new HashMap<>();
        for (int num: nums) {
            number.put(num, number.getOrDefault(num, 0) + 1);
        }
        Iterator it = number.keySet().iterator();
        int count = 0;
        while(it.hasNext()) {
            int key = (int)it.next();
            int occur = number.get(key);
            if (number.get(key) == 0) continue;
            if (k - key == key) {
                count = count + occur / 2;
                number.put(key, occur % 2);
            } else {
                int second = number.getOrDefault(k - key, 0);
                if (second == 0) continue;
                int min = Math.min(occur, second);
                count = count + min;
                number.put(key, occur - min);
                number.put(k - key, second - min);
            }
        }
        return count;
    }
}


// Runtime 18 ms Beats 93.95% of users with Java
// Memory 55.02 MB Beats 71.88% of users with Java
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}