import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ParenMatcher {

	public static int[] match(String ex) {
		//if (ex.equals("()(()(()))")) return new int[]{1, -1, 7, 1, -1, 3, 1, -1, -3, -7};
		StringBuilder string = new StringBuilder(ex);
		Stack<Integer> indexs = new Stack<>();
		int[] finale = new int[ex.length()];
		int indexer = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			if (string.charAt(i) == ')') indexs.push(i);
			if (string.charAt(i) == '(') {
				int gap = Math.abs(i - indexs.pop());
				finale[i + gap] = -gap;
				finale[i] = gap;
			}
		}
		return finale;
	}

	public static void main(String[] args) {
		String st = "()(()(()))";
		int[] expcted = {1, -1, 7, 1, -1, 3, 1, -1, -3, -7};
		int[] result = match(st);

		System.out.println("Verdict: " + Arrays.equals(expcted, result));
	}
}
