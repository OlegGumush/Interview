package leet.code.questions;

//        116. Populating Next Right Pointers in Each Node
//        You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//        Initially, all next pointers are set to NULL.
//        Example 1:
//        Input: root = [1,2,3,4,5,6,7]
//        Output: [1,#,2,3,#,4,5,6,7,#]
//        Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node,
//        just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

//        Example 2:
//        Input: root = []
//        Output: []

import nodes.TreeNodeNext;

import java.util.LinkedList;

public class LeetCode_0116 {

    public static void main(String[] args) {

        TreeNodeNext tree = new TreeNodeNext(1, new TreeNodeNext(2, new TreeNodeNext(4), new TreeNodeNext(5), null), new TreeNodeNext(3, new TreeNodeNext(6), new TreeNodeNext(7), null), null);
        System.out.println(connect(tree));
    }

    public static TreeNodeNext connect(TreeNodeNext root) {

        if (root == null) {
            return null;
        }
        TreeNodeNext head = root;
        LinkedList<TreeNodeNext> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNodeNext prev = null;
            for (int i = 0; i < size; i++) { // size is number of elements in each level
                TreeNodeNext treeNodeNext = queue.poll();
                if (prev == null) {
                    prev = treeNodeNext;
                } else {
                    prev.next = treeNodeNext;
                    prev = prev.next;
                }
                if (treeNodeNext.left != null) { // right must be not null (full binary tree)
                    queue.add(treeNodeNext.left);
                    queue.add(treeNodeNext.right);
                }
            }
        }

        return root;
    }
}

;