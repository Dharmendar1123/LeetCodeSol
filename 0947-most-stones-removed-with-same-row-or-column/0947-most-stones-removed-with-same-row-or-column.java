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
        
        int[] parent = new int[20005];
        int[] rank = new int[20005];
        
        for (int i = 0; i < 20005; ++i) {
            parent[i] = i;
        }
        
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10001, parent, rank);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0], parent));
        }
        
        return stones.length - set.size();
    }
}