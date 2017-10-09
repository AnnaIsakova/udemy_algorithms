package graphs;

import stacks_queues.Queue;
import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

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

    static void breadthFirstTraversal(Graph graph, int[] visited, int vertex) throws QueueOverflowException, QueueUnderflowException {
        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(vertex);

        while (!queue.isEmpty()){
            int currVertex = queue.dequeue();
            if (visited[currVertex] == 1) continue;

            visited[currVertex] = 1;
            System.out.print(currVertex + " -> ");

            List<Integer> adjacents = graph.getAdjacentVertices(currVertex);
            for (Integer v:adjacents) {
                if (visited[v] != 1){
                    queue.enqueue(v);
                }
            }

        }
    }
}
