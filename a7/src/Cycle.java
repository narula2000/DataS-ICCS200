import java.util.*;

public class Cycle {
	public static List<String> findCycle(ArrayList<Pair<String, String>> graph) {
		HashMap<Object, HashSet<String>> table = new HashMap<>();

		for (Pair elt : graph) { // Create Graph
			if (!table.containsKey(elt.first)) { // Add an added key
				HashSet<String> emt = new HashSet<>();
				emt.add(String.valueOf(elt.second));
				table.put(elt.first, emt);
			} else {
				HashSet<String> truth = table.get(elt.first);
				truth.add(String.valueOf(elt.second));
			}
		}

		ArrayList<String> answer = new ArrayList<>();
		HashSet<String> visited = new HashSet<>();
		Set<Object> notV = table.keySet();
		notV.removeAll(visited); // Not Visited Keys
		for (Object parent : notV){
			dfs(table, answer, visited, (String) parent); // Not repeating same graph
		}
		if (answer.isEmpty()) return null;
		return answer;
	}

	private static ArrayList<String> dfs(HashMap<Object, HashSet<String>> table, ArrayList<String> answer, HashSet<String> visited, String parent) {
		if (!visited.contains(parent)) {
			answer.add(parent); // Add checker
			visited.add(parent);
			for (String w : table.get(parent)) {
				if (!w.equals(parent)) dfs(table, answer, visited, w);
			}
			answer.remove(answer.size() - 1); // Remove checker
		} else {
			return answer; // Return if Cycle
		}
		return answer; // Null
	}
}
