// 4. Median of Two Sorted Arrays
// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// You may assume nums1 and nums2 cannot be both empty.
//
// Example 1:
//
// nums1 = [1, 3]
// nums2 = [2]
//
// The median is 2.0
// Example 2:
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// The median is (2 + 3)/2 = 2.5

// O(m+n)
// 48 ms, faster than 55.30%
class Solution {
public:
  double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int len1 = nums1.size();
    int len2 = nums2.size();
    int loc = len1 + len2;
    if (loc == 0) return 0;
    bool odd = false;
    if (loc %2 == 1) odd = true;
    loc = loc / 2;
    if (len1 == 0) {
      if (odd) return nums2[loc];
      else {
        double ans = (nums2[loc-1] + nums2[loc]);
        return ans/2;
      }
    } else if (len2 == 0) {
      if (odd) return nums1[loc];
      else {
        double ans = (nums1[loc-1] + nums1[loc]);
        return ans/2;
      }
    }
    int count = 0;
    int i = 0;
    int j = 0;
    vector<int> v;
    while (count <= loc) {
      if (j == len2 || (i < len1 && nums1[i] < nums2[j])) {
        v.push_back(nums1[i]);
        i++;
      } else if (i == len1 || (j < len2 && nums1[i] >= nums2[j])) {
        v.push_back(nums2[j]);
        j++;
      }
      count++;
    }
    if (odd == true) {
      return v.back();
    } else {
      double ans = (v[count-1] + v[count-2]);
      return ans/2;
    }
  }
};

// O(log(m+n))
// source: https://www.youtube.com/watch?v=LPFhl65R7ww
// cut1 + cut2 = (len1 + len2) / 2
// L1 <= R2, L2 <= R1
// 48 ms, faster than 55.30% ??
class Solution {
public:
  double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int len1 = nums1.size();
    int len2 = nums2.size();
    int len = len1 + len2;
    if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
    if (len1 == 0) return (nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2.0;
    int left = 0, right = len1;
    while (left <= right) {
      int cut1 = (left + right) / 2;
      int cut2 = len / 2 - cut1;
      int L1 = (cut1 == 0) ? INT_MIN : nums1[cut1-1];
      int L2 = (cut2 == 0) ? INT_MIN : nums2[cut2-1];
      int R1 = (cut1 == len1) ? INT_MAX : nums1[cut1];
      int R2 = (cut2 == len2) ? INT_MAX : nums2[cut2];

      if (L1 > R2) {   
        right = cut1;
      } else if (L2 > R1) {   
        left = cut1 + 1;
      } else {
        if (len % 2 == 0) {   
          return (max(L1, L2) + min(R1, R2)) / 2.0;
        } else {   
          return min(R1, R2);
        }
      }
    }
    return 0;
  }
};