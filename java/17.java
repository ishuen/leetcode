// 17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
// Example:
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
//     Although the above answer is in lexicographical order, your answer could be in any order you want.

// Runtime: 2 ms, faster than 50.63% of Java online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 38.4 MB, less than 6.16% of Java online submissions for Letter Combinations of a Phone Number.

public class Solution {
    List<String> ans = new ArrayList<>();
    List<String> key2 = Arrays.asList("a", "b", "c");
    List<String>  key3 = Arrays.asList("d", "e", "f");
    List<String>  key4 = Arrays.asList("g", "h", "i");
    List<String>  key5 = Arrays.asList("j", "k", "l");
    List<String>  key6 = Arrays.asList("m", "n", "o");
    List<String>  key7 = Arrays.asList("p", "q", "r", "s");
    List<String>  key8 = Arrays.asList("t", "u", "v");
    List<String>  key9 = Arrays.asList("w", "x", "y", "z");
    Map<String, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        createMap();
        dfs(new String(), 0, digits);
        return ans;
    }
    private void dfs(final String str, int cur, String digits) {
        String k = Character.toString(digits.charAt(cur));
        if (cur == digits.length() - 1) {
            map.get(k).forEach(x -> {
                ans.add(str + x);
            });
        } else {
            map.get(k).forEach(x -> {
               dfs(str + x, cur + 1, digits);
            });
        }
    }
    
    private void createMap() {
        map.put("2", key2);
        map.put("3", key3);
        map.put("4", key4);
        map.put("5", key5);
        map.put("6", key6);
        map.put("7", key7);
        map.put("8", key8);
        map.put("9", key9);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 38.2 MB, less than 6.16% of Java online submissions for Letter Combinations of a Phone Number.
public class Solution {
    List<String> ans = new ArrayList<>();
    String[] phone = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        dfs(digits, 0, new StringBuilder(digits));
        return ans;
    }
    void dfs(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(i));
        for (char c : phone[digit - 2].toCharArray()) {
            sb.setCharAt(i, c);
            dfs(digits, i+1, sb);
        }
    }
}


