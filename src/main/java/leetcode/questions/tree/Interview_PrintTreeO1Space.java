package leetcode.questions.tree;

public class Interview_PrintTreeO1Space {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(12, new TreeNode(14), new TreeNode(15)));
        print(tree);
    }

    private static void print(TreeNode root) {

        System.out.println(root.val);

        while (!isLeaf(root)) {
            TreeNode leaf = findAndDeleteLeaf(root);
            System.out.println(leaf.val);
        }
    }

    private static TreeNode findAndDeleteLeaf(TreeNode root) {

        TreeNode prev = null;
        TreeNode current = root;

        TreeNode leaf = null;

        while (leaf == null) {
            if (current.left != null) {
                prev = current;
                current = current.left;

                if (isLeaf(current)) {
                    prev.left = null;
                    leaf = current;
                }
            } else if (current.right != null) {
                prev = current;
                current = current.right;

                if (isLeaf(current)) {
                    prev.right = null;
                    leaf = current;
                }
            }
        }
        return leaf;
    }

    private static boolean isLeaf(TreeNode node) {

        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}

