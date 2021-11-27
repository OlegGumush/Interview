package leetcode.questions.tree;

//        226. Invert Binary Tree
//        Given the root of a binary tree, invert the tree, and return its root.

public class LeetCode_0226_Invert_Binary_Tree {

    public static void main(String[] args) {

//        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//        System.out.println(invertTree(tree));

        System.out.println(invertTree(new TreeNode(1, new TreeNode(2), null)));

    }

    // GOOD one from internet
    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static TreeNode invertTree1(TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            root.left = invertTree1(root.right);
            root.right = null;
        } else if (root.right == null) {
            root.right = invertTree1(root.left);
            root.left = null;
        } else {
            TreeNode tempLeft = root.left;
            root.left = invertTree1(root.right);
            root.right = invertTree1(tempLeft);
        }
        return root;
    }
}