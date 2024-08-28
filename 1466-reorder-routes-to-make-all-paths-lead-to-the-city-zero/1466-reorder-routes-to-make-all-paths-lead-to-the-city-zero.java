class Solution {
    
    private void dfs(int u, int parent, List<int[]>[] adj, int[] ans) {
        
        for (int[] node : adj[u]) {
            int v = node[0];
            int check = node[1];
            
            if (v != parent) {
                if (check == 1) {
                    ans[0]++;
                }
                dfs(v, u, adj, ans);
            }
        }
    }
    
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(new int[] {v, 1});
            adj[v].add(new int[] {u, 0});
        }
        
        int[] ans = new int[1];
        
        dfs(0, -1, adj, ans);
        
        return ans[0];
    }
}