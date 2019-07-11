import graph.WeightedEdge;

import java.util.*;

import static graph.WeightedEdge.Edge;

public class RuralRoads {
	public static int totalWeight(List<WeightedEdge> edges) {
		PriorityQueue<WeightedEdge> con = new PriorityQueue<WeightedEdge>(Comparator.comparing());
		int size = con.size();
		int sum = 0;
		HashSet<Integer> visit = new HashSet<>();
		while (visit.size() != size){
			WeightedEdge tmp = con.poll();
			assert tmp != null;
			visit.add(tmp.first);
			visit.add(tmp.second);
			sum += tmp.cost;
		}
		return sum;
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
		boolean verdict = totalWeight(edges) == expected;
		System.out.println("verdict: " + verdict);
	}
}
