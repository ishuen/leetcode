// 1090. Largest Values From Labels
//
// There is a set of n items. You are given two integer arrays values and labels where the value and the label of the ith element are values[i] and labels[i] respectively. You are also given two integers numWanted and useLimit.
//
// Choose a subset s of the n elements such that:
//
// The size of the subset s is less than or equal to numWanted.
// There are at most useLimit items with the same label in s.
// The score of a subset is the sum of the values in the subset.
//
// Return the maximum score of a subset s.
//
//
//
// Example 1:
//
// Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
// Output: 9
// Explanation: The subset chosen is the first, third, and fifth items.
// Example 2:
//
// Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
// Output: 12
// Explanation: The subset chosen is the first, second, and third items.
// Example 3:
//
// Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
// Output: 16
// Explanation: The subset chosen is the first and fourth items.
//
//
// Constraints:
//
// n == values.length == labels.length
// 1 <= n <= 2 * 104
// 0 <= values[i], labels[i] <= 2 * 104
// 1 <= numWanted, useLimit <= n
//
// Runtime 17ms Beats 75.89%of users with Java
// Memory 46.89MB Beats 19.86%of users with Java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int ans = 0;
        Map<Integer, Integer> labelMap = new HashMap<>();
        Value[] vArr = new Value[values.length];
        for (int i = 0; i < vArr.length; i++) {
            vArr[i] = new Value(values[i], labels[i]);
        }
        Arrays.sort(vArr, (a, b) -> b.value - a.value);
        int count = 0;
        for (int i = 0; i < vArr.length; i++) {
            int usage = labelMap.getOrDefault(vArr[i].label, 0);
            if (usage < useLimit) {
                ans = ans + vArr[i].value;
                labelMap.put(vArr[i].label, usage + 1);
                count++;
                if (count == numWanted) break;
            }
        }
        return ans;
    }

    class Value {
        int value;
        int label;
        public Value(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}

// Runtime 15ms Beats 95.04%of users with Java
// Memory 46.24MB Beats 57.45%of users with Java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int ans = 0;
        Map<Integer, Integer> labelMap = new HashMap<>();
        PriorityQueue<Value> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < values.length; i++) {
            pq.add(new Value(values[i], labels[i]));
        }
        int count = 0;
        while (pq.size() > 0) {
            Value top = pq.remove();
            int usage = labelMap.getOrDefault(top.label, 0);
            if (usage < useLimit) {
                ans = ans + top.value;
                labelMap.put(top.label, usage + 1);
                count++;
                if (count == numWanted) break;
            }
        }
        return ans;
    }

    class Value {
        int value;
        int label;
        public Value(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}