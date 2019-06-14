import java.util.Arrays;

public class ClosestSquares {

    public static int closestSquares(int[] a) {
        long ans = Integer.MAX_VALUE;
        long diff;
        for(int i=0; i<a.length-1;i++){
        if(a[i] <0) a[i] =-a[i];
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            diff = diffsquared(a[i] * a[i], a[i + 1] * a[i + 1]);
            if (diff < ans)
                ans = diff;
        }
        return(int)ans;
    }

    public static long diffsquared( long a,long b){
        long diff;
        if(a>b){
         diff = a-b;}
        else{
            diff = b-a;
        }
        return diff;
    }
    public static void main(String[] args) {
        int[] test0 = {-20,-3916237, -357920, -3620601,
                7374819, -7330761, 30, 6246457, -6461594, 266854};
        int expected = 500;

        System.out.println("verdict: "+(expected==closestSquares(test0)));
    }
}
