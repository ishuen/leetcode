// 735. Asteroid Collision
// We are given an array asteroids of integers representing asteroids in a row.
//
// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//
//
// Example 1:
//
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:
//
// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:
//
// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
// Example 4:
//
// Input: asteroids = [-2,-1,1,2]
// Output: [-2,-1,1,2]
// Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
//
//
// Constraints:
//
// 2 <= asteroids.length <= 104
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0

// Runtime: 4 ms, faster than 88.41% of Java online submissions for Asteroid Collision.
// Memory Usage: 40.1 MB, less than 36.83% of Java online submissions for Asteroid Collision.
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else if (stack.peek() < 0 || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                int top = stack.peek();
                while (!stack.isEmpty() && top > 0 && asteroids[i] < 0 && Math.abs(top) < Math.abs(asteroids[i])) {
                    stack.pop();
                    top = stack.isEmpty() ? 0 : stack.peek();
                }
                if (top + asteroids[i] == 0) {
                    stack.pop();
                } else if (top <= 0){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] arr = new int[stack.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}

// Runtime: 5 ms, faster than 65.04% of Java online submissions for Asteroid Collision.
// Memory Usage: 39.6 MB, less than 74.98% of Java online submissions for Asteroid Collision.
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                } else if (asteroids[i] + stack.peek() == 0){
                    stack.pop();
                }
            }
        }
        int[] arr = new int[stack.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}