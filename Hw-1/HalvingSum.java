import java.util.Arrays;

public class HalvingSum {
    public static double hsum(double[] X) {
        while (X.length > 1) {
            double[] Y = new double[X.length / 2];
            for (int i = 0; i <= X.length; i++) {
                Y[i] = (int) (X[2 * i] + X[2 * i + 1]);
            }
            X = Arrays.copyOf(Y, Y.length);
        }
        return X[0];
    }
}
