import java.util.Arrays;

public class MakeTree {
	public static BinaryTreeNode buildBST(int[] keys) {
		Arrays.sort(keys); // O( n * log n )
		int medium = (keys.length - 1) / 2;
		return new BinaryTreeNode(
				treeMaker(keys, 0, medium - 1),
				keys[medium],
				treeMaker(keys, medium + 1, keys.length - 1)
		);
	}

	public static BinaryTreeNode treeMaker(int[] keys, int low, int high) {
		if (low == high) return new BinaryTreeNode(keys[(low + high) / 2]);
		else {
			int medium = (low + high) / 2;
			if (low > medium - 1) return new BinaryTreeNode(
					null,
					keys[medium],
					treeMaker(keys, medium + 1, high));

			if (medium + 1 > high) return new BinaryTreeNode(
					treeMaker(keys, low, medium - 1),
					keys[medium],
					null);

			return new BinaryTreeNode(
					treeMaker(keys, low, medium - 1),
					keys[medium],
					treeMaker(keys, medium + 1, high));
		}
	}
}
