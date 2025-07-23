// 207. Course Schedule

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

// Constraints:

// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

// Runtime 9 ms Beats 16.86%
// Memory 7.01 MB Beats 99.88%
func canFinish(numCourses int, prerequisites [][]int) bool {
    dependencies := make([]int, numCourses)
    for i := 0; i < len(prerequisites); i++ {
        dependencies[prerequisites[i][0]]++
    }
    queue := []int{}
    for course, dependency := range dependencies {
        if dependency == 0 {
            queue = append(queue, course)
        }
    }
    count := 0
    for ; len(queue) > 0; {
        course := queue[0]
        queue = queue[1:]
        count++
        for i := 0; i < len(prerequisites); i++ {
            if prerequisites[i][1] == course {
                dependencies[prerequisites[i][0]]--
                if dependencies[prerequisites[i][0]] == 0 {
                    queue = append(queue, prerequisites[i][0])
                }
            }
        }
    }
    return count >= numCourses
}


// Runtime 1 ms Beats 75.83%
// Memory 8.16 MB Beats 59.08%
func canFinish(numCourses int, prerequisites [][]int) bool {
    dependencies := make([]int, numCourses)
    blockers := make(map[int][]int, numCourses)
    for i := 0; i < numCourses; i++ {
        blockers[i] = []int{}
    }
    for i := 0; i < len(prerequisites); i++ {
        dependencies[prerequisites[i][0]]++
        blockers[prerequisites[i][1]] = append(blockers[prerequisites[i][1]], prerequisites[i][0])
    }
    queue := []int{}
    for course, dependency := range dependencies {
        if dependency == 0 {
            queue = append(queue, course)
        }
    }
    count := 0
    for ; len(queue) > 0; {
        course := queue[0]
        queue = queue[1:]
        count++
        for _, unblocked := range blockers[course] {
            dependencies[unblocked]--
            if dependencies[unblocked] == 0 {
                queue = append(queue, unblocked)
            }
        }
    }
    return count >= numCourses
}