package leet.code.questions;

//        94. Binary Tree Inorder Traversal
//        Given the root of a binary tree, return the Inorder traversal of its nodes' values.

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0094 {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(inorderTraversal(tree));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        return inorderTraversal(root, new ArrayList<>());
    }

    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

        return list;
    }
}