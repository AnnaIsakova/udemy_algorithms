package graphs;

import java.util.List;

public interface Graph {

    enum GraphType{
        DIRECTD,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}
