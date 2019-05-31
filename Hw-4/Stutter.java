public class Stutter {
    //collaborator: Ink-go, Harvey, Intellij_คริคริ
    public static boolean isSubstr(String a, String b) {
        int counter = 0;
        for (int i = 0; i < b.length(); i++) { //run from i=0 to b.length-()1 in the worst case scenario
            if (a.charAt(counter) == b.charAt(i)) { //takes O(1)
                counter++;
            }
            if (a.length() == counter) { //O(1)
                return true;
            }
        }
        return false;
    } //the running time is O(b.length())

    public static String stutter(String A, int k) {
        StringBuilder stuttered = new StringBuilder(""); //I dont know why the hell my dear collaborator Intellij prefers that I use StringBuilder.....
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < k; j++) {
                stuttered.append(A.charAt(i)); /// here is where it got complained it doesnt want me to do stuttered +=
            }
        }
        return stuttered.toString();
    }

    public static int maxStutter(String a, String b) {


        int m = b.length();
        int n = a.length();
        int max = m / n;

        return helperMaxStutter(a, b, 0, max);

    }

    //    public static int helperMaxStutter(String a, String b,int check, int whereAmI ){
    public static int helperMaxStutter(String a, String b, int low, int up) {
        if (low - up >= -1) return low;
        else {
//            int time = 1;System.out.println(time); time++;
            if (isSubstr(stutter(a, (low + up) / 2), b)) {
                return helperMaxStutter(a, b, (low + up) / 2, up);
            } else return helperMaxStutter(a, b, low, (low + up) / 2);
        }
    }

    public static void main(String[] args) {
        String s = "assadfgfdhjukiluiluilf", stuttthis = "Kanat", a = "ho", b = "hi and hhhhhoeololo jello";
        Stutter stutter = new Stutter();
        System.out.println(stutter.isSubstr("aiif", s));
        System.out.println(stutter.stutter(stuttthis, 3));
        System.out.println(stutter.maxStutter(a, b));
    }

}
