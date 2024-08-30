class Solution {
    
    private void bfs(int u, List<Integer>[] adj, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(u);
        
        visited[u] = true;
        
        while (!que.isEmpty()) {
            int top = que.poll();
            
            for (int v : adj[top]) {
                if (!visited[v]) {
                    que.offer(v);
                    visited[v] = true;
                }
            }
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
                bfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }
}