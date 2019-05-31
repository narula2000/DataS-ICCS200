public class Stutter {
    public static boolean isSubstr(String test, String tester) {
        int counter = 0;
        for (int i = 0; i < tester.length(); i++) {
            if (test.charAt(counter) == tester.charAt(i)) {
                counter++;
            }
            if (test.length() == counter) {
                return true;
            }
        }
        return false;
    }

    public static String stutter(String A, int k) { // Make a stutter String
        StringBuilder stuttered = new StringBuilder("");
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < k; j++) {
                stuttered.append(A.charAt(i));
            }
        }
        return stuttered.toString();
    }

    public static int maxStutter(String a, String b) {

        int m = b.length();
        int n = a.length();
        int max = m / n; // Most possible substring it can has

        return helperMS(a, b, 0, max);

    }

    public static int helperMS(String a, String b, int low, int up) {
        if (low - up >= -1)
            return low; // If A > B return 0 also keep tracks of how many iteration it has gone
        else {
            if (isSubstr(stutter(a, (low + up) / 2), b)) { // Check if stutter String in is Sub
                return helperMS(a, b, (low + up) / 2, up); // Increase k by half of max
            } else
                return helperMS(a, b, low, (low + up) / 2); // Decrease k by half of max
        }
    }
}
