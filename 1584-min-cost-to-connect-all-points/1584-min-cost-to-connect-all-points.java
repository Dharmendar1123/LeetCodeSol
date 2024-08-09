class Solution {
    
    static int[] parent;
    static int[] rank;
    
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentX == parentY) {
            return;
        }
        
        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    
    public int kruskal(List<int[]> adj) {
        int sum = 0;
        
        for (int[] temp : adj) {
            int u = temp[0];
            int v = temp[1];
            int wt = temp[2];
            
            int parentU = find(u);
            int parentV = find(v);
            
            if (parentU != parentV) {
                union(u, v);
                sum += wt;
            }
        }
        
        return sum;
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        List<int[]> adj = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                
                adj.add(new int[] {i, j, dist});
            }
        }
        
        Collections.sort(adj, (a, b) -> a[2] - b[2]);
        
        return kruskal(adj);
    }
}