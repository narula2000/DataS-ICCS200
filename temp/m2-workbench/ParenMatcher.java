import java.util.*;

public class ParenMatcher {

    public static int[] match(String ex) {
        return null; // TODO: implement me
    }

    public static void main(String[] args) {
        String st = "()(()(()))";
        int[] expcted = {1, -1, 7, 1, -1, 3, 1, -1, -3, -7};
        int[] result = match(st);

        System.out.println("Verdict: "+ Arrays.equals(expcted, result));
        // TODO: Write a lot more tests
    }
}
