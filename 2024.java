// 2024. Maximize the Confusion of an Exam
//
// A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
//
// You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
//
// Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
// Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
//
//
//
// Example 1:
//
// Input: answerKey = "TTFF", k = 2
// Output: 4
// Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
// There are four consecutive 'T's.
// Example 2:
//
// Input: answerKey = "TFFT", k = 1
// Output: 3
// Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
// Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
// In both cases, there are three consecutive 'F's.
// Example 3:
//
// Input: answerKey = "TTFTTFTT", k = 1
// Output: 5
// Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
// Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
// In both cases, there are five consecutive 'T's.
//
//
// Constraints:
//
// n == answerKey.length
// 1 <= n <= 5 * 104
// answerKey[i] is either 'T' or 'F'
// 1 <= k <= n
//
// Runtime 16 ms Beats 49.35% of users with Java
// Memory 43.83 MB Beats 31.65% of users with Java
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(iterate(answerKey, k, 'T'), iterate(answerKey, k, 'F'));
    }

    private int iterate(String answerKey, int k, char target) {
        int left = 0;
        int right = 0;
        int count = 0;
        int len = answerKey.length();
        int max = 0;
        while (left <= right && right < len) {
            if (answerKey.charAt(right) == target) {
                count++;
            }
            while (count > k) {
                if (answerKey.charAt(left) == target) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}


// Runtime 13 ms Beats 72.81% of users with Java
// Memory 43.71 MB Beats 40.86% of users with Java
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] count = new int[2];
        int left = 0;
        int right = 0;
        int len = answerKey.length();
        int max = 0;
        int maxCount = 0;
        while (right < len) {
            if (answerKey.charAt(right) == 'T') {
                count[0]++;
                maxCount = Math.max(maxCount, count[0]);
            } else {
                count[1]++;
                maxCount = Math.max(maxCount, count[1]);
            }
            while (maxCount + k < right - left + 1) {
                if (answerKey.charAt(left) == 'T') {
                    count[0]--;
                } else {
                    count[1]--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}