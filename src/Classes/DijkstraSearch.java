package Classes;

import java.util.*;

/**
 * Implements Dijkstra's algorithm for shortest paths from a source vertex
 * to all other vertices in a weighted graph.
 *
 * @param <V> the vertex type
 */
public class DijkstraSearch<V> extends Search<V> {
    private final Set<V> unsettledNodes;
    private final Map<V, Double> distances;
    private final WeightedGraph<V> graph;

    /**
     * Creates a DijkstraSearch instance and starts the search.
     * @param graph The weighted graph to search
     * @param source The start vertex
     */
    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        distances = new HashMap<>();
        unsettledNodes = new HashSet<>();
        this.graph = graph;

        dijkstra();
    }

    /**
     * Runs Dijkstra's algorithm using a set to manage unsettled nodes.
     * Initializes the source vertex distance to 0 and processes vertices until all are settled.
     */
    private void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            V currentNode = getVertexWithMinimumWeight(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Vertex<V> neighbor : graph.adjacencyList(currentNode).keySet()) {
                double newDistance = distances.get(currentNode) + graph.getWeight(currentNode, neighbor.getData());

                if (newDistance < getShortestDistance(neighbor.getData())) {
                    distances.put(neighbor.getData(), newDistance);
                    edgeTo.put(neighbor.getData(), currentNode);
                    unsettledNodes.add(neighbor.getData());
                }
            }
        }
    }
    
    /**
     * Finds and returns the vertex with the minimum weight among a set of vertices.
     * @param vertices The set of vertices to search
     * @return The vertex with the minimum weight
     */
    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;

                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }

        return minimum;
    }

    /**
     * Gets the shortest distance to a vertex from the source.
     * @param destination The target vertex
     * @return The shortest distance from the source to the target
     */
    private double getShortestDistance(V destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }

    /**
     * Checks if there is a path from the source to a given vertex.
     * @param v The target vertex
     * @return true if there is a path from the source to v, otherwise false
     */
    @Override
    public boolean hasPathTo(V v) {
        return distances.containsKey(v);
    }
}
