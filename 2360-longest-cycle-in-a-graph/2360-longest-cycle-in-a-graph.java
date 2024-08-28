class Solution {
    
    int result = -1;
    
    private void dfs(int u, int[] edges, boolean[] visited, boolean[] inRec, int[] count) {
        
        if (u != -1) {
            visited[u] = true;
            inRec[u] = true;

            int v = edges[u];
            
            if (v != -1 && !visited[v]) {
                count[v] = count[u] + 1;
                dfs(v, edges, visited, inRec, count);
            }else if (v != -1 && inRec[v] == true) {
                result = Math.max(result, count[u] - count[v] + 1);
            }
            inRec[u] = false;
        }
    }
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] inRec = new boolean[n];
        
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; ++i) {
            if(!visited[i]) {
                dfs(i, edges, visited, inRec, count);
            }
        }
        return result;
    }
}