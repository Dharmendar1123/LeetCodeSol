class Solution {
    int[] parent;
    int[] rank;
    
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentY == parentX) {
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
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        List<Integer>[] adj = new ArrayList[n+1];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        TreeMap<Integer, List<Integer>> valNode = new TreeMap<>();
        
        for (int i = 0; i < n; ++i) {
            int value = vals[i];
            
            valNode.computeIfAbsent(value, k -> new ArrayList<Integer>()).add(i);
        }
        
        int result = n;
        
        boolean[] isActive = new boolean[n];
        
        for (Map.Entry<Integer, List<Integer>> entry : valNode.entrySet()) {
            
            List<Integer> node = entry.getValue();
            
            for (int u : node) {
                for (int v : adj[u]) {
                    if (isActive[v]) {
                        union(u, v);
                    }
                }
                isActive[u] = true;
            }
            
            List<Integer> yourParent = new ArrayList<>();
            
            for (int u : node) {
                int parentNode = find(u);
                yourParent.add(parentNode);
            }
            
            Collections.sort(yourParent);
            
            int size = yourParent.size();
            
            for (int j = 0; j < size; ++j) {
                long count = 0;
                
                int currParent = yourParent.get(j);
                
                while (j < size && yourParent.get(j) == currParent) {
                    count++;
                    j++;
                }
                j--;
                
                result += ((count) * (count - 1) / 2);
            }
        }
        return result;
    }
}