public class FraudulentActivity {
	static int activityNotifications(int[] expenditure, int d) { // trying to use int[] for speed
		int[] frequency = new int[201]; // Maximum value is 200
		double median; // I tried using bubble and insertion, it is too slow, and I cheated a bit :P
		int answer = 0; // Using Counting Sort is better, trading space for better time
		for (int j = 0; j < d; j++) { // Like before, get the data and store it at specific index
			frequency[expenditure[j]]++;
		}

		if (d % 2 == 0) { // EVEN length
			for (int k = d; k < expenditure.length; k++) {
				median = findMedianEven(frequency, d);
				if (expenditure[k] >= 2 * median) {
					answer++;
				}
				frequency[expenditure[k - d]] -= 1;
				frequency[expenditure[k]] += 1;
			}
		} else { // ODD length
			for (int k = d; k < expenditure.length; k++) {
				median = findMedianOdd(frequency, d);
				if (expenditure[k] >= 2 * median) {
					answer++;
				}
				frequency[expenditure[k - d]] -= 1;
				frequency[expenditure[k]] += 1;
			}
		}
		return answer;
	}

	static double findMedianEven(int[] frequency, double d) {
		double totalLeft = 1;
		double totalRight = 0; // we count this one -1 because we want the next index after totalleft
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
		// System.out.println(totalleft+" & "+totalright +" =
		// "+(totalleft/2+totalright/2));
		return totalLeft / 2 + totalRight / 2;
	}

	static double findMedianOdd(int[] frequency, double d) {
		double total = 0;
		for (int i = 0; i < frequency.length; i++) {
			total += frequency[i];
			if (total > d / 2) { // if pass the middle value we will count
				total = i;
				break;
			}
		}
		// System.out.println(total);
		return total;
	}

}
