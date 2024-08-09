class Solution {
    
    private boolean isMagicGrid(int[][] grid, int r, int c) {
        int[] uni = new int[10];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || uni[num] > 1) {
                    return false;
                }else {
                    uni[num]++;
                }
            }
        }
        
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        for (int i = 0; i < 3; ++i) {
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != sum) {
                return false;
            }
            
            if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != sum) {
                return false;
            }
        }
        
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) {
            return false;
        }
        
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
            return false;
        }
        
        return true;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int col = grid.length;
        
        int count = 0;
        
        for (int i = 0; i <= rows - 3; ++i) {
            for (int j = 0; j <= col - 3; ++j) {
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}