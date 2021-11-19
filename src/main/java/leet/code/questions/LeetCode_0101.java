package leet.code.questions;

import nodes.TreeNode;

//        101. Symmetric Tree
//        Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//        Example 1:
//        Input: root = [1,2,2,3,4,4,3]
//        Output: true
//
//        Example 2:
//        Input: root = [1,2,2,null,3,null,3]
//        Output: false

public class LeetCode_0101 {

    public static void main(String[] args) {

        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(333333), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));

    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode side1, TreeNode side2) {

        if (side1 == null && side2 == null) {
            return true;
        }
        if (side1 == null) {
            return false;
        }
        if (side2 == null) {
            return false;
        }
        if (side1.val != side2.val) {
            return false;
        }
        return isSymmetric(side1.left, side2.right) && isSymmetric(side1.right, side2.left);
    }
}