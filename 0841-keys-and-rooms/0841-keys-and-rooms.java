class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        que.offer(0);
        visited[0] = true;
        
        while (!que.isEmpty()) {
            int node = que.poll();
            
            for (int v : rooms.get(node)) {
                if (!visited[v]) {
                    que.offer(v);
                    visited[v] = true;
                }
            }
        }
        
        for (boolean temp : visited) {
            if (temp == false) {
                return false;
            }
        }
        return true;
    }
}