class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        
        result[0][0] = 0;
        pq.offer(new int[] {0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int diff = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            if (x == m-1 && y == n-1) {
                return diff;
            }
            
            for (int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                
                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n) {
                    int absDiff = Math.abs(heights[x][y] - heights[x_][y_]);
                    int maxDiff = Math.max(diff, absDiff);
                    
                    if (result[x_][y_] > maxDiff) {
                        result[x_][y_] = maxDiff;
                        pq.offer(new int[] {maxDiff, x_, y_});
                    }
                }
            }            
        }
        return result[m-1][n-1];
    }
}