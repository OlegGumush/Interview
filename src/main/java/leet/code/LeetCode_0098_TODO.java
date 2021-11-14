package leet.code;

public class LeetCode_0098_TODO {

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