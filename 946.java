// 946. Validate Stack Sequences
// Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
//
//
//
// Example 1:
//
// Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
// Output: true
// Explanation: We might do the following sequence:
// push(1), push(2), push(3), push(4),
// pop() -> 4,
// push(5),
// pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// Example 2:
//
// Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
// Output: false
// Explanation: 1 cannot be popped before 2.
//
//
// Constraints:
//
// 1 <= pushed.length <= 1000
// 0 <= pushed[i] <= 1000
// All the elements of pushed are unique.
// popped.length == pushed.length
// popped is a permutation of pushed.
//
// Runtime: 5 ms, faster than 11.10% of Java online submissions for Validate Stack Sequences.
// Memory Usage: 42.4 MB, less than 12.34% of Java online submissions for Validate Stack Sequences.
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pointer1 = 0;
        int pointer2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (pointer1 < pushed.length && pointer2 < popped.length) {
            if (pushed[pointer1] != popped[pointer2]) {
                if (!stack.isEmpty() && stack.peek() == popped[pointer2]) {
                    stack.pop();
                    pointer2++;
                } else {
                    stack.push(pushed[pointer1]);
                    pointer1++;
                }
            } else {
                pointer1++;
                pointer2++;
            }
        }
        while (!stack.isEmpty()) {
            if (popped[pointer2] == stack.peek()) {
                stack.pop();
                pointer2++;
            } else return false;
        }
        return pointer2 == popped.length;
    }
}

// Runtime: 4 ms, faster than 17.79% of Java online submissions for Validate Stack Sequences.
// Memory Usage: 42.4 MB, less than 12.34% of Java online submissions for Validate Stack Sequences.
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pointer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[pointer]) {
                stack.pop();
                pointer++;
            }
        }
        return stack.isEmpty();
    }
}

