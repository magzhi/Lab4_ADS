package Classes;

import java.util.*;

/**
 * WeightedGraph, a generic graph with vertices and weighted edges.
 */
public class WeightedGraph<V> {
    private final boolean directed;
    private final List<Vertex<V>> list = new ArrayList<>();

    /**
     * Creates a new directed graph.
     */
    public WeightedGraph() {
        this(true);
    }

    /**
     * Creates a new graph.
     * @param directed true for directed, false for undirected.
     */
    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    /**
     * Adds a vertex with the given data.
     * @param data Data for the new vertex.
     */
    public void addVertex(V data) {
        if (hasVertex(data))
            return;
        list.add(new Vertex<>(data));
    }

    /**
     * Adds an edge between two vertices with a weight.
     * If undirected, adds edges in both directions.
     * @param source Source vertex.
     * @param dest Destination vertex.
     * @param weight Edge weight.
     */
    public void addEdge(V source, V dest, double weight) {
        if (hasEdge(source, dest) || source.equals(dest))
            return;
        if (findVertex(source) == null)
            addVertex(source);
        if (findVertex(dest) == null)
            addVertex(dest);
        findVertex(source).addAdjacentVertex(findVertex(dest), weight);
        if (!directed) {
            findVertex(dest).addAdjacentVertex(findVertex(source), weight);
        }
    }

    /**
     * Returns the number of vertices.
     * @return Number of vertices.
     */
    public int getVerticesCount() {
        return list.size();
    }

    /**
     * Returns the number of edges.
     * For undirected graphs, divides by two to avoid double counting.
     * @return Number of edges.
     */
    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> source : list) {
            count += source.getAdjacentVertices().size();
        }
        return directed ? count : count / 2;
    }

    /**
     * Checks if a vertex exists.
     * @param data Vertex data.
     * @return true if the vertex exists, false otherwise.
     */
    public boolean hasVertex(V data) {
        return findVertex(data) != null;
    }

    /**
     * Checks if an edge exists.
     * @param source Source vertex.
     * @param dest Destination vertex.
     * @return true if the edge exists, false otherwise.
     */
    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source) || !hasVertex(dest))
            return false;
        Vertex<V> temp = findVertex(source);
        if (temp != null){
            Vertex<V> temp2 = findVertex(dest);
            if (temp2 != null && temp.getAdjacentVertices().containsKey(temp2)){
                return true;
            }
        }
        return false;
    }

    public Vertex<V> findVertex(V data) {
        for (Vertex<V> temp : list) {
            if (temp.getData().equals(data)) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Gets adjacent vertices and edge weights for a vertex.
     * @param data Vertex data.
     * @return Map of adjacent vertices and edge weights.
     */
    public Map<Vertex<V>, Double> adjacencyList(V data) {
        return findVertex(data).getAdjacentVertices();
    }

    /**
     * Gets the weight of an edge between two vertices.
     * @param source Source vertex.
     * @param dest Destination vertex.
     * @return Edge weight, or 0 if the edge doesn't exist.
     */
    public double getWeight(V source, V dest) {
        Vertex<V> temp = findVertex(source);
        if (temp != null){
            Vertex<V> temp2 = findVertex(dest);
            if (temp2 != null){
                return temp.getAdjacentVertices().get(temp2);
            }
        }
        return 0;
    }
}
