class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }
        
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0});
        grid[0][0] = 1;
        
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            
            while (size-- > 0) {
                int[] curr = que.poll();
                int x = curr[0];
                int y = curr[1];
                
                if (x == m-1 && y == n-1) {
                    return level+1;
                }
                
                for (int[] dir : directions) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
                    
                    if (x_ >= 0 && x_ < m && y_ >=0 && y_ < n && grid[x_][y_] == 0) {
                        que.offer(new int[] {x_, y_});
                        grid[x_][y_] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}