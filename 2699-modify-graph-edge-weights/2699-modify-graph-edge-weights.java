class Solution {
    
    private static final int LARGE_VALUE = (int) 2e9;
    
    private long dijkstraAlgo(int[][] edges, int n, int src, int dst) {
        List<long[]>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                adj[u].add(new long[] {v, wt});
                adj[v].add(new long[] {u, wt});
            }
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] result = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[src] = 0;
        pq.offer(new long[] {0, src});
        
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int currNode = (int) curr[1];
            
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            
            for (long[] neighbor : adj[currNode]) {
                int nbr = (int) neighbor[0];
                long weight = neighbor[1];
                
                if (result[nbr] > currDist + weight) {
                    result[nbr] = currDist + weight;
                    pq.offer(new long[] {result[nbr], nbr});
                }
            }
        }
        return result[dst];
    }
    
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        
        long currentShortest = dijkstraAlgo(edges, n, source, destination);
        
        if (currentShortest < target) {
            return new int[0][];
        }
        
        boolean matchedTarget = (currentShortest == target);
        
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = matchedTarget ? LARGE_VALUE : 1;
                
                if (!matchedTarget) {
                    long newShortest = dijkstraAlgo(edges, n, source, destination);
                    
                    if (newShortest <= target) {
                        matchedTarget = true;
                        edge[2] += (target - newShortest);
                    }
                }
            }
        }
        
        if (!matchedTarget) {
            return new int[0][];
        }
        return edges;
    }
}