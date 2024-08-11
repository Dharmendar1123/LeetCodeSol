class Solution {
    
    public void dfs(int index, int[][] stones, boolean[] visited) {
        visited[index] = true;
        
        for (int i = 0; i < stones.length; ++i) {
            int r = stones[index][0];
            int c = stones[index][1];
            if (!visited[i] && (stones[i][0] == r || stones[i][1] == c)) {
                dfs(i, stones, visited);
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        
        int group = 0;
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, stones, visited);
                group++;
            }
        }
        return (n - group);
    }
}