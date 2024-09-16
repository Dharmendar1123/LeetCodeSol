class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new ArrayList[n];
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] rel : relations) {
            // Zero Based
            int u = rel[0] - 1;
            int v = rel[1] - 1;
            
            adj[u].add(v);
            inDegree[v]++;
        }
        
        int[] maxTime = new int[n];
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                que.offer(i);
                maxTime[i] = time[i];
            }
        }
        
        while (!que.isEmpty()) {
            
            int u = que.poll();
            
            for (int v : adj[u]) {
                
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v]);
                
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    que.offer(v);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result = Math.max(result, maxTime[i]);
        }
        
        return result;
    }
}