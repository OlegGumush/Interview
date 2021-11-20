package leet.code.questions;

import nodes.TreeNode;
import tags.Facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//        102. Binary Tree Level Order Traversal
//        Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[9,20],[15,7]]

//        Example 2:
//        Input: root = [1]
//        Output: [[1]]

//        Example 3:
//        Input: root = []
//        Output: []

@Facebook(value = "004", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0102 {

    public static void main(String[] args) {

        System.out.println(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(333333), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode element = queue.poll();
                level.add(element.val);
                if (element.left != null) {
                    queue.add(element.left);
                }
                if (element.right != null) {
                    queue.add(element.right);
                }
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }

        return result;
    }
}