package leetcode.questions.tree;

import java.util.LinkedList;

public class LeetCode_0236_Lowest_Common_Ancestor_BT {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode tree1 = new TreeNode(37, new TreeNode(-34, null, new TreeNode(-100)), new TreeNode(-48, new TreeNode(-101), new TreeNode(48, new TreeNode(-71), new TreeNode(-22))));

        TreeNode treeNode = lowestCommonAncestor(tree1, new TreeNode(-71), new TreeNode(48));
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        LinkedList<TreeNode> pathA = new LinkedList<>();
        LinkedList<TreeNode> pathB = new LinkedList<>();
        path(root, p.val, pathA);
        path(root, q.val, pathB);

        TreeNode result = null;
        int i = 0;
        int j = 0;

        while (i < pathA.size() && j < pathB.size()) {
            if (pathA.get(i) == pathB.get(i)) {
                result = pathA.get(i);
            }
            i++;
            j++;
        }
        return result;
    }

    public static TreeNode path(TreeNode root, Integer target, LinkedList<TreeNode> path) {

        if (root == null) {
            return null;
        }
        if (root.val == target) {
            path.addFirst(root);
            return root;
        }
        TreeNode pathLeft = path(root.left, target, path);
        TreeNode pathRight = path(root.right, target, path);

        if (pathLeft != null) {
            path.addFirst(root);
            return root;
        }
        if (pathRight != null) {
            path.addFirst(root);
            return root;
        }
        return null;
    }
}