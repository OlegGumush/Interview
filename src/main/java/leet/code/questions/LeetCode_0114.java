package leet.code.questions;

//        114. Flatten Binary Tree to Linked List
//        Given the root of a binary tree, flatten the tree into a "linked list":
//        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//        The "linked list" should be in the same order as a pre-order traversal of the binary tree.
//
//        Example 1:
//        Input: root = [1,2,5,3,4,null,6]
//        Output: [1,null,2,null,3,null,4,null,5,null,6]

//        Example 2:
//        Input: root = []
//        Output: []

//        Example 3:
//        Input: root = [0]
//        Output: [0]

import nodes.TreeNode;
import tags.Facebook;

@Facebook(value = "003", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0114 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(treeNode);
        System.out.println(treeNode);
    }

    private static void flatten(TreeNode node) {

        node = flatten1(node);
    }

    private static TreeNode flatten1(TreeNode node) {

        if (node == null) {
            return null;
        }
        // return leaf
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode left = flatten1(node.left);
        TreeNode right = flatten1(node.right);

        if (left != null) {
            // hold the left size
            node.right = left;
            // go to the end of the linked list
            while (left.right != null) {
                left = left.right;
            }
            // add the right side to the end of the list
            left.right = right;
        }
        node.left = null;

        return node;
    }
}


















