import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;

public class LostItems {
    public static int[] lostItems(int[] a, int b[]) {
        List<Integer> ans = new ArrayList<>();
        int[] countA = countSort(a); //this i gues take O(n)
        int[] countB = countSort(b);
        for(int i=0; i< countA.length;i++){
            if(!(countA[i]==countB[i])){
                ans.add(i);
            }
        }
        return toArray(ans); //this take(O(n))
    }
    static int[] toArray(List<Integer> a){
        int[] ans = new int[a.size()];
        for (int i =0; i < a.size();i++){
            ans[i] = a.get(i);
//            System.out.println("each "  + ans[i]);
        }
//        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] inA = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] inB = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int[] expected = {204, 205, 206};
        int[] yourOutput = lostItems(inA, inB);
        System.out.println("verdict: " + Arrays.equals(yourOutput, expected));
    }
    
    public static int[] countSort(int[] a) {
        int[] counts = new int[16385];
        for (int i = 0; i < a.length; i++) {
            counts[a[i]]++;
        }
        return counts;
    }
}
