class Solution {
    
    int[] rank;
    int[] parent;
    
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
    
    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        
        int n = s1.length();
        
        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        int groupCount = n;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isSimilar(strs[i], strs[j]) && find(i) != find(j)) {
                    union(i, j);
                    groupCount--;
                }
            }
            
        }
        return groupCount;
    }
}