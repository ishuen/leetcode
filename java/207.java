// 207. Course Schedule
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.
//
// Example 1:
//
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:
//
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take.
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
// Constraints:
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.
//
// Runtime: 19 ms, faster than 15.50% of Java online submissions for Course Schedule.
// Memory Usage: 39.6 MB, less than 62.49% of Java online submissions for Course Schedule.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] pair: prerequisites){
            indegree[pair[1]]++;
        }
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            for(int[] pair: prerequisites){
                if(pair[0] == course){
                    indegree[pair[1]]--;
                    if (indegree[pair[1]] == 0) {
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}


// cycles?
// prerequistes include the number outside of the courses we consider?

// queue -> traverse from the courses not being a prerequisite of others
// remove the node from the graph -- reduce the incoming connection of the effected nodes