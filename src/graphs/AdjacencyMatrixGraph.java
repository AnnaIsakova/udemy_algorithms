package graphs;

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

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, GraphType.DIRECTD);
    }
}
