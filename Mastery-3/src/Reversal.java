import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Reversal {
	public static Map<Integer, Set<Integer>> reverseGraph(Map<Integer, Set<Integer>> G) {
		Set<Integer> map = G.keySet();
		HashMap<Integer, Set<Integer>> Answer = new HashMap<>();
		for (Integer values : map) {
			Set<Integer> val = G.get(values);
			for (Integer key : val) {
				if (!Answer.containsKey(key)) {
					Set<Integer> M = new HashSet<>();
					M.add(values);
					Answer.put(key, M);
				} else {
					Set<Integer> N = Answer.get(key);
					N.add(values);
				}
			}
		}
		return Answer;
	}
}
