package leetcode.questions.tree;

//        226. Invert Binary Tree
//        Given the root of a binary tree, invert the tree, and return its root.

public class LeetCode_0112_Has_Path {

    public static void main(String[] args) {

//        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//        System.out.println(invertTree(tree));

        System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), null), 3));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}