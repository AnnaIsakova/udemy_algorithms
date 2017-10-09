package graphs.shortest_paths;

public class DistanceInfo {

    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        distance = -1;
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }

    @Override
    public String toString() {
        return "DistanceInfo{" +
                "distance=" + distance +
                ", lastVertex=" + lastVertex +
                '}';
    }
}
