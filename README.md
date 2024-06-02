# Lab4
 Lab4 assignment for Algorithms and Data Structures course

 The task involved creating own implementation for classes:  Vertex, WeightedGraph, Search, BreadthFirstSearch, DijkstraSearch

 # Included Classes:
 
 ### Vertex
 - **Methods**:
   - `addAdjacentVertex(Vertex<V> destination, double weight)`: Adds an edge to an adjacent vertex with a given weight.
   - `getData()`: Retrieves the data stored in the vertex.
   - `getAdjacentVertices()`: Retrieves adjacent vertices and their edge weights.

 ### WeightedGraph
 - **Methods**:
   - `addVertex(V data)`: Adds a vertex with the given data.
   - `addEdge(V source, V dest, double weight)`: Adds an edge between two vertices with a weight.
   - `getVerticesCount()`: Returns the number of vertices in the graph.
   - `getEdgesCount()`: Returns the number of edges in the graph.
   - `hasVertex(V data)`: Checks if a vertex exists.
   - `hasEdge(V source, V dest)`: Checks if an edge exists between two vertices.
   - `adjacencyList(V data)`: Gets adjacent vertices and edge weights for a vertex.
   - `getWeight(V source, V dest)`: Gets the weight of an edge between two vertices.

 ### Search
 - **Methods**:
   - `hasPathTo(V v)`: Checks if there is a path to the given vertex.
   - `pathTo(V v)`: Returns the path from the source to the given vertex.
   - `getSource()`: Returns the source vertex of the search.

 ### BreadthFirstSearch
 - **Methods**:
   - `BreadthFirstSearch(WeightedGraph<V> graph, V source)`: Constructor that starts BFS from the source vertex.

 ### DijkstraSearch
 - **Methods**:
   - `DijkstraSearch(WeightedGraph<V> graph, V source)`: Constructor that starts Dijkstra's algorithm from the source vertex.
   - `hasPathTo(V v)`: Checks if there is a path from the source to a given vertex.

 # Running the project:
 1. Clone and Open repository
 2. Build the project
 3. Run Main.java class to see the provided examples of all functionality

 The project demonstrates the implementation of graph-related classes and algorithms for use in various applications. Feel free to explore and utilize these classes in your projects or as learning materials for algorithms and data structures!
