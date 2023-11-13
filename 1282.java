// 1282. Group the People Given the Group Size They Belong To
//
// There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
//
// You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
//
// Return a list of groups such that each person i is in a group of size groupSizes[i].
//
// Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
//
//
//
// Example 1:
//
// Input: groupSizes = [3,3,3,3,3,1,3]
// Output: [[5],[0,1,2],[3,4,6]]
// Explanation:
// The first group is [5]. The size is 1, and groupSizes[5] = 1.
// The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
// The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
// Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
// Example 2:
//
// Input: groupSizes = [2,1,3,3,3,2]
// Output: [[1],[0,5],[2,3,4]]
//
//
// Constraints:
//
// groupSizes.length == n
// 1 <= n <= 500
// 1 <= groupSizes[i] <= n
//
// Runtime 8ms Beats 30.91%of users with Java
// Memory 44.53MB Beats 30.36%of users with Java
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> a.size - b.size);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            pq.add(new Person(i, groupSizes[i]));
        }
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Person first = pq.remove();
            list.add(first.index);
            for (int i = 0; i < first.size - 1; i++) {
                Person next = pq.remove();
                list.add(next.index);
            }
            output.add(list);
        }

        return output;
    }

    class Person {
        int index;
        int size;
        public Person(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }
}

// Runtime 8ms Beats 30.91%of users with Java
// Memory 44.76MB Beats 10.77%of users with Java
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> people = entry.getValue();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < people.size(); i++) {
                sub.add(people.get(i));
                if (sub.size() == entry.getKey()) {
                    output.add(sub);
                    sub = new ArrayList<>();
                }
            }
        }
        return output;
    }
}

// Runtime 4ms Beats 98.35%of users with Java
// Memory 44.73MB Beats 10.77%of users with Java
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 0) continue;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            for (int j = i + 1; j < groupSizes.length; j++) {
                if (list.size() == groupSizes[i]) {
                    break;
                }
                if (groupSizes[j] == groupSizes[i]) {
                    list.add(j);
                    groupSizes[j] = 0;
                }
            }
            output.add(list);
        }
        return output;
    }
}