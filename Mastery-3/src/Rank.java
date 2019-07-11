import java.util.Set;
import java.util.TreeMap;

public class Rank {
	public static Long quickRank(TreeMap<Long, Integer> hist, int i) {
		Integer tmp = i;
		Long answer = null;
		Set<Long> map = hist.keySet();
		for (Long key : map) {
			Integer compare = hist.get(key);
			if (tmp >= compare && compare >= i) {
				tmp = compare;
				answer = key;
			} else if (compare >= tmp && tmp >= i) {
				tmp = compare;
				answer = key;
			}
		}
		return answer;
	}
}
