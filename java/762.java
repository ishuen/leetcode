// 762. Prime Number of Set Bits in Binary Representation
// Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
//
// (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
//
// Example 1:
//
// Input: L = 6, R = 10
// Output: 4
// Explanation:
// 6 -> 110 (2 set bits, 2 is prime)
// 7 -> 111 (3 set bits, 3 is prime)
// 9 -> 1001 (2 set bits , 2 is prime)
// 10->1010 (2 set bits , 2 is prime)
// Example 2:
//
// Input: L = 10, R = 15
// Output: 5
// Explanation:
// 10 -> 1010 (2 set bits, 2 is prime)
// 11 -> 1011 (3 set bits, 3 is prime)
// 12 -> 1100 (2 set bits, 2 is prime)
// 13 -> 1101 (3 set bits, 3 is prime)
// 14 -> 1110 (3 set bits, 3 is prime)
// 15 -> 1111 (4 set bits, 4 is not prime)
// Note:
//
// L, R will be integers L <= R in the range [1, 10^6].
// R - L will be at most 10000.

// Runtime: 69 ms, faster than 19.19% of Java online submissions for Prime Number of Set Bits in Binary Representation.
// Memory Usage: 38.3 MB, less than 16.82% of Java online submissions for Prime Number of Set Bits in Binary Representation.

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = L; i <= R; i++){
            String binary = Integer.toBinaryString(i);
            int setBits = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    setBits++;
                }
            }
            if (map.containsKey(setBits)) {
                if (map.get(setBits) == true) {
                    count++;
                }
            } else {
                boolean result = isPrime(setBits);
                map.put(setBits, result);
                if (result == true) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        if (number % 2 == 0) {
            if (number == 2) return true;
            else return false;
        }
        for (int i = 3; i < number; i = i + 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

// Runtime: 32 ms, faster than 30.81% of Java online submissions for Prime Number of Set Bits in Binary Representation.
// Memory Usage: 38.5 MB, less than 13.74% of Java online submissions for Prime Number of Set Bits in Binary Representation.
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = L; i <= R; i++){
            String binary = Integer.toBinaryString(i);
            int setBits = Integer.bitCount(i);
            if (map.containsKey(setBits)) {
                if (map.get(setBits) == true) {
                    count++;
                }
            } else {
                boolean result = isPrime(setBits);
                map.put(setBits, result);
                if (result == true) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        if (number % 2 == 0) {
            if (number == 2) return true;
            else return false;
        }
        for (int i = 3; i < number; i = i + 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

// Runtime: 28 ms, faster than 34.83% of Java online submissions for Prime Number of Set Bits in Binary Representation.
// Memory Usage: 38.4 MB, less than 16.82% of Java online submissions for Prime Number of Set Bits in Binary Representation.
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        Set<Integer> listPrimes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        // 2 ^ 20 > 10 ^ 6
        for (int i = L; i <= R; i++){
            String binary = Integer.toBinaryString(i);
            int setBits = Integer.bitCount(i);
            if (listPrimes.contains(setBits)) {
                count++;
            }
        }
        return count;
    }
}