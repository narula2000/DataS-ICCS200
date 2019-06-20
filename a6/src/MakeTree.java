import java.util.Arrays;

public class MakeTree {
	public static BinaryTreeNode buildBST(int[] keys){
		Arrays.sort(keys); // O( n * log n )
		BinaryTreeNode tree = new BinaryTreeNode(keys[keys.length/2]);
		 treeMaker(keys,0,keys.length/2 - 1,keys.length/2 + 1,keys.length-1, tree);
	}
	public static BinaryTreeNode treeMaker(int[] keys, int lowL, int highL, BinaryTreeNode T){
		if (lowL > highL) return T;
		else{
		int mediumL = (lowL + highL)/2;
		T.left.key = keys[mediumL];
		treeMaker(keys,lowL,mediumL-1,mediumL+1,highL,T.left);
		return T;
	}

	public static BinaryTreeNode treeMaker(int[] keys, int lowL, int highL, int lowR, int highR, BinaryTreeNode T){
		if (lowL > highL) return T;
		if (lowR > highR) return T;
		else{
			int mediumL = (lowL + highL)/2;
			int mediumR = (lowR + highR)/2;
			T.left.key = keys[mediumL];
			T.right.key = keys[mediumR];
			treeMaker(keys,lowL,mediumL-1,mediumL+1,highL,T.left);
			treeMaker(keys,lowR,mediumR-1,mediumR+1,highR,T.right);}
		return T;
	}
	public static void main(String[] args) {
		int[] keys = new int[9];
		keys[0] = 1;
		keys[1] = 2;
		keys[2] = 3;
		keys[3] = 4;
		keys[4] = 5;
		keys[5] = 6;
		keys[6] = 7;
		keys[7] = 8;
		keys[8] = 9;
		System.out.println(buildBST(keys));
	}
}
