// 2140. Solving Questions With Brainpower
// You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
//
// The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
//
// For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
// If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
// If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
// Return the maximum points you can earn for the exam.
//
//
//
// Example 1:
//
// Input: questions = [[3,2],[4,3],[4,4],[2,5]]
// Output: 5
// Explanation: The maximum points can be earned by solving questions 0 and 3.
// - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
// - Unable to solve questions 1 and 2
// - Solve question 3: Earn 2 points
// Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
// Example 2:
//
// Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
// Output: 7
// Explanation: The maximum points can be earned by solving questions 1 and 4.
// - Skip question 0
// - Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
// - Unable to solve questions 2 and 3
// - Solve question 4: Earn 5 points
// Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
//
//
// Constraints:
//
// 1 <= questions.length <= 105
// questions[i].length == 2
// 1 <= pointsi, brainpoweri <= 105
//
// Runtime 17 ms Beats 53.97%
// Memory 113 MB Beats 37.57%
class Solution {
    public long mostPoints(int[][] questions) {
        long[] memory = new long[questions.length];
        return getPoints(0, questions, memory);
    }

    private long getPoints(int index, int[][] questions, long[] memory) {
        if (index >= questions.length) return 0;
        if (memory[index] != 0) return memory[index];
        long max = 0;
        max = Math.max(questions[index][0] + getPoints(index + questions[index][1] + 1, questions, memory), getPoints(index + 1, questions, memory));
        memory[index] = max;
        return max;
    }
}

// Runtime 6 ms Beats 88.36%
// Memory 93.2 MB Beats 94.18%
class Solution {
    public long mostPoints(int[][] questions) {
        long[] memory = new long[questions.length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            int next = Math.min(i + questions[i][1] + 1, questions.length);
            memory[i] = Math.max(questions[i][0] + memory[next], memory[i + 1]);
        }
        return memory[0];
    }
}