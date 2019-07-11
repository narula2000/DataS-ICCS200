import java.util.*;
import graph.WeightedEdge;
import static graph.WeightedEdge.Edge;

public class RuralRoads {
    public static int totalWeight(List<WeightedEdge> edges) {
        return 0;
    }
    public static void main(String[] args) {
       List<WeightedEdge> edges = new ArrayList<>(Arrays.asList(
            Edge(0, 1, 7),
            Edge(0, 3, 5),
            Edge(1, 3, 9),
            Edge(1, 2, 8),
            Edge(1, 4, 7),
            Edge(2, 4, 5),
            Edge(3, 4, 15),
            Edge(3, 5, 6),
            Edge(4, 5, 8),
            Edge(4, 6, 9),
            Edge(5, 6, 11)));
       int expected = 39;
       boolean verdict = totalWeight(edges)==expected;
			 System.out.println("verdict: "+verdict);
    }
}
