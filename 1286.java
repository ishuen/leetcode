// 1286. Iterator for Combination
//
// Design the CombinationIterator class:
//
// CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// next() Returns the next combination of length combinationLength in lexicographical order.
// hasNext() Returns true if and only if there exists a next combination.
//
//
// Example 1:
//
// Input
// ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [["abc", 2], [], [], [], [], [], []]
// Output
// [null, "ab", true, "ac", true, "bc", false]
//
// Explanation
// CombinationIterator itr = new CombinationIterator("abc", 2);
// itr.next();    // return "ab"
// itr.hasNext(); // return True
// itr.next();    // return "ac"
// itr.hasNext(); // return True
// itr.next();    // return "bc"
// itr.hasNext(); // return False
//
//
// Constraints:
//
// 1 <= combinationLength <= characters.length <= 15
// All the characters of characters are unique.
// At most 104 calls will be made to next and hasNext.
// It is guaranteed that all calls of the function next are valid.
//
// Runtime 17ms Beats 18.83%of users with Java
// Memory 46.06MB Beats 5.84%of users with Java
class CombinationIterator {
    private int len;
    private char[] charArr;
    private List<String> strList;
    private int index = -1;
    public CombinationIterator(String characters, int combinationLength) {
        this.len = combinationLength;
        this.strList = new ArrayList<>();
        this.charArr = characters.toCharArray();

        generateList(0, "", new boolean[characters.length()]);
    }

    private void generateList(int index, String prefix, boolean[] selected) {
        if (prefix.length() == len) {
            strList.add(prefix);
            return;
        }
        for (int i = index; i < charArr.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                generateList(i + 1, prefix + charArr[i], selected);
                selected[i] = false;
            }
        }
    }
    
    public String next() {
        index++;
        return strList.get(index);
    }
    
    public boolean hasNext() {
        return index < strList.size() - 1;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// Runtime 11ms Beats 82.47%of users with Java
// Memory 44.26MB Beats 50.65%of users with Java
class CombinationIterator {
    private int len;
    private char[] charArr;
    private List<String> strList;
    private int index = -1;
    public CombinationIterator(String characters, int combinationLength) {
        this.len = combinationLength;
        this.strList = new ArrayList<>();
        this.charArr = characters.toCharArray();

        generateList(0, new StringBuilder(), new boolean[characters.length()]);
    }

    private void generateList(int index, StringBuilder prefix, boolean[] selected) {
        if (prefix.length() == len) {
            strList.add(prefix.toString());
            return;
        }
        for (int i = index; i < charArr.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                generateList(i + 1, prefix.append(charArr[i]), selected);
                prefix.deleteCharAt(prefix.length() - 1);
                selected[i] = false;
            }
        }
    }
    
    public String next() {
        index++;
        return strList.get(index);
    }
    
    public boolean hasNext() {
        return index < strList.size() - 1;
    }
}