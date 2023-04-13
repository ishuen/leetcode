// 851. Loud and Rich
// There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.
//
// You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).
//
// Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.
//
//
//
// Example 1:
//
// Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
// Output: [5,5,2,5,4,5,6,7]
// Explanation:
// answer[0] = 5.
// Person 5 has more money than 3, which has more money than 1, which has more money than 0.
// The only person who is quieter (has lower quiet[x]) is person 7, but it is not clear if they have more money than person 0.
// answer[7] = 7.
// Among all people that definitely have equal to or more money than person 7 (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x]) is person 7.
// The other answers can be filled out with similar reasoning.
// Example 2:
//
// Input: richer = [], quiet = [0]
// Output: [0]
//
//
// Constraints:
//
// n == quiet.length
// 1 <= n <= 500
// 0 <= quiet[i] < n
// All the values of quiet are unique.
// 0 <= richer.length <= n * (n - 1) / 2
// 0 <= ai, bi < n
// ai != bi
// All the pairs of richer are unique.
// The observations in richer are all logically consistent.
	
// Runtime 28 ms Beats 13.29%
// Memory 52.9 MB Beats 17.72%
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> richerMap = new HashMap<>();
        for (int[] relationship : richer) {
            List<Integer> list = richerMap.getOrDefault(relationship[1], new ArrayList<>());
            list.add(relationship[0]);
            richerMap.put(relationship[1], list);
        }
        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);
        for (int person = 0; person < quiet.length; person++) {
            result[person] = findRicher(person, richerMap, quiet, result);
        }
        return result;
    }

    private int findRicher(int person, Map<Integer, List<Integer>> richerMap, int[] quiet, int[] result) {
        if (richerMap.get(person) == null) {
            return person;
        }
        Stack<Integer> toCheck = new Stack<>();
        toCheck.push(person);
        int min = quiet[person];
        int minIndex = person;
        while(!toCheck.isEmpty()) {
            int current = toCheck.pop();
            if (result[current] != -1) {
                if (quiet[result[current]] < min) {
                    min = quiet[result[current]];
                    minIndex = result[current];
                }
            } else {
                List<Integer> list = richerMap.get(current);
                if (list != null && list.size() > 0) {
                    for (int index : list) {
                        toCheck.push(index);
                        if (quiet[index] < min) {
                            min = quiet[index];
                            minIndex = index;
                        }
                    }
                }
            }
        }
        return minIndex;
    }
}

// Runtime 16 ms Beats 22.47%
// Memory 53.4 MB Beats 15.19%
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> richerMap = new HashMap<>();
        for (int[] relationship : richer) {
            List<Integer> list = richerMap.getOrDefault(relationship[1], new ArrayList<>());
            list.add(relationship[0]);
            richerMap.put(relationship[1], list);
        }
        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);
        for (int person = 0; person < quiet.length; person++) {
            result[person] = findRicher(person, richerMap, quiet, result);
        }
        return result;
    }

    private int findRicher(int person, Map<Integer, List<Integer>> richerMap, int[] quiet, int[] result) {
        if (result[person] != -1) return result[person];
        List<Integer> checkList = richerMap.get(person);
        if (checkList == null) {
            return person;
        }
        int min = quiet[person];
        int minIndex = person;
        for (int rich: checkList) {
            int temp = findRicher(rich, richerMap, quiet, result);
            if (quiet[temp] < min) {
                min = quiet[temp];
                minIndex = temp;
            }
        }
        return minIndex;
    }
}