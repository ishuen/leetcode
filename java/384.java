// 384. Shuffle an Array
// Given an integer array nums, design an algorithm to randomly shuffle the array.
//
// Implement the Solution class:
//
// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
// int[] shuffle() Returns a random shuffling of the array.
//
//
// Example 1:
//
// Input
// ["Solution", "shuffle", "reset", "shuffle"]
// [[[1, 2, 3]], [], [], []]
// Output
// [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
// Explanation
// Solution solution = new Solution([1, 2, 3]);
// solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
// solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
// solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
//
//
//
// Constraints:
//
// 1 <= nums.length <= 200
// -106 <= nums[i] <= 106
// All the elements of nums are unique.
// At most 5 * 104 calls will be made to reset and shuffle.
//
// Runtime: 70 ms, faster than 95.99% of Java online submissions for Shuffle an Array.
// Memory Usage: 47 MB, less than 83.58% of Java online submissions for Shuffle an Array.
class Solution {

    private int[] origin;
    private int[] cur;
    private Random random;
    
    public Solution(int[] nums) {
        origin = nums;
        cur = Arrays.copyOfRange(nums, 0, nums.length);
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int j = 1 + random.nextInt(cur.length - 1);
        int i = random.nextInt(j + 1);
        int temp = cur[j];
        cur[j] = cur[i];
        cur[i] = temp;
        
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */