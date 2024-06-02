package Classes;

import java.util.HashMap;
import java.util.Map;

/**
 * A vertex in a graph with data of type V.
 * Stores data and adjacent vertices with edge weights.
 */
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Adds an edge to an adjacent vertex with a given weight.
     * @param destination The connected vertex.
     * @param weight The edge weight.
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Creates a new vertex with the given data.
     * @param data Data for the vertex.
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Gets the data stored in the vertex.
     * @return The data.
     */
    public V getData() {
        return data;
    }

    /**
     * Gets adjacent vertices and their edge weights.
     * @return Map of adjacent vertices.
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
