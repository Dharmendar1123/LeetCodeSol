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
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        int[][] queriesIndex = new int[queries.length][4];
        for (int i = 0; i < queries.length; ++i) {
            queriesIndex[i][0] = queries[i][0];
            queriesIndex[i][1] = queries[i][1];
            queriesIndex[i][2] = queries[i][2];
            queriesIndex[i][3] = i;
        }
        
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queriesIndex, (a, b) -> a[2] - b[2]);
        
        boolean[] result = new boolean[queries.length];
        int j = 0;
        
        for (int[] query : queriesIndex) {
            int u = query[0];
            int v = query[1];
            int wt = query[2];
            int idx = query[3];
            
            while (j < edgeList.length && edgeList[j][2] < wt) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            
            result[idx] = find(u) == find(v);
        }
        return result;
    }
}