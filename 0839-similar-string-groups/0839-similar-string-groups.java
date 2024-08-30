class Solution {
    
    private void dfs(int u, List<Integer>[] adj, boolean[] visited) {
        visited[u] = true;
        
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
    
    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        for (int i = 0; i < n; ++i) {
            if (c1[i] != c2[i]) {
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                
                if (isSimilar(strs[i], strs[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }
}