public class DoubleTrouble {

	public static int rank(int[] A, int[] B, int e) {

		return rankSearch(A,0,A.length,e)+rankSearch(B,0,B.length,e);
	}

	public static Integer select(int[] A, int[] B, int k) {

		int totalsize = A.length+B.length-1;
		if(totalsize<k || k<0){
			return null;
		}else{
			int rankEltA = selectSearch(A,B,k,0,A.length-1,A);
			if(rankEltA>-1){
				return rankEltA;
			}else return selectSearch(A,B,k,0,B.length-1,B);
		}
	}

	public static int selectSearch(int[] arrayA, int[] arrayB, int k, int indexL, int indexH, int[] searching){
		if(indexL>=indexH){
			if(rank(arrayA,arrayB,searching[indexL])==k) {
				return searching[indexL];
			}else return -1;
		}else{
			int mid = (indexH+indexL)/2;
			int midrank = rank(arrayA,arrayB,searching[mid]);
			if(midrank<k){
				return selectSearch(arrayA, arrayB, k,mid+1, indexH, searching);
			}else{
				return selectSearch(arrayA, arrayB, k, indexL, mid, searching);
			}
		}
	}

	public static int rankSearch(int[] m, int indexL, int indexH, int k) {
		if (indexH == indexL) {
			return indexL;
		} else {
			int mid = (indexH + indexL) / 2;
			if (m[mid] < k) {
				return rankSearch(m,mid+1,indexH,k);
			} else {
				return rankSearch(m,indexL,mid,k);
			}
		}
	}
}

