import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class exercise2 {

	Set<Integer> nbrsExcluding(UndirectedGraph G, Set<Integer> vtxes, Set<Integer> excl) { // O(S*log(S))
		Set<Integer> union = new TreeSet<>(); // not HashMap
		for (Integer src : vtxes) { // O(S) -> O(S log S)
			for (Integer dst : G.adj(src)) // O(1) -> O(log S)
				if (!excl.contains(dst)) union.add(dst); // O(log S)
		}
		return union;
	}

	Set<Integer> bfs(UndirectedGraph G, int s) { // O(S*log S)
		Set<Integer> frontier = new TreeSet<>(Arrays.asList(s)); // O(1)
		Set<Integer> visited = new TreeSet<>(Arrays.asList(s)); // O(1) -> Size == M
		while (!frontier.isEmpty()) { // O(S log S)
			frontier = nbrsExcluding(G, frontier, visited); // O(S log S)
			visited.addAll(frontier); // O((S-M)*log(S))
		}
		return visited;
	}
}
// bsf Run time is O(S log S) while S is the size of the Collection
