// 215. Kth Largest Element in an Array

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

 

// Example 1:

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:

// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 

// Constraints:

// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104

// Runtime 34 ms Beats 55.39%
// Memory 17.08 MB Beats 5.01%

import (
    "container/heap"
)
type MinHeap []int
func (m MinHeap) Len() int {
    return len(m)
}
func (m MinHeap) Less(i, j int) bool {
    return m[i] < m[j]
}
func (m MinHeap) Swap (i, j int) {
    m[i], m[j] = m[j], m[i]
}
func (m *MinHeap) Push(x any) {
    *m = append(*m, x.(int))
}
func (m *MinHeap) Pop() any {
    original := *m
    last := len(original) - 1
    min := original[last]
    *m = original[:last]
    return min
}

func findKthLargest(nums []int, k int) int {
    minHeap := &MinHeap{}
    for _, val := range nums {
        if minHeap.Len() < k {
            heap.Push(minHeap, val)
        } else if val > (*minHeap)[0] {
            heap.Pop(minHeap)
            heap.Push(minHeap, val)
        }
        
    }
    return heap.Pop(minHeap).(int)
}