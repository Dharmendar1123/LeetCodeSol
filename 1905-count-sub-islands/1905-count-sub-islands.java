class Solution {
    
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        boolean result = true;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {i, j});
        grid2[i][j] = -1;
        
        while (!que.isEmpty()) {
            int[] top = que.poll();
            
            int x = top[0];
            int y = top[1];
            
            if (grid1[x][y] != 1) {
                result = false;
            }
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1) {
                    grid2[newX][newY] = -1;
                    que.offer(new int[] {newX, newY});
                }
            }
        }
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