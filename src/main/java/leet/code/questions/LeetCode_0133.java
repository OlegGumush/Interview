package leet.code.questions;

//        133. Clone Graph
//        Given a reference of a node in a connected undirected graph.
//        Return a deep copy (clone) of the graph.
//        Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

import nodes.Node;
import tags.Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Facebook(value = "010", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0133 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);

        System.out.println(cloneGraph(node1));
    }

    public static Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        Map<Node, Node> visited = new HashMap<>();

        while (!queue.isEmpty()) {

            Node currNode = queue.poll();
            // save all nodes copies
            visited.put(currNode, new Node(currNode.val));

            for (Node neigh : currNode.neighbors) {
                if (!visited.containsKey(neigh)) {
                    queue.add(neigh);
                }
            }
        }

        for (Node oldNode : visited.keySet()) {
            Node newNode = visited.get(oldNode); // take node from list
            for (Node oldNeighbor : oldNode.neighbors) {
                newNode.neighbors.add(visited.get(oldNeighbor)); // take node from list
            }
        }

        return visited.get(node);
    }
}