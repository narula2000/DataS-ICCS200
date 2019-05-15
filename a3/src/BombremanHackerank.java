public class BombremanHackerank {
    private static void filler(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = grid[i].replace(".", "X");
        }
    }

    private static void explode(String[] grid, String[] oriGrid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (oriGrid[i].charAt(j) == 'O') {
                    if (j == 0) {
                        grid[i] = '.' + grid[i].substring(1);
                    }
                    if (j == grid[i].length() - 1) {
                        grid[i] = grid[i].substring(0, j) + '.';
                    }
                    if (j > 0) {
                        grid[i] = grid[i].substring(0, j - 1) + '.' + grid[i].substring(j); // Left
                    }
                    if (j < grid[i].length() - 1) {
                        grid[i] = grid[i].substring(0, j + 1) + '.' + grid[i].substring(j + 1); // Right
                    }
                    if (i < grid.length - 1) {
                        grid[i + 1] = grid[i + 1].substring(0, j) + '.' + grid[i + 1].substring(j + 1); // Bottom
                    }
                    if (i > 0) {
                        grid[i - 1] = grid[i - 1].substring(0, j) + '.' + grid[i - 1].substring(j + 1); // Top
                    }
                    if (j != 0 || j != grid[i].length()) {
                        grid[i] = grid[i].substring(0, j) + '.' + grid[i].substring(j + 1);
                    }
                }
            }
        }
    }

    private static void rearrange(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                grid[i] = grid[i].replace('X', 'O');
            }
        }
    }

    static String[] bomberMan(int n, String[] grid) {
        int column = grid[0].length();
        int row = grid.length;
        String[] A = grid;
        if (n == 1)
            return grid;
        if (n % 2 == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    A[i].replace('.', 'O');
                }
            }
            return A;
        }
        // Make 3 to A and 5 to B
        filler(A);
        explode(A, grid);
        System.out.println(A);
        System.out.println("----------");
        System.out.println(grid);
        rearrange(A);
        while (n > 7) {
            n -= 4;
        }
        if (n == 3)
            return A;
        else {
            String[] B = A;
            filler(B);
            explode(B, A);
            rearrange(B);
            return B;
        }
    }

    public static void main(String[] args) {
        String[] A = new String[] { ".......", "...O...", "....O..", ".......", "OO.....", "OO....." };
        bomberMan(3, A);
    }
}