package graphs.shortest_paths;

import graphs.Graph;
import stacks_queues.Queue;
import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

import java.util.*;


public class ShortestPath {

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) throws QueueOverflowException, QueueUnderflowException {
        Map<Integer, DistanceInfo> table = new HashMap<>();
        for (int i = 0; i < graph.getNumOfVertices(); i++) {
            table.put(i, new DistanceInfo());
        }
        table.get(source).setDistance(0);
        table.get(source).setLastVertex(source);

        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(source);

        while (!queue.isEmpty()){
            int vertex = queue.dequeue();
            List<Integer> adjacents = graph.getAdjacentVertices(vertex);
            for (Integer adj:adjacents) {
                int currDist = table.get(adj).getDistance();
                if (currDist == -1){
                    currDist = 1 + table.get(vertex).getDistance();
                    table.get(adj).setDistance(currDist);
                    table.get(adj).setLastVertex(vertex);
                }

                if (!graph.getAdjacentVertices(adj).isEmpty()){
                    queue.enqueue(adj);
                }
            }
        }

        return table;
    }

    public static Map<Integer, DistanceInfoGreedy> buildDistanceTableDreedy(Graph graph, int source){
        Map<Integer, DistanceInfoGreedy> table = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<VertexInfo>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getVertexDist()).compareTo(v2.getVertexDist());
            }
        });

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        for (int i = 0; i < graph.getNumOfVertices(); i++) {
            table.put(i, new DistanceInfoGreedy());
        }

        table.get(source).setDistance(0);
        table.get(source).setLastVertex(source);

        VertexInfo vertexInfo = new VertexInfo(source, 0);
        queue.add(vertexInfo);
        vertexInfoMap.put(source, vertexInfo);

        while (!queue.isEmpty()){
            VertexInfo currVertexInfo = queue.poll();
            int currVertex = currVertexInfo.getVertexId();

            for (Integer neighbour : graph.getAdjacentVertices(currVertex)){
                int distance = table.get(currVertex).getDistance() + graph.getWeightedEdge(currVertex, neighbour);

                if (distance < table.get(neighbour).getDistance()){
                    table.get(neighbour).setDistance(distance);
                    table.get(neighbour).setLastVertex(currVertex);
                }

                VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                if (neighbourVertexInfo != null){
                    queue.remove(neighbourVertexInfo);
                }

                neighbourVertexInfo = new VertexInfo(neighbour, distance);
                queue.add(neighbourVertexInfo);
                vertexInfoMap.put(neighbour, neighbourVertexInfo);
            }
        }
        return table;
    }

    public static ArrayList<Integer> shortestPath(Graph graph, int source, int dest) throws QueueUnderflowException, QueueOverflowException {
        Map<Integer, DistanceInfo> table = buildDistanceTable(graph, source);
        ArrayList<Integer> reversePath = new ArrayList<>();
        reversePath.add(dest);

        int previousVertex = table.get(dest).getLastVertex();
        while (previousVertex != -1 && previousVertex != source){
            reversePath.add(previousVertex);
            previousVertex = table.get(previousVertex).getLastVertex();
        }

        ArrayList<Integer> path = new ArrayList<>();
        if (previousVertex == -1){
            System.out.println("No path");
            return null;
        } else {
            path.add(source);
            for (int i = reversePath.size() - 1; i >= 0 ; i--) {
                path.add(reversePath.get(i));
            }
        }
        return path;
    }
}
