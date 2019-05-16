import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kFactorization {
    static int[] kfactorization(int n, int[] A) {
        int i = A.length - 1;
        int last = n;
        Arrays.sort(A);
        List<Integer> tracker = new ArrayList<Integer>();
        while (n != 1 && i > -1) {
            while (i > -1) {
                if (n % A[i] == 0) {
                    n = n / A[i];
                    tracker.add(n);
                } else {
                    i--;
                }
            }
        }
        if (n != 1)
            return new int[] { -1 };
        else {
            tracker.add(last);
            int[] answer = new int[tracker.size()];
            for (int j = 0; j < tracker.size(); j++) {
                answer[j] = tracker.get(j);
            }
            Arrays.sort(answer);
            return answer;
        }
    }

}
