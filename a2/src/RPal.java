public class RPal {
    public static int countRPal(int N) {
        int sum = 0;
        if (N == 1) return 1;
        else {
            for (int i = (N + 1) / 2; i > 0; i--) {
                sum += countRPal(i);
            }
        }
        return sum;
    }
}
