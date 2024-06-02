package Classes;

import java.util.*;

/**
 * Base class for graph search algorithms.
 * Provides common fields and methods.
 *
 * @param <V> the vertex type
 */
public abstract class Search<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    /**
     * Initializes the search with a source vertex.
     * @param source the start vertex
     */
    public Search(V source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path to the given vertex.
     * @param v the vertex to check
     * @return true if there is a path from the source to v
     */
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    /**
     * Returns the path from the source to the given vertex.
     * @param v the vertex to find the path to
     * @return the path from the source to v, or null if no path exists
     */
    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }

    public V getSource() {
        return source;
    }
}
