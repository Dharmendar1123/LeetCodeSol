class Solution {
    
    private boolean dfs(Map<Integer, List<Integer>> adj, int curr, int[] color, int currColor) {
        color[curr] = currColor;
        
        for (int v : adj.getOrDefault(curr, new ArrayList<>())) {
            
            if (color[v] == color[curr]) {
                return false;
            }
            
            if (color[v] == -1) {
                int colorOfV = 1 - currColor;
                
                if (dfs(adj, v, color, colorOfV) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] row : dislikes) {
            int u = row[0];
            int v = row[1];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        // red = 1;
        // green = 0;
        
        for (int i = 0; i <= n; ++i) {
            if (color[i] == -1) {
                if(dfs(adj, i, color, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}