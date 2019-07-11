import graph.WeightedEdge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectHiding {
	public static int bestSpotDistance(int n, List<WeightedEdge> flights) {
		return 0;
	}


	public static WeightedEdge Edge(int u, int v, int c) {
		return new WeightedEdge(u, v, c);
	}

	public static void main(String[] args) {
		List<WeightedEdge> flights = new ArrayList<>(Arrays.asList(
				Edge(1, 4, 3),
				Edge(4, 2, 8),
				Edge(4, 3, 3),
				Edge(3, 5, 4),
				Edge(1, 6, 9),
				Edge(6, 7, 1)));
		int n = 7;
		int expcted = 11;
		boolean verdict = bestSpotDistance(n, flights) == expcted;
		System.out.println("verdict: " + verdict);
	}

}
