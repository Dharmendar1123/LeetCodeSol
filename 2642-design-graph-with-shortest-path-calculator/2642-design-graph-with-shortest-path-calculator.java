class Graph {
    int[][] adj;
    int N;

    public Graph(int n, int[][] edges) {
        N = n;
        adj = new int[N][N];
        
        for (int i = 0; i < n; ++i) {
            Arrays.fill(adj[i], (int)1e9);
            adj[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            adj[u][v] = cost;
        }
        
        for (int via = 0; via < n; ++via) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                adj[i][j] = Math.min(adj[i][j], adj[i][u] + cost + adj[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return adj[node1][node2] == (int)1e9 ? -1 : adj[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */