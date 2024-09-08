class Solution {
    
    private boolean isCycle(int u, boolean[] visited, boolean[] inRecursion, int[][] graph) {
        visited[u] = true;
        inRecursion[u] = true;
        
        for (int v : graph[u]) {
            if (!visited[v] && isCycle(v, visited, inRecursion, graph)) {
                return true;
            }else if (inRecursion[v]) {
                return true;
            }
        }
        
        inRecursion[u] = false;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        boolean[] visited = new boolean[n];;
        boolean[] inRecursion = new boolean[n];
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                isCycle(i, visited, inRecursion, graph);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            if (inRecursion[i] == false) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}