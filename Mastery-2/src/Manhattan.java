public class Manhattan {
	public static int distanceFromStart(String moves) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) == 'N') y++;
			if (moves.charAt(i) == 'S') y--;
			if (moves.charAt(i) == 'E') x++;
			if (moves.charAt(i) == 'W') x--;
		}
		return Math.abs(x) + Math.abs(y);
	}

	public static void main(String[] args) {
		String test = "NNSEENWWWWN"; // end up at 3 north, 2 west
		int expected = 5;
		System.out.println("verdict: " + (expected == distanceFromStart(test)));
	}
}
