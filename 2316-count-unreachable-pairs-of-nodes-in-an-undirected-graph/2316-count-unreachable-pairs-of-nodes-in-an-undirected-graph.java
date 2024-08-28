class Solution {
    
    private void dfs(int u, List<Integer>[] adj, boolean[] visited, long[] size) {
        visited[u] = true;
        size[0]++;
        
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, adj, visited, size);
            }
        }
    }
    
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        boolean[] visited = new boolean[n];
        long result = 0;
        long remaining = n;
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                
                long[] size = new long[1];
                dfs(i, adj, visited, size);
                result += size[0] * (remaining - size[0]);
                remaining -= size[0];
            }
        }
        return result;
    }
}