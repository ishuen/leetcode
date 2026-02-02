// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

// Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

 

// Example 1:

// Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
// Output: 3
// Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
// Example 2:

// Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
// Output: 6
// Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 

// Constraints:

// 1 <= arr.length <= 105
// 1 <= arr[i] <= 104
// 1 <= k <= arr.length
// 0 <= threshold <= 104

// Runtime 0 ms Beats 100.00%
// Memory 10.02 MB Beats 33.73%
func numOfSubarrays(arr []int, k int, threshold int) int {
    sum := 0
    for i := range k {
        sum += arr[i]
    }
    count := 0
    if sum / k >= threshold {
        count = 1
    }
    for i := k; i < len(arr); i++ {
        sum = sum + arr[i] - arr[i - k]
        if sum / k >= threshold {
            count++
        }
    }
    return count
}
