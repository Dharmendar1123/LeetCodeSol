class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                
                adj.get(i).add(new int[] {j, dist});
                adj.get(j).add(new int[] {i, dist});
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] inMST = new boolean[n];
        pq.offer(new int[] {0, 0});
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int wt = top[0];
            int node = top[1];
            
            if (inMST[node] == true) {
                continue;
            }
            
            inMST[node] = true;
            sum += wt;
            
            for (int[] temp : adj.get(node)) {
                int nbr = temp[0];
                int nbrWt = temp[1];
                
                if (inMST[nbr] == false) {
                    pq.offer(new int[] {nbrWt, nbr});
                }
            }
        }
        return sum;
    }
}