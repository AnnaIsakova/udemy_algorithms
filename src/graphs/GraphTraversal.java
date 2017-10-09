package graphs;

import java.util.List;

public class GraphTraversal {

    static void deapthFirstTraversal(Graph graph, int[] visited, int vertex){
        if (visited[vertex] == 1){
            return;
        }

        visited[vertex] = 1;
        System.out.print(vertex + " -> ");
        List<Integer> adjacents = graph.getAdjacentVertices(vertex);
        for (Integer v : adjacents) {
            deapthFirstTraversal(graph, visited, v);
        }

        //for unconnected graph
//        for (int i = 0; i < N; i++) {
//            deapthFirstTraversal(graph, visited, i);
//        }
    }
}
