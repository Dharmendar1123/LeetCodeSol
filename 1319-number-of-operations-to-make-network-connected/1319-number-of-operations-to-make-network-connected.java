class Solution {
    private int[] parent;
    private int[] rank;
    
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
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
    
    
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n-1) {
            return -1;
        }
        
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0;i  < n; ++i) {
            parent[i] = i;
        }
        
        int component = n;
        for (int[] row : connections) {

            if (find(row[0]) != find(row[1])) {
                union(row[0], row[1]);
                component--;
            }
        }
        
        return component-1;
    }
}