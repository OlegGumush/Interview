package leetcode.questions.tree;

//        98. Validate Binary Search Tree
//        Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//        A valid BST is defined as follows:

//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//

//        Example 1:
//        Input: root = [2,1,3]
//        Output: true

//        Example 2:
//        Input: root = [5,1,4,null,null,3,6]
//        Output: false
//        Explanation: The root node's value is 5 but its right child's value is 4.

public class LeetCode_0098_Is_Binary_Search_Tree_TODO {

    public static void main(String[] args) {

        System.out.println(isValidBST(new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)))));

    }

    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        if (root.left != null && root.val <= root.left.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}