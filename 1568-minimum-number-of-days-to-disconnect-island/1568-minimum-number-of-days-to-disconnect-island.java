class Solution {
    private int m;
    private int n;
    
    private void dfs(int[][] grid, int i, int j,  boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
    
    private int numberOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int islands = numberOfIsland(grid);
        
        if (islands == 0 || islands > 1) {
            return 0;
        }else {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        
                        islands = numberOfIsland(grid);
                        
                        grid[i][j] = 1;
                        if (islands > 1 || islands == 0) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }
}