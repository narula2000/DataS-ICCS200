import graph.GraphBuilder;

import java.util.*;
import static graph.GraphBuilder.emptyGraph;
public class Reversal {
    public static Map<Integer, Set<Integer>> reverseGraph(Map<Integer, Set<Integer>> G) {
				return null;
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> G =
                emptyGraph()
                .edge(0,1)
                .edge(2,0)
                .edge(3,2)
                .edge(0,3)
                .edge(3,1)
                .build();
        Map<Integer, Set<Integer>> expected =
                emptyGraph()
                .edge(1,0)
                .edge(0,2)
                .edge(2,3)
                .edge(3,0)
                .edge(1,3)
                .build();
        boolean verdict = GraphBuilder.graphEquals(reverseGraph(G), expected);
        System.out.println("verdict: "+verdict);
    }
}
