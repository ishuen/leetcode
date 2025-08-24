// 373. Find K Pairs with Smallest Sums

// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

// Define a pair (u, v) which consists of one element from the first array and one element from the second array.

// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 

// Example 1:

// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:

// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 105
// -109 <= nums1[i], nums2[i] <= 109
// nums1 and nums2 both are sorted in non-decreasing order.
// 1 <= k <= 104
// k <= nums1.length * nums2.length

// Runtime 80 ms Beats 23.53%
// Memory 10.73 MB Beats 95.80%
import "container/heap"
type Pair struct {
    Num1 int
    Num2 int
    Sum int
}
type MinHeap []Pair
func (m MinHeap) Len() int {
    return len(m)
}
func (m MinHeap) Less(i, j int) bool {
    return m[i].Sum > m[j].Sum
}
func (m MinHeap) Swap(i, j int) {
    m[i], m[j] = m[j], m[i]
}
func (m *MinHeap) Push(x any) {
    *m = append(*m, x.(Pair))
}
func (m *MinHeap) Pop() any {
    original := *m
    last := len(original) - 1
    toPop := original[last]
    *m = original[:last]
    return toPop
}
func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
    minHeap := &MinHeap{}
    for _, num1 := range nums1 {
        for _, num2 := range nums2 {
            sum := num1 + num2
            temp := Pair{
                    Num1: num1,
                    Num2: num2,
                    Sum: sum,
                }
            if minHeap.Len() < k {
                heap.Push(minHeap, temp)
            } else if sum < (*minHeap)[0].Sum {
                heap.Pop(minHeap)
                heap.Push(minHeap, temp)
            } else {
                break
            }
        }
    }
    output := [][]int{}
    for i := 0; i < k; i++ {
        cur := heap.Pop(minHeap).(Pair)
        output = append(output, []int{cur.Num1, cur.Num2})
    }
    return output
}

// Runtime 33 ms Beats 72.27%
// Memory 13.05 MB Beats 50.42%
import "container/heap"
type Pair struct {
    Num1 int
    Num2 int
    NextIndex int
    Sum int
}
type MinHeap []Pair
func (m MinHeap) Len() int {
    return len(m)
}
func (m MinHeap) Less(i, j int) bool {
    return m[i].Sum < m[j].Sum
}
func (m MinHeap) Swap(i, j int) {
    m[i], m[j] = m[j], m[i]
}
func (m *MinHeap) Push(x any) {
    *m = append(*m, x.(Pair))
}
func (m *MinHeap) Pop() any {
    original := *m
    last := len(original) - 1
    toPop := original[last]
    *m = original[:last]
    return toPop
}
func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
    minHeap := &MinHeap{}
    for _, num1 := range nums1 {
        if minHeap.Len() == k {
            break
        }
        sum := num1 + nums2[0]
        heap.Push(minHeap, Pair{
            Num1: num1,
            Num2: nums2[0],
            NextIndex: 1,
            Sum: sum,
        })
    }
    output := [][]int{}
    for i := 0; i < k; i++ {
        top := heap.Pop(minHeap).(Pair)
        output = append(output, []int{top.Num1, top.Num2})
        if (top.NextIndex < len(nums2)) {
            sum := top.Num1 + nums2[top.NextIndex]
            heap.Push(minHeap, Pair{
                Num1: top.Num1,
                Num2: nums2[top.NextIndex],
                NextIndex: top.NextIndex + 1,
                Sum: sum,
            })
        }
    }
    return output
}