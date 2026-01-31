// 2530. Maximal Score After Applying K Operations

// You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

// In one operation:

// choose an index i such that 0 <= i < nums.length,
// increase your score by nums[i], and
// replace nums[i] with ceil(nums[i] / 3).
// Return the maximum possible score you can attain after applying exactly k operations.

// The ceiling function ceil(val) is the least integer greater than or equal to val.

 

// Example 1:

// Input: nums = [10,10,10,10,10], k = 5
// Output: 50
// Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
// Example 2:

// Input: nums = [1,10,3,3,3], k = 3
// Output: 17
// Explanation: You can do the following operations:
// Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
// Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
// Operation 3: Select i = 2, so nums becomes [1,2,1,3,3]. Your score increases by 3.
// The final score is 10 + 4 + 3 = 17.
 

// Constraints:

// 1 <= nums.length, k <= 105
// 1 <= nums[i] <= 109

// Runtime 100 ms Beats 100.00%
// Memory 11.90 MB Beats 100.00%
type MaxHeap []int64
func (h MaxHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}
func (h MaxHeap) Len() int {
    return len(h)
}
func (h MaxHeap) Less(i, j int) bool {
    return h[i] > h[j]
}
func (h *MaxHeap) Push(x any) {
    *h = append(*h, x.(int64))
}
func (h *MaxHeap) Pop() any {
    old := *h
    x := old[len(old) - 1]
    *h = old[:len(old) - 1]
    return x
}
func maxKelements(nums []int, k int) int64 {
    pq := &MaxHeap{}
    heap.Init(pq)
    for _, v := range nums {
        heap.Push(pq, int64(v))
    }
    var score int64 = 0
    for i := 0; i < k; i++ {
        maxValue := heap.Pop(pq).(int64)
        score = score + maxValue
        maxValue = int64(math.Ceil(float64(maxValue) / 3))
        heap.Push(pq, maxValue)
    }
    return score
}