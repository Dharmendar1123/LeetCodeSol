class Solution {
    
    private void bfs(int u, boolean[] visited, int[][] isConnected) {
        int n = isConnected.length;
        Queue<Integer> que = new LinkedList<>();
        que.offer(u);
        visited[u] = true;
        
        while (!que.isEmpty()) {
            int v = que.poll();
            
            for (int i = 0; i < n; ++i) {
                if (!visited[i] && isConnected[v][i] == 1) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                bfs(i, visited, isConnected);
                count++;
            }
        }
        
        return count;
    }
}