// 1310. XOR Queries of a Subarray
//
// You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
//
// For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
//
// Return an array answer where answer[i] is the answer to the ith query.
//
//
//
// Example 1:
//
// Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
// Output: [2,7,14,8]
// Explanation:
// The binary representation of the elements in the array are:
// 1 = 0001
// 3 = 0011
// 4 = 0100
// 8 = 1000
// The XOR values for queries are:
// [0,1] = 1 xor 3 = 2
// [1,2] = 3 xor 4 = 7
// [0,3] = 1 xor 3 xor 4 xor 8 = 14
// [3,3] = 8
// Example 2:
//
// Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
// Output: [8,0,4,4]
//
//
// Constraints:
//
// 1 <= arr.length, queries.length <= 3 * 104
// 1 <= arr[i] <= 109
// queries[i].length == 2
// 0 <= lefti <= righti < arr.length
//
// Runtime 569ms Beats 12.04%of users with Java
// Memory 55.68MB Beats 8.95%of users with Java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer[], Integer> map = new HashMap<>();
        int index = 0;
        for (int[] query: queries) {
            Integer[] key = new Integer[] {query[0], query[1]};
            Integer v = map.getOrDefault(key, null);
            if (v != null) {
                ans[index] = v;
                continue;
            }
            v = calculate(query, arr);
            map.put(key, v);
            ans[index] = v;
            index++;
        }
        return ans;
    }

    private int calculate(int[] query, int[] arr) {
        int sum = 0;
        for (int i = query[0]; i <= query[1]; i++) {
            sum = sum ^ arr[i];
        }
        return sum;
    }
}


// Runtime 2ms Beats 95.99%of users with Java
// Memory 54.81MB Beats 43.52%of users with Java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefixXOR = new int[arr.length];
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
            prefixXOR[i] = xor;
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                ans[i] =  prefixXOR[queries[i][1]]; 
            } else {
                ans[i] = prefixXOR[queries[i][1]] ^ prefixXOR[queries[i][0] - 1];
            }
            
        }
        return ans;
    }
}