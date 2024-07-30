class Solution {
    
    private void dfs(int u, boolean[] visited, int[][] isConnected) {
        int n = isConnected.length;
        visited[u] = true;
        
        for (int v = 0; v < n; ++v) {
            if (!visited[v] && isConnected[u][v] == 1) {
                dfs(v, visited, isConnected);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }
        
        return count;
    }
}