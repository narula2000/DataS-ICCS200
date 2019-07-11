package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphBuilder {
    Map<Integer, Set<Integer>> graph;

    private GraphBuilder() {
        graph = new HashMap<>();
    }
    public static GraphBuilder emptyGraph() {
        return new GraphBuilder();
    }
    public GraphBuilder edge(int u, int v) {
        if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
        graph.get(u).add(v);
        return this;
    }
    public Map<Integer, Set<Integer>> build() {
        return graph;
    }

    public static boolean graphEquals(Map<Integer, Set<Integer>> G, Map<Integer, Set<Integer>> H) {
        return (G==null && H==null) || // both null
            ((G!=null && H!=null) && // neither is null and
             H.keySet().equals(G.keySet()) && // same set of vertices and
             H.keySet().stream() // the neighbors are the same
             .map((Integer u) -> H.get(u).equals(G.get(u)))
             .allMatch(e -> e));

    }
}
