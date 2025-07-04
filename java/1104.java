// 1104. Path In Zigzag Labelled Binary Tree
// In an infinite binary tree where every node has two children, the nodes are labelled in row order.
//
// In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
//
//
//
// Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
//
//
//
// Example 1:
//
// Input: label = 14
// Output: [1,3,4,14]
// Example 2:
//
// Input: label = 26
// Output: [1,2,6,10,26]
//
//
// Constraints:
//
// 1 <= label <= 10^6
//
// Runtime 0ms Beats 100.00%of users with Java
// Memory 40.11MB Beats 42.79%of users with Java
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int layer = (int) (Math.log(label) / Math.log(2));
        for (int i = 0; i < layer; i++) {
            label = getParent(label, list);
        }
        list.add(0,label);
        return list;
    }

    private int getParent(int label, List<Integer> list) {
        int lastOfUpper = (int) Math.pow(2, (int)(Math.log(label / 2)/ Math.log(2)) + 1) - 1;
        int parent = lastOfUpper - (int)label / 2 + (lastOfUpper + 1) / 2;
        list.add(0, label);
        return parent;
    }
}
