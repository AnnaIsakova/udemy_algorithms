package graphs.shortest_paths;

public class VertexInfo {

    private int vertexId;
    private int vertexDist;

    public VertexInfo(int vertexId, int vertexDist) {
        this.vertexId = vertexId;
        this.vertexDist = vertexDist;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getVertexDist() {
        return vertexDist;
    }

    public void setVertexDist(int vertexDist) {
        this.vertexDist = vertexDist;
    }
}
