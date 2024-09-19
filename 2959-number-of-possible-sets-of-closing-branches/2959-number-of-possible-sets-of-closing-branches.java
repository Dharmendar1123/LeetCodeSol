class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int result = 0;
        
        for (int set = 0; set < (1 << n); ++set) {
            int[][] grid = new int[n][n];
            
            for (int[] row : grid) {
                Arrays.fill(row, (int)1e9);
            }
            
            for (int[] road : roads) {
                int u = road[0];
                int v = road[1];
                int wt = road[2];
                
                if (((set >> u) & 1) == 1 && ((set >> v) & 1) == 1) {
                    grid[u][v] = Math.min(grid[u][v], wt);
                    grid[v][u] = Math.min(grid[v][u], wt);
                }
            }
            
            for (int i = 0; i < n; ++i) {
                grid[i][i] = 0;
            }
            
            for (int via = 0; via < n; ++via) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                    }
                }
            }
            
            boolean valid = true;
            
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) {
                        continue;
                    }
                    
                    if (((set >> i) & 1) == 1 && ((set >> j) & 1) == 1) { 
                        if (grid[i][j] > maxDistance) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            if (valid == true) {
                result++;
            }
        }
        return result;
    }
}