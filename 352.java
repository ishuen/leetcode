// 352. Data Stream as Disjoint Intervals
// Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
//
// Implement the SummaryRanges class:
//
// SummaryRanges() Initializes the object with an empty stream.
// void addNum(int val) Adds the integer val to the stream.
// int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi].
//
//
// Example 1:
//
// Input
// ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
// [[], [1], [], [3], [], [7], [], [2], [], [6], []]
// Output
// [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
// Explanation
// SummaryRanges summaryRanges = new SummaryRanges();
// summaryRanges.addNum(1);      // arr = [1]
// summaryRanges.getIntervals(); // return [[1, 1]]
// summaryRanges.addNum(3);      // arr = [1, 3]
// summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
// summaryRanges.addNum(7);      // arr = [1, 3, 7]
// summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
// summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
// summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
// summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
// summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
//
//
// Constraints:
//
// 0 <= val <= 104
// At most 3 * 104 calls will be made to addNum and getIntervals.
//
//
// Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
//
// Runtime: 127 ms, faster than 11.55% of Java online submissions for Data Stream as Disjoint Intervals.
// Memory Usage: 86.9 MB, less than 5.61% of Java online submissions for Data Stream as Disjoint Intervals.
class SummaryRanges {

    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        Integer ceilingKey = map.ceilingKey(val);
        Integer floorKey = map.floorKey(val);
        if (ceilingKey == null && floorKey == null) {
            map.put(val, val);
        } else if (ceilingKey != null && floorKey != null && ceilingKey == val + 1 && map.get(floorKey) + 1 == val) {
            map.put(floorKey, map.get(ceilingKey));
            map.remove(ceilingKey);
        } else if (ceilingKey != null && ceilingKey == val + 1) {
            map.put(val, map.get(ceilingKey));
            map.remove(ceilingKey);
        } else if (floorKey != null && map.get(floorKey) + 1 >= val) {
            map.put(floorKey, Math.max(map.get(floorKey), val));
        } else {
            map.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        Iterator it = map.entrySet().iterator();
        List<int[]> ans = new ArrayList<>();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
            ans.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[][] fin = new int[ans.size()][2];
        ans.toArray(fin);
        return fin;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */

// empty map or independent entry -> add new entry <num, num>
// num is included in the exisiting pair -> do nothing
// num = key - 1 && another value + 1 -> update and remove
// num is key - 1 -> add new entry and remove old
// num is value + 1 -> update entry