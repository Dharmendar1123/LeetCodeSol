class Solution {
    int ans;
    
    private void dfs(int u, List<int[]>[] adj, boolean[] visited) {
        
        visited[u] = true;
        
        for (int[] v : adj[u]) {
            int node = v[0];
            int dist = v[1];
            
            ans = Math.min(ans, dist);
            
            if (!visited[node]) {
                dfs(node, adj, visited);
            }
        }
    }
    
    public int minScore(int n, int[][] roads) {
        
        List<int[]>[] adj = new ArrayList[n+1];
        
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int distance = road[2];
            
            adj[u].add(new int[] {v, distance});
            adj[v].add(new int[] {u, distance});
        }
        
        ans = Integer.MAX_VALUE;
        
        boolean[] visited = new boolean[n+1];
        
        dfs(1, adj, visited);
        
        return ans;
    }
}