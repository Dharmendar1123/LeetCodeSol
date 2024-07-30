class Solution {
    
    private boolean isCycle(int u, Map<Integer, List<Integer>> adj, boolean[] visited, boolean[] inRec, Stack<Integer> st) {
        visited[u] = true;
        inRec[u] = true;
        
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited[v] && isCycle(v, adj, visited, inRec, st)) {
                return true;
            }else if (inRec[v] == true) {
                return true;
            }
        }
        
        st.push(u);
        inRec[u] = false;
        return false;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] row : prerequisites) {
            int a = row[0];
            int b = row[1];
            
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i] && isCycle(i, adj, visited, inRec, st)) {
                return new int[] {};
            }
        }
        
        int[] result = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            result[i++] = st.pop();
        }
        
        
        return result;
    }
}