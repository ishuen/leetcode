// 781. Rabbits in Forest
// There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
//
// Given the array answers, return the minimum number of rabbits that could be in the forest.
//
//
//
// Example 1:
//
// Input: answers = [1,1,2]
// Output: 5
// Explanation:
// The two rabbits that answered "1" could both be the same color, say red.
// The rabbit that answered "2" can't be red or the answers would be inconsistent.
// Say the rabbit that answered "2" was blue.
// Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
// The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
// Example 2:
//
// Input: answers = [10,10,10]
// Output: 11
//
//
// Constraints:
//
// 1 <= answers.length <= 1000
// 0 <= answers[i] < 1000
//
// Runtime 3 ms Beats 75.50%
// Memory 41.5 MB Beats 99.33%
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            counts.put(answers[i], counts.getOrDefault(answers[i], 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            if (answer != 0) {
                int set = count % (answer + 1) == 0 ? count / (answer + 1) : count / (answer + 1) + 1;
                sum = sum + set * (answer + 1);
            } else if (answer == 0) {
                sum = sum + count;
            }
        }
        return sum;
    }
}

// Runtime 2 ms Beats 88.59%
// Memory 41.7 MB Beats 94.97%
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < answers.length; i++) {
            int cur = counts.getOrDefault(answers[i], answers[i]);
            if (cur == answers[i]) {
                counts.put(answers[i], 0);
                sum = sum + answers[i] + 1;
            } else {
                counts.put(answers[i], cur + 1);
            }
        }
        return sum;
    }
}