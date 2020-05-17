public class num_island {
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            for (int i = 0 ; i < grid.length ; i++) {
                for (int j = 0 ; j < grid[0].length ; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        helper(i , j , grid);//置0；
                    }
                }
            }
            return res;
        }
        public void helper (int row , int column , char[][] grid) {
            if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length
                    || grid[row][column] == '0') {
                return;
            }
            grid[row][column] = '0';
            helper(row + 1, column , grid);
            helper(row - 1, column , grid);
            helper(row , column + 1 , grid);
            helper(row , column - 1 , grid);
        }
    }
}
