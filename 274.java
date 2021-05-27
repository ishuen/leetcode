// 274. H-Index
// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.
//
// According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
//
// If there are several possible values for h, the maximum one is taken as the h-index.
// Example 1:
// Input: citations = [3,0,6,1,5]
// Output: 3
// Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
// Example 2:
// Input: citations = [1,3,1]
// Output: 1
// Constraints:
// n == citations.length
// 1 <= n <= 5000
// 0 <= citations[i] <= 1000
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
// Memory Usage: 36.7 MB, less than 61.77% of Java online submissions for H-Index.
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1]; // buckets range: num of citations from 0 ~ n
        for(int citation : citations) {
            if(citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count = count + buckets[i]; // num of papers with citation > h
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}