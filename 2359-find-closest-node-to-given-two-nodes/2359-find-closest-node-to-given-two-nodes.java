class Solution {
    int n;
    
    private void bfs(int[] edges, int node, int[] dist) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        dist[node] = 0;
        
        que.offer(node);
        visited[node] = true;
        
        while (!que.isEmpty()) {
            int top = que.poll();
            int v = edges[top];
            
            if (v != -1 && !visited[v]) {
                visited[v] = true;
                dist[v] = 1 + dist[top];
                que.offer(v);
            }
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        
        int[] dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        
        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);
        
        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; ++i) {
            int maxD = Math.max(dist1[i], dist2[i]);
            
            if (minDistTillNow > maxD) {
                minDistTillNow = maxD;
                minDistNode = i;
            }
        }
        return  minDistNode;
    }
}