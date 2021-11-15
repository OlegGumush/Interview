package algorithms;

import java.util.*;

public class BFS_DFS {

    private int vertices;
    private List<List<Integer>> graph;

    BFS_DFS(int v) {
        this.vertices = v;
        this.graph = new ArrayList<>();
        for (int i = 0; i < v; ++i) {
            this.graph.add(new ArrayList<>());
        }
    }

    void addEdge(int vertex, int edge) {
        graph.get(vertex).add(edge);
    }

    void BFS(int vertex) {

        System.out.println(String.format("Run BFS from %s vertex", vertex));

        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {

            // removes first element of the list,
            Integer visitedVertex = queue.removeFirst();
            System.out.print("" + visitedVertex + " ");

            for (int i = 0; i < graph.get(visitedVertex).size(); i++) {
                int neighbor = graph.get(visitedVertex).get(i);
                if (!visited[neighbor]) {
                    // add to the add, push add to the start
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    void DFS(int v) {

        System.out.println(String.format("Run DFS from %s vertex", v));

        boolean visited[] = new boolean[vertices];
        DFS(v, visited);
        System.out.println();
    }

    void DFS(int vertex, boolean visited[]) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer neighbor = graph.get(vertex).get(i);
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    public static void main(String args[]) {

        BFS_DFS graph = new BFS_DFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.DFS(0);
        graph.DFS(2);

        BFS_DFS graph1 = new BFS_DFS(6);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(2, 5);

        graph1.BFS(0);
        graph1.BFS(2);

        BFS_DFS graph2 = new BFS_DFS(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 0);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 3);

        graph2.BFS(2);
    }
}
