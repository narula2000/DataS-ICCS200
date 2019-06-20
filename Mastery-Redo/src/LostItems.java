import java.util.ArrayList;
import java.util.List;

public class LostItems {
	public static int[] lostItems(int[] a, int b[]) {
		int[] counterB = new int[16385];
		int[] counterA = new int[16385];
		List<Integer> answer = new ArrayList<>();
		for (int value : b) counterB[value]++;
		for (int value : a) counterA[value]++;
		for (int i = 0; i < counterB.length; i++) {
			if (counterA[i] != counterB[i]) answer.add(i);
		}
		int[] A = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++) A[i] = answer.get(i);
		return A;
	}
}
