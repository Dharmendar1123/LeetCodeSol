class Solution {
    
    private int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x], parent);
    }
    
    private void union(int x, int y, int[] parent, int[] rank) {
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
    
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            map.put(find(i, parent), map.getOrDefault(find(i, parent), 0) + 1);
        }
        
        long result = 0;
        long remainingNodes = n;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int size = entry.getValue();
            
            result += size * (remainingNodes - size);
            remainingNodes -= size;
        }
        return result;
    }
}