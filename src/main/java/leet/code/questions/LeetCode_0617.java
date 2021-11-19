package leet.code.questions;

//        617. Merge Two Binary Trees
//        You are given two binary trees root1 and root2.
//        Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//        You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
//        then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
//        Return the merged tree.
//
//        Note: The merging process must start from the root nodes of both trees.
//        Example 1:
//        Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//        Output: [3,4,5,5,4,null,7]
//
//        Example 2:
//        Input: root1 = [1], root2 = [1,2]
//        Output: [2,2]

import nodes.TreeNode;

public class LeetCode_0617 {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        System.out.println(mergeTrees(t1, t2));
    }

    public static TreeNode mergeTrees(TreeNode r1, TreeNode r2) {

        if (r1 == null) {
            return r2;
        }
        if (r2 == null) {
            return r1;
        }
        r1.val = r1.val + r2.val;
        r1.left = mergeTrees(r1.left, r2.left);
        r1.right = mergeTrees(r1.right, r2.right);

        return r1;
    }
}