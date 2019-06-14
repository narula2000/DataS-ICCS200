import java.util.*;

public class Count {
    public static int count(int[] xs, int k) {
        return -1; // TODO: Implement me
    }

    public static void main(String[] args) {
        int[] xs = {1, 20, 34, 34, 34, 34, 47};
        int[] ys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 34, 34, 34, 34, 35, 47, 47, 47};

        int expcted0 = 4;
        int result0 = count(xs, 34);
        System.out.println("Verdict: " + (result0==expcted0));

        int expcted1 = 0;
        int result1 = count(xs, 11);
        System.out.println("Verdict: " + (result1==expcted1));

        int expcted2 = 4;
        int result2 = count(ys, 34);
        System.out.println("Verdict: " + (result2==expcted2));

        int expcted3 = 3;
        int result3 = count(ys, 47);
        System.out.println("Verdict: " + (result3==expcted3));
    }
}
