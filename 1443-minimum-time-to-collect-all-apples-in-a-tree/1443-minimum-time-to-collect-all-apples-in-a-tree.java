class Solution {
    
    private int dfs(int curr, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        
        for (int child : adj.getOrDefault(curr, new ArrayList<>())) {
            if (child == parent) {
                continue;
            }
            
            int timeFromChild = dfs(child, curr, adj, hasApple);
            
            if (timeFromChild > 0 || hasApple.get(child)) {
                time += timeFromChild + 2;
            }
        }
        return time;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        return dfs(0, -1, adj, hasApple);
    }
}