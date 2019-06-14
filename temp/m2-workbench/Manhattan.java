import java.util.*;

public class Manhattan {
    public static int distanceFromStart(String moves) {
        return 0; // TODO: fix me
    }
    public static void main(String[] args) {
        String test = "NNSEENWWWWN"; // end up at 3 north, 2 west
        int expected = 5;
        System.out.println("verdict: " + (expected==distanceFromStart(test)));
    }
}
