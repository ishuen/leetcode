// 990. Satisfiability of Equality Equations
//
// You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
//
// Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
//
//
//
// Example 1:
//
// Input: equations = ["a==b","b!=a"]
// Output: false
// Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
// There is no way to assign the variables to satisfy both equations.
// Example 2:
//
// Input: equations = ["b==a","a==b"]
// Output: true
// Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
//
//
// Constraints:
//
// 1 <= equations.length <= 500
// equations[i].length == 4
// equations[i][0] is a lowercase letter.
// equations[i][1] is either '=' or '!'.
// equations[i][2] is '='.
// equations[i][3] is a lowercase letter.
//
// Runtime 6 ms Beats 7.62%
// Memory 43.3 MB Beats 6.28%
class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Stack<char[]> stack = new Stack<>();
        for (String equation: equations) {
            char var1 = equation.charAt(0);
            char var2 = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                Set<Character> set1 = map.getOrDefault(var1, new HashSet<>());
                set1.add(var2);
                Set<Character> set2 = map.getOrDefault(var2, new HashSet<>());
                set2.add(var1);
                map.put(var1, set1);
                map.put(var2, set2);
            } else {
                if (var1 == var2) return false;
                stack.push(new char[]{var1, var2});
            }
        }
        while (!stack.isEmpty()) {
            char[] pair = stack.pop();
            Queue<Character> queue = new LinkedList<>();
            queue.add(pair[0]);
            boolean[] checked = new boolean[26];
            while (!queue.isEmpty()) {
                char c = queue.remove();
                if (checked[c - 'a'] == true) continue;
                checked[c - 'a'] = true;
                Set<Character> set = map.get(c);
                if (set == null) continue;
                if (set.contains(pair[1])) return false;
                Iterator<Character> it = set.iterator();
                while(it.hasNext()) {
                    queue.add(it.next());
                }
            }
        }
        return true;
    }
}

// Runtime 1 ms Beats 99.78%
// Memory 41.2 MB Beats 78.48%
class Solution {
    private int[] parents;
    private int findParent(int c) {
        return parents[c] == c ? c : (parents[c] = findParent(parents[c]));
    }
    public boolean equationsPossible(String[] equations) {
        parents = new int[26];
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        for (String equation: equations) {
            int var1 = equation.charAt(0) - 'a';
            int var2 = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                int parent1 = findParent(var1);
                int parent2 = findParent(var2);
                if (parent1 < parent2) {
                    parents[parent2] = parent1;
                } else if (parent1 > parent2) {
                    parents[parent1] = parent2;
                }
            }
        }

        for (String equation: equations) {
            int var1 = equation.charAt(0) - 'a';
            int var2 = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!') {
                int parent1 = findParent(var1);
                int parent2 = findParent(var2);
                if (parent1 == parent2) return false;
            }
        }

        return true;
    }
}