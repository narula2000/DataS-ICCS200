import java.util.ArrayList;
import java.util.List;

// Sherlock and Array HackerRank.
public class hackerrank {
    static String balancedSums(List<Integer> arr) {
        String answer = "NO";
        int sum = 0;
        if (arr.size() == 1) answer = "YES";
        int allSum = arr.stream().mapToInt(Integer::intValue).sum();
        for (int i = 0; i < arr.size() - 1; i++) {
            sum += arr.get(i);
            if (((sum * 2) + arr.get(i + 1)) == allSum) answer = "YES";
            else if (sum == allSum) answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        System.out.println(balancedSums(test));
    }
}
