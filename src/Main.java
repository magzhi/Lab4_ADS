import Classes.WeightedGraph;
import Classes.BreadthFirstSearch;
import Classes.DijkstraSearch;
import Classes.Search;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(false);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda", weightedGraph);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(weightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda", weightedGraph);
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key, WeightedGraph<String> weightedGraph) {
        double dist = 0.0;
        String prev = "";
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
            if (!prev.equals(""))
                dist += weightedGraph.getWeight(prev, v);
            prev = v;
        }

        System.out.println();
        System.out.println("Total distance is: " + dist);
    }
}
