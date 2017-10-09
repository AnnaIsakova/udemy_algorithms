package graphs.shortest_paths;

public class DistanceInfoGreedy {

    private int distance;
    private int lastVertex;

    public DistanceInfoGreedy() {
        distance = Integer.MAX_VALUE;
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
