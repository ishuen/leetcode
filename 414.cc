// 414. Third Maximum Number
// Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
//
// Example 1:
// Input: [3, 2, 1]
// Output: 1
//
// Explanation: The third maximum is 1.
//
// Example 2:
// Input: [1, 2]
// Output: 2
// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//
// Example 3:
// Input: [2, 2, 3, 1]
// Output: 1
// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.

// 4 ms, faster than 98.44%
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) return -INFINITY;
        if (len == 1) return nums[0];
        if (len == 2) return max(nums[0], nums[1]);
        int max1 = nums[0];
        int max2 = max1;
        int max3 = max1;
        int j = 1;
        while (j < len) {
            if (nums[j] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[j];
            } else if (nums[j] < max1 && max2 < nums[j]) {
                max3 = max2;
                max2 = nums[j];
            } else if (nums[j] < max1 && max2 == max1){
                max2 = nums[j];
                max3 = max2;
            } else if (nums[j] < max2 && (max3 == max2 || max3 < nums[j])) {
                max3 = nums[j];
            }
            j++;
        }
        if (max2 == max3 || max1 == max2) return max1;
        return max3;
    }
};