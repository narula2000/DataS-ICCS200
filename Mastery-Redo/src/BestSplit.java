public class BestSplit {
	public static int bestSplit(int[] a) {
		int split = 0;
		long left = 0;
		long diff;
		long totalSum = helperSum(a, 0, a.length);
		long mindiff = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			left += a[i];
			diff = diffSquared(left, totalSum - left);
			if (diff < mindiff) {
				mindiff = diff;
				split = i + 1;
			}
		}
		return split;
	}

	public static long diffSquared(long a, long b) {
		long difference = a - b;
		return difference * difference;
	}

	public static long helperSum(int[] array, int start, int end) {
		long sums = 0;
		for (int i = start; i < end; i++) {
			sums += array[i];
		}
		return sums;
	}

}
