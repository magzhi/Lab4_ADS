package Classes;

import java.util.*;

/**
 * Implements Breadth-First Search (BFS) for graphs.
 * Extends the abstract Search class.
 *
 * @param <V> the vertex type
 */
public class BreadthFirstSearch<V> extends Search<V> {

    /**
     * Creates a BFS instance and starts BFS from the source vertex.
     * @param graph the graph to search
     * @param source the start vertex
     */
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, graph.findVertex(source));
    }

    /**
     * Executes BFS using a queue.
     * @param graph the graph to search
     * @param current the start vertex
     */
    private void bfs(WeightedGraph<V> graph, Vertex<V> current) {
        marked.add(current.getData());

        Queue<V> queue = new LinkedList<>();
        queue.add(current.getData());

        while (!queue.isEmpty()) {
            V v = queue.remove();

            for (Vertex<V> neighbor : graph.adjacencyList(v).keySet()) {
                if (!marked.contains(neighbor.getData())) {
                    marked.add(neighbor.getData());
                    edgeTo.put(neighbor.getData(), v);
                    queue.add(neighbor.getData());
                }
            }
        }
    }
}
