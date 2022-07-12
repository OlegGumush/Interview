package leetcode.questions.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        129. Sum Root to Leaf Numbers
        You are given the root of a binary tree containing digits from 0 to 9 only.
        Each root-to-leaf path in the tree represents a number.
        For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
        Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
        A leaf node is a node with no children.
*/

public class LeetCode_0129_Sum_Root_to_Leaf_Number {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(sum(tree));
        System.out.println(sumNumbers(tree));
    }

    public static int sumNumbers(TreeNode root) {

        List<String> paths = sumNumbersWrap(root);

        Integer result = 0;
        for (String path : paths) {
            result += Integer.parseInt(path);
        }
        return result;
    }

    public static List<String> sumNumbersWrap(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList("" + root.val);
        }

        List<String> pathsLeft = sumNumbersWrap(root.left);
        List<String> pathsRight = sumNumbersWrap(root.right);

        List<String> pathsParent = new ArrayList<>();

        for (int i = 0; i < pathsLeft.size(); i++) {
            pathsParent.add(root.val + pathsLeft.get(i));
        }
        for (int i = 0; i < pathsRight.size(); i++) {
            pathsParent.add(root.val + pathsRight.get(i));
        }
        return pathsParent;
    }

    public static Integer sum(TreeNode root) {

        return sum(root, "");
    }

    public static Integer sum(TreeNode root, String path) {

        if (root == null) {
            return 0;
        }
        path = path + root.val;
        if (root.left == null && root.right == null) {
            return Integer.parseInt(path);
        }
        return sum(root.left, path) + sum(root.right, path);
    }
}