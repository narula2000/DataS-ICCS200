import java.util.*;

public class LostItems {
    public static int[] lostItems(int[] a, int b[]) {
        int[] counterB = new int[16385];
        int[] counterA = new int[16385];
        List<Integer> answer = new ArrayList<>();
        for (int value : b) counterB[value]++;
        for (int value : a) counterA[value]++;
        for (int i = 0; i < counterB.length; i++){
            if (counterA[i] != counterB[i]) answer.add(i);
        }
        int[] A = new int[answer.size()];
        for (int i = 0; i<answer.size(); i++) A[i] = answer.get(i);
      return A;
    }

    public static void main(String[] args) {
        int[] inA = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] inB = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int[] expected = {204, 205, 206};

        int[] yourOutput = lostItems(inA, inB);
        System.out.println("verdict: "+Arrays.equals(yourOutput, expected));
    }
}
