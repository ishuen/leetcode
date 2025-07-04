// 295. Find Median from Data Stream
// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
//
// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:
//
// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
//
//
// Example 1:
//
// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]
//
// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0
//
//
// Constraints:
//
// -105 <= num <= 105
// There will be at least one element in the data structure before calling findMedian.
// At most 5 * 104 calls will be made to addNum and findMedian.
//
// Runtime: 107 ms, faster than 15.58% of Java online submissions for Find Median from Data Stream.
// Memory Usage: 69.1 MB, less than 5.47% of Java online submissions for Find Median from Data Stream.
class MedianFinder {
    boolean isOdd;
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        isOdd = false;
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (small.size() == 0 || num < small.peek()) {
            small.add(num);
            if (small.size() > 0 && small.size() == large.size() + 2) {
                int temp = small.remove();
                large.add(temp);
            }
        } else {
            large.add(num);
            if (small.size() < large.size()) {
                int temp = large.remove();
                small.add(temp);
            }
        }
        isOdd = !isOdd;
    }
    
    public double findMedian() {
        if (isOdd) {
            return small.peek();
        } else {
            return (double) (small.peek() + large.peek()) / 2;
        }
    }
}