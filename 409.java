// 409. Longest Palindrome
//   Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//   Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//
//
//   Example 1:
//
//   Input: s = "abccccdd"
//   Output: 7
//   Explanation:
//   One longest palindrome that can be built is "dccaccd", whose length is 7.
//   Example 2:
//
//   Input: s = "a"
//   Output: 1
//   Example 3:
//
//   Input: s = "bb"
//   Output: 2
//
//
//   Constraints:
//
//   1 <= s.length <= 2000
//   s consists of lowercase and/or uppercase English letters only.

// Runtime: 5 ms, faster than 38.41% of Java online submissions for Longest Palindrome.
// Memory Usage: 37.7 MB, less than 40.88% of Java online submissions for Longest Palindrome.
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        int count = 0;
        boolean hasOdd = false;
        while(iterator.hasNext()) {
            Map.Entry<Character, Integer> pair = iterator.next();
            int num = pair.getValue();
            if (num % 2 == 1) {
                hasOdd = true;
            }
            count = num % 2 == 0 ? count + num : count + num  - 1;
        }
        if (hasOdd == true) count++;
        return count;
    }
}


// Runtime: 4 ms, faster than 52.17% of Java online submissions for Longest Palindrome.
// Memory Usage: 39 MB, less than 14.11% of Java online submissions for Longest Palindrome.

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        if(!set.isEmpty()) {
            return 2 * count + 1;
        }
        return 2 * count;
    }
}

