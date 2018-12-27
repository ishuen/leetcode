// 15. 3Sum
// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

// 84 ms, faster than 71.70%
class Solution {
public:
  vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> ans;
    int length = nums.size();
    if (length < 3) return ans;
    sort(nums.begin(), nums.end());
    int max = length - 2;
    for (int i = 0; i < max; i++) {
      if (i > 0 && nums[i] == nums[i-1]) continue;
      int second = i+1;
      int last = length-1;
      while (second < last) {
        int temp = nums[i] + nums[second] + nums[last];
        if (temp < 0) {
          second++;
        } else if (temp > 0) {
          last--;
        } else {
          ans.push_back({nums[i], nums[second], nums[last]});
          second++;
          while(nums[second-1] == nums[second]) {
            second++;
          }
          last--;
          while(nums[last+1] == nums[last]) {
            last--;
          }
        }
      }
    }
    return ans;
  }
};