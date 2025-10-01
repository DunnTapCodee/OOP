import static java.lang.Math.max;
import static java.lang.Math.min;

public class CharGrid {
    private char[][] grid;
    private int rows;
    private int cols;

    public CharGrid(char[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, grid[i], 0, cols);
        }
    }

    int charArea(char ch){
        int max_row = 0; int min_row = rows - 1;
        int max_col = 0; int min_col = cols - 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == ch){
                    max_row = max(max_row, i); min_row = min(min_row, i);
                    max_col = max(max_col, j); min_col = min(min_col, j);
                }
            }
        }

        int width = max_col - min_col + 1; int height = max_row - min_row + 1;
        return width*height;
    }

    int countPlus()
    {
        int res = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                char c = grid[i][j];
//                if (c == ' ') continue;
                int up = 0; int down = 0; int left = 0; int right = 0;
                for (int up_i = i - 1; up_i >= 0; up_i--)
                    if (grid[up_i][j] == c) up++;

                for (int down_i = i + 1; down_i < rows; down_i++)
                    if (grid[down_i][j] == c) down++;

                for (int right_j = j + 1; right_j < cols; right_j++)
                    if (grid[i][right_j] == c) right++;

                for (int left_j = j - 1; left_j >= 0; left_j--)
                    if (grid[i][left_j] == c) left++;

                if (up >= 2 && down >= 2 && left >= 2 && right >= 2) res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        char[][] data = {
                {'c', 'a', 'x'},
                {'b', ' ', 'b'},
                {' ', ' ', 'a'}
        };
        char[][] data2 = {
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ','X',' ',' ',' ',' '},
                {' ',' ','X',' ',' ',' ',' '},
                {'X','X','X','X','X',' ',' '},
                {' ',' ','X',' ',' ',' ',' '},
                {' ',' ','X',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '}
        };
        CharGrid grid = new CharGrid(data);
        CharGrid grid2 = new CharGrid(data2);
        System.out.println("Res = " + grid.charArea('c'));
        System.out.println("Res = " + grid2.countPlus());
    }

}
