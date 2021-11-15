package leet.code.questions.DataStructure_01;

//        144. Binary Tree Preorder Traversal
//        Given the root of a binary tree, return the preorder traversal of its nodes' values.


import leet.code.questions.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0144 {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(preorderTraversal(tree));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        return preorderTraversal(root, new ArrayList<>());
    }

    public static List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);

        return list;
    }
}