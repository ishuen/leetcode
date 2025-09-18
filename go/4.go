// 4. Median of Two Sorted Arrays

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

// Runtime 0 ms Beats 100.00%
// Memory 6.50 MB Beats 98.49%
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    len1 := len(nums1)
    len2 := len(nums2)
    if len1 > len2 {
        return findMedianSortedArrays(nums2, nums1)
    }
    if len1 == 0 {
        return float64(nums2[(len2 - 1)/2] + nums2[len2/2]) / 2
    }
    length := len1 + len2
    left := 0
    right := len1
    for ; left <= right; {
        mid1 := (left + right) / 2
        mid2 := (length / 2) - mid1
        l1, l2 := math.MinInt, math.MinInt
        r1, r2 := math.MaxInt, math.MaxInt
        if mid1 > 0 {
            l1 = nums1[mid1 - 1]
        }
        if mid2 > 0 {
            l2 = nums2[mid2 - 1]
        }
        if mid1 < len1 {
            r1 = nums1[mid1]
        }
        if mid2 < len2 {
            r2 = nums2[mid2]
        }
        if l1 > r2 {
            right = mid1
        } else if l2 > r1 {
            left = mid1 + 1
        } else {
            if length % 2 == 0 {
                return float64(max(l1, l2) + min(r1, r2)) / 2
            }
            return float64(min(r1, r2))
        }
    }
    return float64(0)
}
