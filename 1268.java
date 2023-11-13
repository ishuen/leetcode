// 1268. Search Suggestions System
//
// You are given an array of strings products and a string searchWord.
//
// Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
// Return a list of lists of the suggested products after each character of searchWord is typed.
//
//
//
// Example 1:
//
// Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
// Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
// Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
// After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
// After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
// Example 2:
//
// Input: products = ["havana"], searchWord = "havana"
// Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// Explanation: The only word "havana" will be always suggested while typing the search word.
//
//
// Constraints:
//
// 1 <= products.length <= 1000
// 1 <= products[i].length <= 3000
// 1 <= sum(products[i].length) <= 2 * 104
// All the strings of products are unique.
// products[i] consists of lowercase English letters.
// 1 <= searchWord.length <= 1000
// searchWord consists of lowercase English letters.
//
// Runtime 49ms Beats 37.63%of users with Java
// Memory 48.40MB Beats 34.00%of users with Java
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String word : products) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.nextLayer[c - 'a'] == null) {
                    cur.nextLayer[c - 'a'] = new Node();
                }
                cur = cur.nextLayer[c - 'a'];
            }
            cur.isEnd = true;
        }

        List<List<String>> output = new ArrayList<>();
        Node cur = root;
        StringBuilder prefix = new StringBuilder();
        for (char c: searchWord.toCharArray()) {
            cur = cur.nextLayer[c - 'a'];
            List<String> list = new ArrayList<>();
            if (cur == null) {
                break;
            }
            prefix.append(c);
            findThree(cur, prefix, list);
            output.add(list);
        }

        while (output.size() < searchWord.length()) {
            output.add(new ArrayList<>());
        }
        return output;
    }

    class Node {
        boolean isEnd;
        Node[] nextLayer;
        public Node() {
            nextLayer = new Node[26];
        }
    }

    private void findThree(Node base, StringBuilder prefix, List<String> list) {
        if (list.size() == 3) return;
        if (base.isEnd == true) {
            list.add(prefix.toString());
        }
        if (list.size() < 3) {
            for (int i = 0; i < 26; i++) {
                if (base.nextLayer[i] == null) {
                    continue;
                }
                char c = (char) ('a' + i);
                prefix.append(c);
                findThree(base.nextLayer[i], prefix, list);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}

// Runtime 13ms Beats 91.43%of users with Java
// Memory 46.62MB Beats 58.31%of users with Java
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> output = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            output.add(new ArrayList<>());
        }
        int totalCount = 0;
        for (int i = 0; i < products.length; i++) {
            if (totalCount > searchWord.length() * 3) break;
            int len = Math.min(products[i].length(), searchWord.length());
            for (int j = 0; j < len; j++) {
                if (products[i].charAt(j) == searchWord.charAt(j)) {
                    if (output.get(j).size() < 3) {
                        output.get(j).add(products[i]);
                        totalCount++;
                    }
                } else {
                    break;
                }
            }
        }

        return output;
    }
}
