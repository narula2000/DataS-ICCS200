import java.util.HashMap;

public class Uproot {
	public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
		HashMap<Integer, Integer> map = new HashMap<>();
		treeToMap(map, T, null);
		return map;
	}

	public static void treeToMap(HashMap<Integer, Integer> map, BinaryTreeNode T, Integer parent) {
		if (T != null) {
			if (parent == null) {
				treeToMap(map, T.left, T.key);
				treeToMap(map, T.right, T.key);
			} else {
				map.put(T.key, parent);
				treeToMap(map, T.left, T.key);
				treeToMap(map, T.right, T.key);
			}
		}
	}
	// Didn't finish the subtask 2
}
