class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int distance = road[2];
            
            adj[u].add(new int[] {v, distance});
            adj[v].add(new int[] {u, distance});
        }
        
        int ans = Integer.MAX_VALUE;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {1, Integer.MAX_VALUE});
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        while (!que.isEmpty()) {
            int[] top = que.poll();
            int u = top[0];
            int dist = top[1];
                
            for (int[] v : adj[u]) {
                int node = v[0];
                int d = v[1];
                
                ans = Math.min(ans, d);
                
                if (!visited[node]) {
                    que.offer(new int[] {node, d});
                    visited[node] = true;
                }
            }
        }
        return ans;
    }
}