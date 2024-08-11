class Solution {
    
    public void dfs(List<List<Integer>> rooms, int src, boolean[] visited) {
        
        visited[src] = true;
        
        for (int v : rooms.get(src)) {
            if (!visited[v]) {
                dfs(rooms, v, visited);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs(rooms, 0, visited);
        
        for (int i = 0; i < n; ++i) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}