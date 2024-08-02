class Solution {
    private int[] parent;
    private int[] rank;
    
    private int find(int x) {
        if (parent[x] == x) {
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
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                union(str.charAt(0)-'a', str.charAt(3)-'a');
            }
        }
        
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                
                if (find(str.charAt(0) - 'a') == find(str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}