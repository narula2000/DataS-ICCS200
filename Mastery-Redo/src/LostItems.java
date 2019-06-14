import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LostItems {
	public static int[] lostItems(int[] a, int b[]) {
		List<Integer> ans = new ArrayList<>();
		int[] countA = countSort(a);
		int[] countB = countSort(b);
		for (int i = 0; i < countA.length; i++) {
			if (countA[i] != countB[i]) {
				ans.add(i);
			}
		}
		return toArray(ans);
	}

	static int[] toArray(List<Integer> a) {
		int[] ans = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			ans[i] = a.get(i);
		}
		return ans;
	}

	public static int[] countSort(int[] a) {
		int[] counts = new int[16385];
		for (int value : a) {
			counts[value]++;
		}
		return counts;

	}

	public static void main(String[] args) {
		int[] inA = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
		int[] inB = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
		int[] expected = {204, 205, 206};
		int[] yourOutput = lostItems(inA, inB);
		System.out.println("verdict: " + Arrays.equals(yourOutput, expected));
	}
}
