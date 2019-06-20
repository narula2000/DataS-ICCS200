import java.util.Arrays;

public class ClosestSquares {

	public static long diffSquared(long a, long b) {
		long diff;
		if (a > b) {
			diff = a - b;
		} else {
			diff = b - a;
		}
		return diff;
	}

	public static int closestSquares(int[] a) {
		long ans = Integer.MAX_VALUE;
		long diff;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < 0) a[i] = -a[i];
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length - 1; i++) {
			diff = diffSquared(a[i] * a[i], a[i + 1] * a[i + 1]);
			if (diff < ans) ans = diff;
		}
		return (int) ans;
	}

}
