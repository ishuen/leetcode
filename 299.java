// 299. Bulls and Cows
// You are playing the Bulls and Cows game with your friend.
//
// You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
//
// The number of "bulls", which are digits in the guess that are in the correct position.
// The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
// Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
//
// The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
//
//
//
// Example 1:
//
// Input: secret = "1807", guess = "7810"
// Output: "1A3B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1807"
//   |
// "7810"
// Example 2:
//
// Input: secret = "1123", guess = "0111"
// Output: "1A1B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1123"        "1123"
//   |      or     |
// "0111"        "0111"
// Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
// Example 3:
//
// Input: secret = "1", guess = "0"
// Output: "0A0B"
// Example 4:
//
// Input: secret = "1", guess = "1"
// Output: "1A0B"
//
//
// Constraints:
//
// 1 <= secret.length, guess.length <= 1000
// secret.length == guess.length
// secret and guess consist of digits only.
//
// Runtime: 9 ms, faster than 38.70% of Java online submissions for Bulls and Cows.
// Memory Usage: 39.9 MB, less than 12.47% of Java online submissions for Bulls and Cows.
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (guess.charAt(i) == c) A++;
            else map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < secret.length(); i++) {
            char c = guess.charAt(i);
            Integer count = map.get(c);
            if (secret.charAt(i) != c && count != null && count > 0) {
                map.put(c, count - 1);
                B++;
            }
        }
        return A + "A" + B + "B";
    }
}

// Runtime: 9 ms, faster than 38.70% of Java online submissions for Bulls and Cows.
// Memory Usage: 39.9 MB, less than 12.47% of Java online submissions for Bulls and Cows.
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (g == s) A++;
            else {
                if (counts[s - '0'] < 0) B++;
                if (counts[g - '0'] > 0) B++;
                counts[s - '0']++;
                counts[g - '0']--;
            }
        }
        return A + "A" + B + "B";
    }
}