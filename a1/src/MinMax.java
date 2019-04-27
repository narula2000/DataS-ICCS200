public class MinMax {
    public static double minMaxAverage(int[] numbers) {
        int pair = numbers.length;
        int[] maxList;
        int[] minList;
        if (pair % 2 == 0) { // Even length
            maxList = new int[pair / 2];
            minList = new int[pair / 2];
            valueSplitter(numbers, pair, maxList, minList);
        } else { // Odd length
            maxList = new int[(pair / 2) + 1];
            minList = new int[(pair / 2) + 1];
            valueSplitter(numbers, pair, maxList, minList);
            maxList[maxList.length - 1] = numbers[numbers.length - 1];
            minList[minList.length - 1] = numbers[numbers.length - 1];
        }
        int myMin = minList[0]; // Min to the first index
        int myMax = maxList[0]; // Max to the first index
        // Max & Min finder (maxList & minList having same length)
        for (int i = 1; i < maxList.length; i++) {
            if (myMax < maxList[i]) { // Max
                myMax = maxList[i];
            }
            if (myMin > minList[i]) { // Min
                myMin = minList[i];
            }
        }
        return (myMin + myMax) / 2.0;
    }

    private static void valueSplitter(int[] numbers, int pair, int[] maxList, int[] minList) {
        for (int i = 0; i < pair; i++) {
            if (numbers[i] >= numbers[i + pair]) {
                maxList[i] = numbers[i];
                minList[i] = numbers[i + pair];
            }
            if (numbers[i] <= numbers[i + pair]) {
                maxList[i] = numbers[i + pair];
                minList[i] = numbers[i];
            }
        }
    }
}
