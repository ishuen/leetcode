// 1054. Distant Barcodes
//
// In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].
//
// Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.
//
//
//
// Example 1:
//
// Input: barcodes = [1,1,1,2,2,2]
// Output: [2,1,2,1,2,1]
// Example 2:
//
// Input: barcodes = [1,1,1,1,2,2,3,3]
// Output: [1,3,1,3,1,2,1,2]
//
//
// Constraints:
//
// 1 <= barcodes.length <= 10000
// 1 <= barcodes[i] <= 10000
//
// Runtime 35 ms Beats 62.25%
// Memory 45.3 MB Beats 73.4%
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int barcode: barcodes) {
            counts.put(barcode, counts.getOrDefault(barcode, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(counts.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int[] arranged = new int[barcodes.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry: list) {
            for (int i = 0; i < entry.getValue(); i++) {
                arranged[index] = entry.getKey();
                index = index + 2;
                if (index >= arranged.length) {
                    index = 1;
                }
            }
        }
        return arranged;
    }
}