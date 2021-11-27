package leetcode.questions.tree;

//        701. Insert Binary Tree

public class LeetCode_0701_Insert_Binary_Tree {

    public static void main(String[] args) {
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}