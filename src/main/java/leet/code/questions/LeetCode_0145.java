package leet.code.questions;

//        145. Binary Tree Postorder Traversal
//        Given the root of a binary tree, return the postorder traversal of its nodes' values.

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0145 {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(postorderTraversal(tree));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        return postorderTraversal(root, new ArrayList<>());
    }

    public static List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);

        return list;
    }
}