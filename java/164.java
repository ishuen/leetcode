// 164. Maximum Gap
// Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
//
// You must write an algorithm that runs in linear time and uses linear extra space.
//
//
//
// Example 1:
//
// Input: nums = [3,6,9,1]
// Output: 3
// Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
// Example 2:
//
// Input: nums = [10]
// Output: 0
// Explanation: The array contains less than 2 elements, therefore return 0.
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
//
// Runtime: 39 ms, faster than 5.16% of Java online submissions for Maximum Gap.
// Memory Usage: 53.2 MB, less than 5.55% of Java online submissions for Maximum Gap.
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int gap = Math.abs(nums[i] - nums[i+1]);
            if (gap > maxGap) maxGap = gap;
        }
        return maxGap;
    }
}

// Runtime: 15 ms, faster than 5.16% of Java online submissions for Maximum Gap.
// Memory Usage: 49.1 MB, less than 5.55% of Java online submissions for Maximum Gap.
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] < min) min = nums[i];
        }
        int[] bucketMin = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int index = (nums[i] - min) / gap;
            if (nums[i] < bucketMin[index]) bucketMin[index] = nums[i];
            if (nums[i] > bucketMax[index]) bucketMax[index] = nums[i];
        }
        int maxGap = 0;
        int prevMin = min;
        for (int i = 0; i < bucketMax.length; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            if (maxGap < bucketMin[i] - prevMin) maxGap = bucketMin[i] - prevMin;
            prevMin = bucketMax[i];
        }
        if (maxGap < max - prevMin) maxGap = max - prevMin;
        return maxGap;
    }
}

