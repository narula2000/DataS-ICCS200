public class DoubleTrouble {

	public static int rank(int[] A, int[] B, int e) {
		return rankSearch(A, 0, A.length, e) + rankSearch(B, 0, B.length, e);
	}

	public static Integer select(int[] A, int[] B, int k) {
		int size = A.length + B.length - 1;
		if (size < k || k < 0) {
			return null;
		} else {
			int rankEltA = selectSearch(A, B, k, 0, A.length - 1, A);
			if (rankEltA > -1) {
				return rankEltA;
			} else return selectSearch(A, B, k, 0, B.length - 1, B);
		}
	}

	public static int rankSearch(int[] m, int L, int H, int k) {
		if (H == L) {
			return L;
		} else {
			int midGuy = (H + L) / 2;
			if (m[midGuy] < k) {
				return rankSearch(m, midGuy + 1, H, k);
			} else {
				return rankSearch(m, L, midGuy, k);
			}
		}
	}


	public static int selectSearch(int[] arrayA, int[] arrayB, int k, int L, int H, int[] searching) {
		if (L >= H) {
			if (rank(arrayA, arrayB, searching[L]) == k) {
				return searching[L];
			} else return -1;
		} else {
			int midGuy = (H + L) / 2;
			int midRank = rank(arrayA, arrayB, searching[midGuy]);
			if (midRank < k) {
				return selectSearch(arrayA, arrayB, k, midGuy + 1, H, searching);
			} else {
				return selectSearch(arrayA, arrayB, k, L, midGuy, searching);
			}
		}
	}
}

