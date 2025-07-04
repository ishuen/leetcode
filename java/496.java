// 496. Next Greater Element I
// You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
// The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//
// Example 1:
//
// Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
// Output: [-1,3,-1]
// Explanation:
//     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//     For number 1 in the first array, the next greater number for it in the second array is 3.
//     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
// Example 2:
//
// Input: nums1 = [2,4], nums2 = [1,2,3,4].
// Output: [3,-1]
// Explanation:
//     For number 2 in the first array, the next greater number for it in the second array is 3.
//     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
// Note:
//
// All elements in nums1 and nums2 are unique.
// The length of both nums1 and nums2 would not exceed 1000.

// Runtime: 8 ms, faster than 13.22% of Java online submissions for Next Greater Element I.
// Memory Usage: 39.6 MB, less than 7.41% of Java online submissions for Next Greater Element I.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        boolean found = false;
        for (int i = 0; i< len1; i++) {
            int index = 0;
            for (int k = 0; k < len2; k++) {
                if (nums2[k] == nums1[i]) {
                    index = k;
                    break;
                }
            }
            found = false;
            for (int j = index + 1; j < len2; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            if (found == false) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}


// Runtime: 4 ms, faster than 73.80% of Java online submissions for Next Greater Element I.
// Memory Usage: 39.9 MB, less than 7.41% of Java online submissions for Next Greater Element I.
    
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        int j;
        boolean isNumberMatched = false;
        for (int i = 0; i < len1; i++) {
            int target = nums1[i];
            for (j = 0; j < len2; j++) {
                if (isNumberMatched == true) {
                    if (target < nums2[j]) {
                        ans[i] = nums2[j];
                        break;
                    }
                } else {
                    if (target == nums2[j]) {
                        isNumberMatched = true;
                    }
                }
            }
            if (j == len2) {
                ans[i] = -1;
            }
            isNumberMatched = false;
        }
        
        return ans;
    }
}