class Solution {
    
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }
        
        if (grid2[i][j] != 1) {
            return true;
        }
        
        grid2[i][j] = -1;
        
        boolean result = (grid1[i][j] == 1);
        
        result = result & isSubIsland(grid1, grid2, i-1, j);
        result = result & isSubIsland(grid1, grid2, i+1, j);
        result = result & isSubIsland(grid1, grid2, i, j-1);
        result = result & isSubIsland(grid1, grid2, i, j+1);
        
        return result;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        int subIsland = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j)) {
                    subIsland++;
                }
            }
        }
        return subIsland;
    }
}