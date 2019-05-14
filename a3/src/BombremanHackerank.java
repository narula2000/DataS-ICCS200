public class BombremanHackerank {
    private static void filler(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                grid[i].replace('.', 'X');
            }
        }
    }

    private static void explode(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == 'O') {
                    if (i == 0) {
                        grid[i] = '.' +'.'+ grid[i].substring(1);
                    }else
                    if (i == grid[i].length() - 1) {
                        grid[i] = grid[i].substring(0, grid[i].length() - 3)+'.' + '.';
                    }else
                    if (i > 1 && j > 1 && i < grid.length-2 && j < grid[i].length()-2) {grid[i]=grid[i].substring(0,j-1)+'.'+grid[i].substring(j+1);}else
                    if (j > 0) ubber(grid[i], j - 1); // Left
                    if (i > 0) subber(grid[i - 1], j); // Top
                    if (j < grid.length - 1) subber(grid[i], j + 1); // Right
                    if (i < grid.length - 1) subber(grid[i + 1], j); // Bottom
                }
            }
        }

    }

    private static void rearange(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                grid[i].replace('X', '.');
            }
        }
    }

    static String[] bomberMan(int n, String[] grid) {
        String[] answer = new String[grid.length];
        int column = grid[0].length();
        int row = grid.length;
        String[] A = grid;
        String[] C = grid;
        if (n == 1) return grid;
        if (n == 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    C[i].replace('.', 'O');
                }
                return C; // Filled with bomb.
            }
        }
        // Make 3,4 to A and 5,6 to B
        filler(A);
        explode(A);
        rearange(A);
        String[] B = A;
        filler(B);
        explode(B);
        rearange(B);
        while (n != 3 || n != 4 || n != 5 || n != 6) {
            n -= 4;
        }
        if (n == 3 || n == 4) return A;
        else {
            return B;
        }
    }
}