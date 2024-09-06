class Solution {
    int n;
    
    private int bfs(int u, List<Integer>[] adj) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(u);
        
        // Set<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[n];
        // visited.add(u);
        visited[u] = true;
        int count = 1;
        
        while (!que.isEmpty()) {
            int top = que.poll();
            
            for (int v : adj[top]) {
                if (!visited[v]) {
                    que.offer(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                
                if (i == j) {
                    continue;
                }
                
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];
                
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];
                
                //Math.sqrt();
                long distance = ((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1));
                
                if ((long)(r1 * r1) >= distance) {
                    adj[i].add(j);
                }
            }
        }
        
        int result = 0;
        
        
        for (int i = 0; i < n; ++i) {
           
             int count = bfs(i, adj);
            
            result = Math.max(result, count);
            
        }
        return result;
    }
}