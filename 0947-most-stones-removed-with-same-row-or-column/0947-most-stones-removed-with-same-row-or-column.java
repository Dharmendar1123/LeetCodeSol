class Solution {
    
    public int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x], parent);
    }
    
    public void union(int x, int y, int[] parent, int[] rank) {
        
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        
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
    
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, parent, rank);
                }
            }
        }
        
        int groups = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                groups++;
            }
        }
        
        return n - groups;
    }
}