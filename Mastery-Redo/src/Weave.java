public class Weave {
	public static int numWeaves(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 3) {
			return 1;
		}
		if (n == 4) {
			return 1;
		}
		if (n < 0 || n == 2 || n == 1) {
			return 0;
		} else return numWeaves(n - 3) + numWeaves(n - 4) + numWeaves(n - 11);
	}
}
