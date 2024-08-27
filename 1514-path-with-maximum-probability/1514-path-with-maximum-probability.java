class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair<Integer, Double>>[] adj = new ArrayList[n+1];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        int i = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            double wt = succProb[i];
            
            adj[u].add(new Pair<>(v, wt));
            adj[v].add(new Pair<>(u, wt));
            i++;
        }
        
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        double[] result = new double[n];
        
        result[start] = 1d;
        pq.offer(new Pair<>(1.0, start));
        
        while (!pq.isEmpty()) {
            Pair<Double, Integer> curr = pq.poll();
            double currProb = curr.getKey();
            int currNode = curr.getValue();
            
            if (currNode == end) {
                return currProb;
            }
            
            for (Pair<Integer, Double> next : adj[currNode]) {
                int nextNode = next.getKey();
                double pathProb = next.getValue();
                
                if (currProb * pathProb > result[nextNode]) {
                    result[nextNode] = currProb * pathProb;
                    pq.offer(new Pair<>(result[nextNode], nextNode));
                }
            }
        }
        
        return 0d;
    }
}