class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }
        
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        result[0][0] = 0;
        pq.offer(new int[] {0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            for (int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                int  dist = 1;
                
                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n && grid[x_][y_] == 0 && d + dist < result[x_][y_]) {
                    result[x_][y_] = d + dist;
                    pq.offer(new int[] {d + dist, x_, y_});
                    grid[x_][y_] = 1;
                }
            }
        }
        return result[m-1][n-1] == Integer.MAX_VALUE ? -1 : result[m-1][n-1] + 1;
    }
}