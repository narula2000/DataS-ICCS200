import java.util.*;

public class ClosestSquares {

    public static int closestSquares(int[] a) {
        Arrays.sort(a);
        int checker;
        int answer;
        long[] lowPoint = {Long.MAX_VALUE, 0};
        for (int i = 0; i < a.length-1; i++){
            checker = Arrays.binarySearch(a,-1*a[i]);
            if (checker >= 0 ) {return 0;}
            if ( a[i+1] - a[i] < lowPoint[0]) { lowPoint[0] = a[i+1] - a[i]; lowPoint[1] = i; }
    }
        answer = (int) (Math.pow(a[(int) (lowPoint[1]+1)],2) - Math.pow(a[(int) lowPoint[1]],2));
        return answer;
    }

    public static void main(String[] args) {
        int[] test0 = {5,9,1,11,2,-9};
        int expected = 0;

        System.out.println("verdict: "+(expected==closestSquares(test0)));
    }
}
