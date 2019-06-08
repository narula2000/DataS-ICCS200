import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {
	public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
		LinkedList<Integer> answer = new LinkedList<>();
		PriorityQueue<LinkedList<Integer>> sorter = new PriorityQueue<>(Comparator.comparing(LinkedList<Integer>::peek));

		int times = 0;
		for (LinkedList<Integer> list : lists) {
			sorter.add(list);
			times += list.size();
		}
		while (times > 0) {
			if (sorter.peek() != null) {
				LinkedList<Integer> temp = sorter.poll();
				answer.add(temp.poll());
				if (!temp.isEmpty()) {
					sorter.add(temp);
				}
			}
			times--;
		}
		return answer;
	}
}

