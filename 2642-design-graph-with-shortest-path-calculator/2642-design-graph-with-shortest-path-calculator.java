class Graph {
    List<int[]>[] adj;
    int N;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    public Graph(int n, int[][] edges) {
        N = n;
        adj = new ArrayList[n];
        for (int i = 0; i < N; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            adj[u].add(new int[] {v, cost});
        }
    }
    
    public void addEdge(int[] edge) {
        
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
            
        adj[u].add(new int[] {v, cost});
    }
    
    public int shortestPath(int node1, int node2) {
        
        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        result[node1] = 0;
        pq.offer(new int[] {0, node1});
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int dist = top[0];
            
            for (int[] v : adj[node]) {
                int d = v[1];
                int adjNode = v[0];
                
                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[] {d + dist, adjNode});
                }
            }
        }
        return result[node2] == Integer.MAX_VALUE ? -1 : result[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */