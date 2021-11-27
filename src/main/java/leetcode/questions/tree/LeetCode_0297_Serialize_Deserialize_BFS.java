package leetcode.questions.tree;

//        297. Serialize and Deserialize Binary Tree
//        Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
//        in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
//        another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary tree.
//        There is no restriction on how your serialization/deserialization algorithm should work.
//        You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
//        to the original tree structure.
//
//        Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily
//        need to follow this format, so please be creative and come up with different approaches yourself.

import tags.Facebook;

import java.util.LinkedList;

@Facebook(value = "011", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0297_Serialize_Deserialize_BFS {

    public static void main(String[] args) {

        Codec codec = new Codec();
        String serialize = codec.serialize(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder file = new StringBuilder("");
            if (root == null) {
                return file.toString();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                TreeNode node = queue.removeFirst();

                if (node == null) {
                    file.append("null,");
                    continue;
                }
                file.append(node.val).append(",");

                queue.add(node.left);
                queue.add(node.right);
            }
            return file.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data.equals("")) {
                return null;
            }
            String[] parts = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int i = 1;
            while (i < parts.length) {
                TreeNode node = queue.poll();

                if (!parts[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                    node.left = left;
                    queue.add(left);
                }
                i++;
                if (!parts[i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                    node.right = right;
                    queue.add(right);
                }
                i++;
            }

            return root;
        }
    }
}