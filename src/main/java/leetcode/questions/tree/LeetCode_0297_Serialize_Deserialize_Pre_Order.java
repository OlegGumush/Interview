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

@Facebook(value = "011", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0297_Serialize_Deserialize_Pre_Order {

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

            return serialize(root, new StringBuilder(""));
        }

        public String serialize(TreeNode root, StringBuilder sb) {

            if (root == null) {
                sb.append("n,");
                return sb.toString();
            }
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            return deserialize(data.split(","), new int[]{0});
        }

        private TreeNode deserialize(String[] split, int[] index) {

            String data = split[index[0]];
            if (data.equals("n")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data));
            index[0]++;
            node.left = deserialize(split, index);
            index[0]++;
            node.right = deserialize(split, index);
            return node;
        }
    }
}