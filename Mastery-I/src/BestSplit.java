import java.util.Arrays;

public class BestSplit {
	public static int bestSplit(int[] a) {
		int len = a.length;
		int[] left;
		int[] right;
		double[] answers = {Double.MAX_VALUE, 0};
		double diff;
		for (int i = 1; i < len; i++) {
			left = Arrays.copyOfRange(a, 0, i);
			right = Arrays.copyOfRange(a, i, a.length);
			diff = Math.pow((sum(left) - sum(right)), 2);
			if (diff < answers[0]) {
				answers[0] = diff;
				answers[1] = i;
			}
		}
		return (int) answers[1];
	}

	static double sum(int[] a) {
		int sum = a[0];
		for (int i = 1; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// todo: make more tests -- no need to hand in your tests
		int[] input0 = {8, 4, 5};
		int[] input1 = {3, 1, 4, 5, 9, 2, 6, 5, 3, 5, 8, 7, 3, 11};
		System.out.println("verdict: " + (1 == bestSplit(input0)));
		System.out.println("verdict: " + (8 == bestSplit(input1)));
	}
}
