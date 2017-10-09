package graphs;

import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph{

    public GraphType type = GraphType.DIRECTD;
    int[][] matrix;
    int numOfVertices;

    public AdjacencyMatrixGraph(int numOfVertices, GraphType type) {
        this.numOfVertices = numOfVertices;
        this.type = type;
        matrix = new int[numOfVertices][numOfVertices];
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numOfVertices || v2 < 0 || v2 >= numOfVertices){
            throw new IllegalArgumentException("wrong vertex");
        }

        matrix[v1][v2] = 1;
        if (type == GraphType.UNDIRECTED){
            matrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v < 0 || v >= numOfVertices){
            throw new IllegalArgumentException("wrong vertex");
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numOfVertices; i++) {
            if (matrix[v][i] == 1){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) throws QueueUnderflowException, QueueOverflowException {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, GraphType.UNDIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        int[] visited1 = new int[5];
        //loop for unconnected graph
        for (int i = 0; i < graph.numOfVertices; i++) {
            GraphTraversal.deapthFirstTraversal(graph, visited1, 0);
        }

        System.out.println();

        int[] visited2 = new int[5];
        for (int i = 0; i < graph.numOfVertices; i++) {
            GraphTraversal.breadthFirstTraversal(graph, visited2, 0);
        }
    }
}
