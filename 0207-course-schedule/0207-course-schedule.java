class Solution {
    
    private boolean isCycle(int u, Map<Integer, List<Integer>> adj, boolean[] visited, boolean[] inRec) {
        visited[u] = true;
        inRec[u] = true;
        
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited[v] && isCycle(v, adj, visited, inRec)) {
                return true;
            }else if (inRec[v] == true) {
                return true;
            }
        }
        inRec[u] = false;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];
        
        for (int[] row : prerequisites) {
            int a = row[0];
            int b = row[1];
            
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i] && isCycle(i, adj, visited, inRec)) {
                return false;
            }
        }
        return true;
    }
}