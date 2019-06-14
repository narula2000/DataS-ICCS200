import java.util.Arrays;

public class Count {
	public static int count(int[] xs, int k) {
		if (Arrays.binarySearch(xs, k) < 0) return 0;
		int in1 = newSearchLeft(xs, k, 0, xs.length - 1, -1);
		int in2 = newSearchRight(xs, k, 0, xs.length - 1, -1);
		return in2 - in1 + 1;
	}


	static int newSearchRight(int[] array, int k, int low, int up, int index) {
		if (low > up) {
			if (index == -1) {
				return 0;
			}
			return index;
		} else {
			int middle = (low + up) / 2;
			if (array[middle] == k) {
				return newSearchRight(array, k, middle + 1, up, middle);
			} else if (array[middle] > k) {
				return newSearchRight(array, k, low, middle - 1, index);
			} else return newSearchRight(array, k, middle + 1, up, index);
		}

	}

	static int newSearchLeft(int[] array, int k, int low, int up, int index) {
		if (low > up) {
			if (index == -1) {
				return 0;
			}
			return index;
		} else {
			int middle = (low + up) / 2;
			if (array[middle] == k) {
				return newSearchLeft(array, k, low, middle - 1, middle);
			} else if (array[middle] > k) {
				return newSearchLeft(array, k, low, middle - 1, index);
			} else return newSearchLeft(array, k, middle + 1, up, index);
		}

	}


	public static void main(String[] args) {
		int[] xs = {1, 20, 34, 34, 34, 34, 47};
		int[] ys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 34, 34, 34, 34, 35, 47, 47, 47};

		int expcted0 = 4;
		int result0 = count(xs, 34);
		System.out.println("Verdict: " + (result0 == expcted0));

		int expcted1 = 0;
		int result1 = count(xs, 11);
		System.out.println("Verdict: " + (result1 == expcted1));

		int expcted2 = 4;
		int result2 = count(ys, 34);
		System.out.println("Verdict: " + (result2 == expcted2));

		int expcted3 = 3;
		int result3 = count(ys, 47);
		System.out.println("Verdict: " + (result3 == expcted3));
	}
}

