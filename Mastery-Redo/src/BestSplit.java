public class BestSplit {
    public static int bestSplit(int[] a) {
        // todo: implement me
        int indexSplit=0;
        long left = 0 ,right,diff;
        long totalSum = helpersum(a,0,a.length); //O(n)
        long mindiff = Integer.MAX_VALUE;
        for(int i=0; i<a.length;i++){
            left +=a[i];
           diff = diffsquared(left,totalSum-left);
            if(diff<mindiff){
                mindiff = diff;
                indexSplit = i+1;
            }
        }
        return indexSplit;


    }
    public static long helpersum(int[] array, int start, int end){
        long sum = 0;
        for (int i=start; i< end; i++){
            sum+= array[i];
        } return sum;
    }
    public static long diffsquared( long a,long b){
        long diff = a-b;
        return diff*diff;
    }
    public static void main(String[] args) {
        // todo: make more tests -- no need to hand in your tests
        int[] input0 = {8, 4, 5};
        int[] input1 = {3, 1, 4, 5, 9, 2, 6, 5, 3, 5, 8, 7, 3, 11};
        System.out.println("verdict: " + (1==bestSplit(input0)));
        System.out.println("verdict: " + (8==bestSplit(input1)));
    }
}
