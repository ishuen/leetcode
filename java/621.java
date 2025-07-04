// 621. Task Scheduler
// Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
//
// However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
//
// Return the least number of units of times that the CPU will take to finish all the given tasks.
//
//
//
// Example 1:
//
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation:
// A -> B -> idle -> A -> B -> idle -> A -> B
// There is at least 2 units of time between any two same tasks.
// Example 2:
//
// Input: tasks = ["A","A","A","B","B","B"], n = 0
// Output: 6
// Explanation: On this case any permutation of size 6 would work since n = 0.
// ["A","A","A","B","B","B"]
// ["A","B","A","B","A","B"]
// ["B","B","B","A","A","A"]
// ...
// And so on.
// Example 3:
//
// Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
// Output: 16
// Explanation:
// One possible solution is
// A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
//
//
// Constraints:
//
// 1 <= task.length <= 104
// tasks[i] is upper-case English letter.
// The integer n is in the range [0, 100].
//
// Runtime: 3 ms, faster than 61.13% of Java online submissions for Task Scheduler.
// Memory Usage: 40.7 MB, less than 23.02% of Java online submissions for Task Scheduler.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int max = 0;
        int maxCounter = 0;
        char[] taskArr = new char[26];
        for (char task: tasks) {
            taskArr[task - 'A']++;
            if (taskArr[task - 'A'] == max) maxCounter++;
            else if (taskArr[task - 'A'] > max) {
                max = taskArr[task - 'A'];
                maxCounter = 1;
            }
        }
        return tasks.length + Math.max((max - 1) * (n - maxCounter + 1) - tasks.length + maxCounter * max, 0);
    }
}

// n = 0 -> time = task.length
// ["A","A","A","B","B","B"] n =2
// A: 3
// B: 3
// A x x A x x A 
// A B x A B x A B

// length = tasks.length + idles
//        = tasks.length + (slots - non max occurance tasks or 0)
// max occurance * (n + 1)