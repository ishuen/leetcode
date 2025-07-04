// 210. Course Schedule II
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
//
//
//
// Example 1:
//
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
// Example 2:
//
// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
// Example 3:
//
// Input: numCourses = 1, prerequisites = []
// Output: [0]
//
//
// Constraints:
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// All the pairs [ai, bi] are distinct.
//
// Runtime: 7 ms, faster than 41.79% of Java online submissions for Course Schedule II.
// Memory Usage: 39.7 MB, less than 87.39% of Java online submissions for Course Schedule II.
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> incoming = new HashMap<>();
        int[] outgoing = new int[numCourses];
        int[] order = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            Set<Integer> set = incoming.getOrDefault(prerequisite[1], new HashSet<>());
            set.add(prerequisite[0]);
            incoming.put(prerequisite[1], set);
            outgoing[prerequisite[0]]++;
        }
        Queue<Integer> selectables = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (outgoing[i] == 0) selectables.add(i);
        }
        int index = 0;
        if (selectables.isEmpty()) return new int[] {};
        while(!selectables.isEmpty()) {
            int out = selectables.remove();
            order[index] = out;
            index++;
            Set<Integer> set = incoming.get(out);
            incoming.remove(out);
            if (set == null || set.isEmpty()) continue;
            Iterator in = set.iterator();
            while(in.hasNext()) {
                Integer toUpdate = (Integer) in.next();
                Set<Integer> inSet = incoming.get(toUpdate);
                outgoing[toUpdate]--;
                if (outgoing[toUpdate] == 0) selectables.add(toUpdate);
                if (inSet == null || inSet.isEmpty()) continue;
                inSet.remove(out);
                incoming.put(toUpdate, inSet);
            }
            
        }
        return index >= numCourses - 1 ? order : new int[]{};
    }
}
