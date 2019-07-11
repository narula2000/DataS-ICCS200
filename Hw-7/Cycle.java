package a7;

import java.util.*;

public class Cycle {
	private static LinkedList<String> dfs(
			HashMap<String, HashSet<String>> table,
			LinkedList<String> pattern,
			HashSet<String> visited,
			String vertex) {
		if (!visited.contains(vertex)) {
			pattern.add(vertex);
			visited.add(vertex);
			for (String w : table.get(vertex)) {
				if (!w.equals(vertex)) dfs(table, pattern, visited, w);
			}
			pattern.remove(pattern.size() - 1);
		} else {
			return pattern;
		}
		return pattern;
	}

	public static List<String> findCycle(ArrayList<Pair<String, String>> graph) {
		HashMap<String, HashSet<String>> neighbour = new HashMap<>();
		HashSet<String> visited = new HashSet<>();
		LinkedList<String> answer = new LinkedList<>();

		for (Pair<String, String> elt : graph) {
			if (!neighbour.containsKey(elt.first)) {
				HashSet<String> empty = new HashSet<>();
				empty.add(String.valueOf(elt.second));
				neighbour.put(elt.first, empty);
			} else {
				HashSet<String> truth = neighbour.get(elt.first);
				truth.add(String.valueOf(elt.second));
			}
		}
		Set<String> vertexes = neighbour.keySet();
		vertexes.removeAll(visited);
		for (String parent : vertexes) {
			dfs(neighbour, answer, visited, parent);
		}
		if (answer.isEmpty()) return null;
		return answer;
	}


}
