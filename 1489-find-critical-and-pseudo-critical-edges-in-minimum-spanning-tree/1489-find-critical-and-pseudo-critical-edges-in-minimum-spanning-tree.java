class Solution {
    
    int N;
    
    class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) 
                return;

            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if(rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }

        }
    }
    
    private int kruskal(int[][] adj, int skip, int add) {
        int sum = 0;
        
        UnionFind uf = new UnionFind(N);
        int connectEdge = 0;
        
        if (add != -1) {
            uf.union(adj[add][0], adj[add][1]);
            sum += adj[add][2];
            connectEdge++;
        }
        
        for (int i = 0; i < adj.length; ++i) {
            
            if (i == skip) {
                continue;
            }
            
            int u = adj[i][0];
            int v = adj[i][1];
            int wt = adj[i][2];
            
            int parentU = uf.find(u);
            int parentV = uf.find(v);
            
            if (parentU != parentV) {
                uf.union(u, v);
                sum += wt;
                connectEdge++;
            }
        }
        
        if (connectEdge != N-1) {
            return Integer.MAX_VALUE;
        }
        return sum;
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        N = n;
        
        int m = edges.length;
        int[][] adj = new int[m][4];
        
        for (int i = 0; i < m; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            int idx = i;
            
            adj[i][0] = u;
            adj[i][1] = v;
            adj[i][2] = wt;
            adj[i][3] = idx;
        }
        
        Arrays.sort(adj, (a, b) -> a[2] - b[2]);
        
        int mstWeight = kruskal(adj, -1, -1);
        
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        
        for (int i = 0; i < m; ++i) {
            
            if (kruskal(adj, i, -1) > mstWeight) {
                critical.add(adj[i][3]);
            }else if (kruskal(adj, -1, i) == mstWeight) {
                pseudo.add(adj[i][3]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudo);
        
        return result;
    }
}