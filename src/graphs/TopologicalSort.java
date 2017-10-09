package graphs;

import stacks_queues.Queue;
import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopologicalSort {

    static List<Integer> sort(Graph graph) throws QueueOverflowException, QueueUnderflowException {
        if (graph.getType() != Graph.GraphType.DIRECTED){
            throw new IllegalArgumentException("Graph must be directed");
        }

        Queue<Integer> zeroIndegrees = new Queue<>(Integer.class);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int vertex = 0; vertex < graph.getNumOfVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            map.put(vertex, indegree);
            if (indegree == 0){
                zeroIndegrees.enqueue(vertex);
            }
        }

        List<Integer> sortedGraph = new ArrayList<>();
        while (!zeroIndegrees.isEmpty()){
            int curVertex = zeroIndegrees.dequeue();
            sortedGraph.add(curVertex);
            List<Integer> adjacents = graph.getAdjacentVertices(curVertex);
            for (Integer adj:adjacents) {
                int indegreeForAdj = map.get(adj) - 1;
                map.put(adj, indegreeForAdj);
                if (indegreeForAdj == 0){
                    zeroIndegrees.enqueue(adj);
                } else {

                }
            }
        }

        if (sortedGraph.size() != graph.getNumOfVertices()){
            throw new RuntimeException("graph contains cycles!");
        }

        return sortedGraph;
    }
}
