public class Last {
	public static Integer binarySearchLast(int[] a, int k) {
		return binaryHelper(a, k, 0, a.length, null);
	}

	public static Integer binaryHelper(int[] a, int k, int start, int end, Integer answer) {
		if (start >= end) return answer;
		else {
			int mid = (start + end) / 2;
			if (a[mid] == k) return binaryHelper(a, k, mid + 1, end, mid);
			else if (k < a[mid]) return binaryHelper(a, k, start, mid, answer);
			else {
				return binaryHelper(a, k, mid + 1, end, answer);
			}
		}
	}
}


