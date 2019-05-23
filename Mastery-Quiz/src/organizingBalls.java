import java.util.Arrays;

public class organizingBalls {
	static String organizingContainers(int[][] container) {
		if (IsPossible(container)) {
			return "Possible";
		} else {
			return "Impossible";
		}
	}

	static Boolean IsPossible(int[][] matrix) {
		int[] containers = new int[matrix.length];
		int[] ballstypes = new int[matrix[0].length];
		for (int i = 0; i < containers.length; i++) {
			containers[i] = sum(matrix[i], 0, 0);
		}
		for (int j = 0; j < ballstypes.length; j++) {
			ballstypes[j] = sumVertical(matrix, 0, j, 0);
		}
		Arrays.sort(containers);
		Arrays.sort(ballstypes);
		for (int z = 0; z < containers.length; z++) {
			if (ballstypes[z] != containers[z]) {
				return false;
			}
		}
		return true;
	}

	static int sum(int[] array1, int index, int sum) {
		if (index == array1.length) {
			return sum;
		}
		return sum(array1, index + 1, sum + array1[index]);
	}

	static int sumVertical(int[][] matrix2, int indexY, int indexX, int sum) {
		if (indexY == matrix2.length) {
			return sum;
		}
		return sumVertical(matrix2, indexY + 1, indexX, sum + matrix2[indexY][indexX]);
	}

}
