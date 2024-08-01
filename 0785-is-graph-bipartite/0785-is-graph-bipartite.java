class Solution {
    
    private boolean dfs(int[][] graph, int curr, int[] color, int currColor) {
        color[curr] = currColor;
        
        for (int v : graph[curr]) {
            
            if (color[v] == color[curr]) {
                return false;
            }
            
            if (color[v] == -1) {
                int colorOfV = 1 - currColor;
                
                if (dfs(graph, v, color, colorOfV) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        // red = 1;
        // green = 0;
        
        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                if(dfs(graph, i, color, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}