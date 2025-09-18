// 295. Find Median from Data Stream

// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:

// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

// Example 1:

// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]

// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0
 

// Constraints:

// -105 <= num <= 105
// There will be at least one element in the data structure before calling findMedian.
// At most 5 * 104 calls will be made to addNum and findMedian.
 

// Follow up:

// If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
// If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

// Runtime 100 ms Beats 65.48%
// Memory 23.04 MB Beats 41.28%
type MedianFinder struct {
    right *MinHeap
    left *MaxHeap
}

type MinHeap []int
type MaxHeap []int

func (h MinHeap) Len() int {
    return len(h)
} 
func (h MaxHeap) Len() int {
    return len(h)
} 

func (h MinHeap) Less(i, j int) bool {
    return h[i] < h[j]
}

func (h MaxHeap) Less(i, j int) bool {
    return h[i] > h[j]
}

func (h MinHeap) Swap (i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h MaxHeap) Swap (i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h *MinHeap) Push(v any) {
    *h = append(*h, v.(int))
}

func (h *MaxHeap) Push(v any) {
    *h = append(*h, v.(int))
}

func (h *MinHeap) Pop() any {
    old := *h
    lastIndex := len(old) - 1
    last := old[lastIndex]
    *h = old[:lastIndex]
    return last
}

func (h *MaxHeap) Pop() any {
    old := *h
    lastIndex := len(old) - 1
    last := old[lastIndex]
    *h = old[:lastIndex]
    return last
}

func Constructor() MedianFinder {
    finder := MedianFinder{
        right : &MinHeap{},
        left : &MaxHeap{},
    }
    heap.Init(finder.right)
    heap.Init(finder.left)
    return finder
}


func (this *MedianFinder) AddNum(num int)  {
    if this.right.Len() == 0 || (*this.right)[0] <= num {
        heap.Push(this.right, num)
    } else {
        heap.Push(this.left, num)
    }
    if this.right.Len() < this.left.Len() {
        maxMin := heap.Pop(this.left).(int)
        heap.Push(this.right, maxMin)
    } else if this.right.Len() - this.left.Len() > 1 {
        minMax := heap.Pop(this.right).(int)
        heap.Push(this.left, minMax)
    }
}


func (this *MedianFinder) FindMedian() float64 {
    if this.left.Len() == this.right.Len() {
        return float64((*this.left)[0] + (*this.right)[0]) / 2.0
    }
    return float64((*this.right)[0])
}
