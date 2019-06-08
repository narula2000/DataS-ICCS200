import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ExprMonger {
	public static double evalFullyParenthesized(List<String> tokens) {
		// todo: implement me
		return 0.0;
	}

	public static ArrayList augmentExpr(List<String> tokens) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		for (String tok : tokens) {
			switch (tok) {
				case "(":
					break;
				case "+":
				case "-":
				case "*":
				case "/":
				case "**":
					ops.push(tok);
					break;
				case ")":
					String op = ops.pop();
					double v = vals.pop();
					double u = vals.pop();
					vals.push(opr(u, op, v));
					break;
				default:
					vals.push(Double.parseDouble(tok));
					break;
			}
		}
		return new ArrayList<>(Collections.singleton(Double.toString(vals.peek())));
	}
	static double opr(double u, String op, double v) {
		switch (op) {
			case "+":
				return u + v;
			case "-":
				return u - v;
			case "*":
				return u * v;
			case "/":
				return u / v;
			case "**":
				return Math.pow(u,v);
			default:
				return Double.NaN;
		}
	}

	public static double evalExpr(List<String> tokens) {
		// todo: implement me
		return 0.0;
	}
}
