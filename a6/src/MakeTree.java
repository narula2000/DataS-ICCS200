import java.util.Arrays;

public class MakeTree {
	public static BinaryTreeNode buildBST(int[] keys) {
		Arrays.sort(keys); // O( n * log n )
		int medium = (keys.length-1) /2;
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
			if (low > medium-1) return new BinaryTreeNode(
					null,
					keys[medium],
					treeMaker(keys, medium + 1, high));

			if (medium + 1 > high ) return new BinaryTreeNode(
					treeMaker(keys, low, medium - 1),
					keys[medium],
					null);

			return new BinaryTreeNode(
					treeMaker(keys, low, medium - 1),
					keys[medium],
					treeMaker(keys, medium + 1, high));
		}
	}


	public static void main(String[] args) {
		int[] keys = new int[10];
		keys[0] = 1;
		keys[1] = 2;
		keys[2] = 6;
		keys[3] = 7;
		keys[4] = 5;
		keys[5] = 3;
		keys[6] = 8;
		keys[7] = 4;
		keys[8] = 9;
		keys[9] = 10;
		printInOrder(buildBST(keys));
	}



	static void printInOrder(BinaryTreeNode T){
		if (T==null) return;
		printInOrder(T.left);
		System.out.print(T.key + " ");
		printInOrder(T.right);
	}
}
