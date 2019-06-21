import java.util.ArrayList;
import java.util.List;

public class Decor {
	static Comp check = new Comp();

	public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {
		int midP = (postOrder.size() - 1) / 2;
		int midO = (inOrder.size() - 1) / 2;
		if (midO % 2 != 0) midO++;

		BinaryTreeNode postO = new BinaryTreeNode(
				postMaker(postOrder, 0, midP),
				postOrder.get(postOrder.size() - 1),
				postMaker(postOrder, midP + 1, postOrder.size() - 2));

		BinaryTreeNode inO = new BinaryTreeNode(
				inMaker(inOrder, 0, midO - 1),
				inOrder.get(midO),
				inMaker(inOrder, midO + 1, inOrder.size() - 1));

		compareTree(postO, inO);
		printOrder(inO);
		printOrder(postO);
		if (check.found) return postO;
		else return null;
	}

	private static void compareTree(BinaryTreeNode postO, BinaryTreeNode inO) {
		if (postO.key != inO.key) check.Notify();
		else {
			compareTree(postO.left, inO.left);
			compareTree(postO.right, inO.right);
		}
	}

	public static BinaryTreeNode inMaker(List<Integer> keys, int low, int high) {
		if (low == high) return new BinaryTreeNode(keys.get(low));
		else {
			int medium = (low + high) / 2;
			if (high - low % 2 != 0) medium++;
			if (high - low == 2) return new BinaryTreeNode(
					new BinaryTreeNode(keys.get(low)),
					keys.get(medium),
					new BinaryTreeNode(keys.get(high))
			);
			if (low > medium - 1) return new BinaryTreeNode(
					null,
					keys.get(medium),
					inMaker(keys, medium + 1, high));

			if (medium  >= high) return new BinaryTreeNode(
					inMaker(keys, low, medium - 1),
					keys.get(medium),
					null);

			return new BinaryTreeNode(
					inMaker(keys, low, medium - 1),
					keys.get(medium),
					inMaker(keys, medium + 1, high));
		}
	}

	public static BinaryTreeNode postMaker(List<Integer> keys, int low, int high) {
		if (low == high) return new BinaryTreeNode(keys.get(low));
		if (high - low == 2)
			return new BinaryTreeNode(
					new BinaryTreeNode(keys.get(low)),
					keys.get((low + high) / 2),
					new BinaryTreeNode(keys.get(high)));
		else {
			int medium = (low + high) / 2;

			if (low > medium) return new BinaryTreeNode(
					null,
					keys.get(high),
					postMaker(keys, medium + 1, high - 1));

			/*if (medium + 1 > high - 1) return new BinaryTreeNode(
					postMaker(keys, low, medium),
					keys.get(high),
					null);*/

			return new BinaryTreeNode(
					postMaker(keys, low, medium),
					keys.get(high),
					postMaker(keys, medium + 1, high - 1));
		}
	}

	public static void main(String[] args) {
		List<Integer> keyA = new ArrayList<>();
		List<Integer> keyB = new ArrayList<>();
		keyA.add(0);
		keyB.add(0);
		keyA.add(1);
		keyB.add(2);
		keyA.add(2);
		keyB.add(1);
		keyA.add(3);
		keyB.add(4);
		keyA.add(4);
		keyB.add(3);
		printOrder(mkTree(keyA, keyB));
	}

	static void printOrder(BinaryTreeNode T) {
		if (T == null) return;
		printOrder(T.left);
		System.out.print(T.key + " ");
		printOrder(T.right);
	}
}
