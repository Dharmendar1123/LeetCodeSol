class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] {v, wt});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;
        pq.offer(new int[] {0, k});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            
            for (int[] v : adj.getOrDefault(node, new ArrayList<>())) {
                int adjNode = v[0];
                int dist = v[1];
                
                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[] {d + dist, adjNode});
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans = Math.max(ans, result[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}