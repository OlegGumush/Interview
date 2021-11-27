package leetcode.questions.tree;

//        235. Lowest Common Ancestor of a Binary Search Tree
//        Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
//        two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//        Example 1:
//        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//        Output: 6
//        Explanation: The LCA of nodes 2 and 8 is 6.

public class LeetCode_0235_Lowest_Common_Ancestor {

    public static void main(String[] args) {

        System.out.println(lowestCommonAncestor(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(2), new TreeNode(3)));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}