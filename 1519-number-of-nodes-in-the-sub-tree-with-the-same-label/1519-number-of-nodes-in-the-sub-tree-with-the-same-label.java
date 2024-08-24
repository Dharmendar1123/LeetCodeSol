class Solution {
    
    private void solve(int curr, int parent, List<Integer>[] adj, int[] chars, int[] result, String labels) {
        
        char myLabel = labels.charAt(curr);
        int countBefore = chars[myLabel - 'a'];
        
        chars[myLabel - 'a']++;
        
        for (int child :  adj[curr]) {
            if (child == parent) {
                continue;
            }
            
            solve(child, curr, adj, chars, result, labels);
        }
        
        int countAfter = chars[myLabel - 'a'];
        result[curr] = countAfter - countBefore;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] adj = new ArrayList[n+1];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] result = new int[n];
        int[] chars = new int[26];
        
        solve(0, -1, adj, chars, result, labels);
        
        return result;
    }
}