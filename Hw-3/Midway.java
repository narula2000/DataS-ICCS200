import java.util.Arrays;

public class Midway {
    public static long stepsRemaining(int[] diskPos) {
        return helperFunc(diskPos, 0, 1, 2);
    }

    private static long helperFunc(int[] disk, int Start, int End, int Aux) {
        if (disk.length == 0)
            return 0;
        else {
            if (disk[disk.length - 1] == End)
                return helperFunc(Arrays.copyOfRange(disk, 0, disk.length - 1), Aux, Start, End);
            else {
                return (long) ((long) helperFunc(Arrays.copyOfRange(disk, 0, disk.length - 1), Start, End, Aux)
                        + Math.pow(2, disk.length - 1));
            }
        }
    }
}
