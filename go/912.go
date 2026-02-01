// 912. Sort an Array

// Given an array of integers nums, sort the array in ascending order and return it.

// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of nums are not necessarily unique.
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -5 * 104 <= nums[i] <= 5 * 104

// Runtime 97 ms Beats 38.13%
// Memory 24.61 MB Beats 7.06%
func sortArray(nums []int) []int {
    if len(nums) == 1 {
        return nums
    }
    mid := len(nums) / 2
    arr1 := sortArray(nums[:mid])
    arr2 := sortArray(nums[mid:])
    list := []int{}
    index1 := 0
    index2 := 0
    for ; index1 < len(arr1) && index2 < len(arr2); {
        if arr1[index1] < arr2[index2] {
            list = append(list, arr1[index1])
            index1++
        } else {
            list = append(list, arr2[index2])
            index2++
        }
    }
    if index1 < len(arr1) {
        list = append(list, arr1[index1:]...)
    }
    if index2 < len(arr2) {
        list = append(list, arr2[index2:]...)
    }
    return list
}


// Runtime 15 ms Beats 83.90%
// Memory 11.04 MB Beats 58.76%
func sortArray(nums []int) []int {
    list := make([]int, 0, len(nums))
    records := make([]int, 100_001)
    for _, v := range nums {
        records[v + 50000]++
    }
    for i := range records {
        for j := 0; j < records[i]; j++ {
            list = append(list, i - 50000)
        } 
    }
    return list
}