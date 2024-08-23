class Solution {
    
    private int dfs(int curr, int parent, List<Integer>[] adj1, List<Boolean> hasApple) {
        int time = 0;
        
        for (int child : adj1[curr]) {
            if (child == parent) {
                continue;
            }
            
            int timeFromChild = dfs(child, curr, adj1, hasApple);
            
            if (timeFromChild > 0 || hasApple.get(child)) {
                time += timeFromChild + 2;
            }
        }
        return time;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer>[] adj1 = new ArrayList[n+1];
        
        for (int i = 0; i < n; ++i) {
            adj1[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            // adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            
            adj1[u].add(v);
            adj1[v].add(u);
        }
        
        return dfs(0, -1, adj1, hasApple);
    }
}