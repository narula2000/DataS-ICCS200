public class FraudulentActivity {
    static int activityNotifications(int[] expenditure, int d) { // trying to use int[] for speed
        int[] frequency = new int[201]; // Maximum value is 200
        double median;
        int answer = 0;
        for (int j = 0; j < d; j++) {
            frequency[expenditure[j]]++;
        }

        if (d % 2 == 0) { // EVEN length
            for (int l = d; l < expenditure.length; l++) {
                median = findMedianEven(frequency, d);
                if (expenditure[l] >= 2 * median) {
                    answer++;
                }
                frequency[expenditure[l - d]] -= 1;
                frequency[expenditure[l]] += 1;
            }
        } else { // ODD length
            for (int m = d; m < expenditure.length; m++) {
                median = findMedianOdd(frequency, d);
                if (expenditure[m] >= 2 * median) {
                    answer++;
                }
                frequency[expenditure[m - d]] -= 1;
                frequency[expenditure[m]] += 1;
            }
        }
        return answer;
    }

    static double findMedianEven(int[] frequency, double d) {
        double totalLeft = 1;
        double totalRight = 0;
        for (int i = 0; i < frequency.length; i++) {
            totalLeft += frequency[i];
            if (totalLeft > d / 2) {
                totalLeft = i;
                break;
            }
        }
        for (int j = 0; j < frequency.length; j++) {
            totalRight += frequency[j];
            if (totalRight > d / 2) {
                totalRight = j;
                break;
            }
        }
        return (totalLeft + totalRight) / 2;
    }

    static double findMedianOdd(int[] frequency, double d) {
        double total = 0;
        for (int i = 0; i < frequency.length; i++) {
            total += frequency[i];
            if (total > d / 2) {
                return i;
            }
        }
        return -1;
    }

}
