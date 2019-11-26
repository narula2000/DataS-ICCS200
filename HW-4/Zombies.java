import java.lang.reflect.Arrays;
import java.util.Array;
import java.util.Arrays;

public class Zombies {
	public static int countBad(int[] hs) {
		return mergeSort(hs).first;

	}

	public static Pair<Integer, int[]> mergeSort(int[] lst) {

		int n = lst.length;
		if (n <= 1)
			return new Pair<Integer, int[]>(0, lst);
		int[] left = Arrays.copyOfRange(lst, 0, n / 2);
		int[] right = Arrays.copyOfRange(lst, n / 2, n);
		return merge(mergeSort(left), mergeSort(right));
	}

	public static Pair<Integer, int[]> merge(Pair<Integer, int[]> left, Pair<Integer, int[]> right) {
		int counter = 0;
		int temp = left.first + right.first;
		int[] out = new int[left.second.length + right.second.length];
		int leftIndex = 0, rightIndex = 0, outputIndex = 0;
		while (leftIndex < left.second.length && rightIndex < right.second.length) {
			if (left.second[leftIndex] < right.second[rightIndex]) {
				out[outputIndex++] = right.second[rightIndex++];

				counter += left.second.length - leftIndex;
			} else {
				out[outputIndex++] = left.second[leftIndex++];
			}
		}
		while (leftIndex < left.second.length) {
			out[outputIndex++] = left.second[leftIndex++];

		}
		while (rightIndex < right.second.length) {
			out[outputIndex++] = right.second[rightIndex++];
		}
		counter = temp + counter;
		return new Pair<>(counter, out);
	}
}