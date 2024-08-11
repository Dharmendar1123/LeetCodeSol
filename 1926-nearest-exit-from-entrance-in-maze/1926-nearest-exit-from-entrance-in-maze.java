class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m  = maze.length;
        int n = maze[0].length;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        int steps = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] curr = que.poll();
                int i = curr[0];
                int j = curr[1];
                
                if (!Arrays.equals(curr, entrance) && (i == 0 || i == m-1 || j == 0 || j == n-1)) {
                    return steps;
                }
                
                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && maze[newI][newJ] != '+') {
                        que.offer(new int[] {newI, newJ});
                        maze[newI][newJ] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}