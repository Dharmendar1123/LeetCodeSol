class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        
        for (int[] road : roads) {
            
            int u = road[0];
            int v = road[1];
            
            adj.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<>()).add(u);
            
        }
        
        int maxRank = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                
                int iRank = adj.getOrDefault(i, new HashSet<>()).size();
                int jRank = adj.getOrDefault(j, new HashSet<>()).size();
                
                int rank = iRank + jRank;
                
                if (adj.getOrDefault(i, new HashSet<>()).contains(j)) {
                    rank--;
                }
                
                maxRank = Math.max(maxRank, rank);
                
            }
        }
        return maxRank;
    }
}