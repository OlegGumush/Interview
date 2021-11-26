package leetcode.questions.tree;

//        35. Search Insert Position
//        Given a sorted array of distinct integers and a target value, return the index if the target is found.
//        If not, return the index where it would be if it were inserted in order.
//        You must write an algorithm with O(log n) runtime complexity.

import leetcode.questions.tree.TreeNode;

import java.util.HashSet;

public class LeetCode_0653_Two_Sum_IV {

    public static void main(String[] args) {

        System.out.println(findTarget(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 9));

    }

    public static boolean findTarget(TreeNode root, int k) {

        return findTarget(root, k, new HashSet<>());
    }

    private static boolean findTarget(TreeNode root, int target, HashSet<Integer> set) {

        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(target - root.val);

        return findTarget(root.left, target, set) || findTarget(root.right, target, set);
    }
}