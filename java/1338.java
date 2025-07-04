// 1338. Reduce Array Size to The Half
// Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
//
// Return the minimum size of the set so that at least half of the integers of the array are removed.
//
//
//
// Example 1:
//
// Input: arr = [3,3,3,3,5,5,5,2,2,7]
// Output: 2
// Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
// Possible sets of size 2 are {3,5},{3,2},{5,2}.
// Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
// Example 2:
//
// Input: arr = [7,7,7,7,7,7]
// Output: 1
// Explanation: The only possible set you can choose is {7}. This will make the new array empty.
// Example 3:
//
// Input: arr = [1,9]
// Output: 1
// Example 4:
//
// Input: arr = [1000,1000,3,7]
// Output: 1
// Example 5:
//
// Input: arr = [1,2,3,4,5,6,7,8,9,10]
// Output: 5
//
//
// Constraints:
//
// 1 <= arr.length <= 10^5
// arr.length is even.
// 1 <= arr[i] <= 10^5
//
// Runtime: 36 ms, faster than 69.69% of Java online submissions for Reduce Array Size to The Half.
// Memory Usage: 48.7 MB, less than 81.99% of Java online submissions for Reduce Array Size to The Half.
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element: arr) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        Comparator<Map.Entry<Integer, Integer>> comp = (a, b) -> b.getValue() - a.getValue();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(comp);
        int count = 0;
        int index = 0;
        while (count * 2 < arr.length) {
            count = count + entries.get(index).getValue();
            index++;
        } 
        return index;
    }
}

// Map key: arr element, value: freqency
// take entries and order by freqency
// selecting from the entry with highest freqency -> if total count > 1/2 -> return element count


// Runtime: 32 ms, faster than 80.53% of Java online submissions for Reduce Array Size to The Half.
// Memory Usage: 48.6 MB, less than 85.94% of Java online submissions for Reduce Array Size to The Half.
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element: arr) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        int[] counts = new int[frequencies.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            counts[i] = entry.getValue();
            i++;
        }
        Arrays.sort(counts);
        int count = 0;
        int index = 0;
        while (count * 2 < arr.length) {
            count = count + counts[counts.length - index - 1];
            index++;
        } 
        return index;
    }
}