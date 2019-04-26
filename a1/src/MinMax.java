public class MinMax {
    public static double minMaxAverage(int[] numbers) {
        int pair = numbers.length;
        int[] maxList;
        int[] minList;
        if (pair % 2 == 0) { // Even length
            maxList = new int[pair / 2];
            minList = new int[pair / 2];
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
        } else { // Odd length
            maxList = new int[(pair / 2) + 1];
            minList = new int[(pair / 2) + 1];
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
            maxList[maxList.length-1] = numbers[numbers.length-1];
            minList[minList.length-1] = numbers[numbers.length-1];
        }
        int myMin = minList[0]; // Min to the first index
        int myMax = maxList[0]; // Max to the first index
        // Max finder
        for (int value : maxList) {
            if (myMax < value) {
                myMax = value;
            }
        }
        // Min finder
        for (int value : minList) {
            if (myMin > value) {
                myMin = value;
            }
        }
        return (myMin + myMax) / 2.0;
    }
}
