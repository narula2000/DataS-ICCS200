import java.util.ArrayList;
import java.util.List;

public class BombremanHackerank {
    private static void filler(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
           grid[i] = grid[i].replace(".","X");
        }

    }

    private static void explode(String[] grid,String[] oriGrid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (oriGrid[i].charAt(j) == 'O') {
                    try {
                        grid[i] = grid[i].substring(0,j-1) + '.' + grid[i].substring(j);
                    } catch (StringIndexOutOfBoundsException e) {
                    } catch (IndexOutOfBoundsException r){}// Left
                    try {
                        grid[i-1] = grid[i-1].substring(0,j) + '.' + grid[i-1].substring(j+1);
                    } catch (StringIndexOutOfBoundsException e) {
                    } catch (IndexOutOfBoundsException r){}// Top
                    try {
                        grid[i] = grid[i].substring(0,j+1) + '.' + grid[i].substring(j+2);
                    } catch (StringIndexOutOfBoundsException e) {
                    }catch (IndexOutOfBoundsException r){} // Right
                    try {
                        grid[i+1] = grid[i+1].substring(0,j) + '.' + grid[i+1].substring(j+1);
                    } catch (StringIndexOutOfBoundsException e) {
                    } catch (IndexOutOfBoundsException r){}// Bottom
                }
            }
        }

    }

    private static void rearange(String[] grid) {
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
        String[] C = grid;
        if (n == 1) return grid;
        if (n % 2 == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    C[i].replace('.', 'O');
                }
                return C; // Filled with bomb.
            }
        }
        // Make 3 to A and 5 to B
        filler(A);
        //for (int i = 0; i < A.length; i++){System.out.println(A[i]);}
        //System.out.println("--");
        explode(A,grid);
        //for (int i = 0; i < A.length; i++){System.out.println(A[i]);}
        //System.out.println("--");
        rearange(A);
        for (int i = 0; i < A.length; i++){System.out.println(A[i]);}
        while (n > 7) {
            n -= 4;
        }
        if (n == 3) return A;
        else {
            String[] B = A;
            filler(B);
            explode(B,A);
            rearange(B);
            return B;
        }
    }

    public static void main(String[] args) {
        String[] A = new String[]{"......."
,"...O..."
,"....O.."
,"......."
        ,"OO....."
        ,"OO....."};
        bomberMan(3,A);
    }
}