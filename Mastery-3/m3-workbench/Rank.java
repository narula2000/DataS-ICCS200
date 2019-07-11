import java.util.*;

public class Rank {
    public static Long quickRank(TreeMap<Long, Integer> hist, int i) {
        return 0L;
    }
    public static void main(String[] args) {
        TreeMap<Long, Integer> input0 = new TreeMap<>();
        input0.put(1L, 5);
        input0.put(2L, 200);
        input0.put(3L, 7);
        Long expcted0 = 2L;

        TreeMap<Long, Integer> input1 = new TreeMap<>();
        input1.put(1L, 2);
        input1.put(2L, 5);
        input1.put(3L, 1);
        input1.put(4L, 9999);
        Long expcted1 = 4L;

        System.out.println("verdict: "+ (quickRank(input0, 100)==expcted0));
        System.out.println("verdict: "+ (quickRank(input1, 6)==expcted1));
    }
}
