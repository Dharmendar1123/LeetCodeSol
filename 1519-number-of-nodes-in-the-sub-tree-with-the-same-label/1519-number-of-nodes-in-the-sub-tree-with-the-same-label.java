class Solution {
    
    private int[] dfs(int curr, int parent, List<Integer>[] adj, int[] result, String labels) {
        
        int[] myCount = new int[26];
        
        char myLabel = labels.charAt(curr);
        
        myCount[myLabel - 'a'] = 1;
        
        for (int child : adj[curr]) {
            if (child == parent) {
                continue;
            }
            
            int[] childCount = new int[26];
            
            childCount = dfs(child, curr, adj, result, labels);
            
            for (int i = 0; i < 26; ++i) {
                myCount[i] += childCount[i];
            }
        }
        result[curr] = myCount[myLabel - 'a'];
        return myCount;
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
        
        dfs(0, -1, adj, result, labels);
        
        return result;
    }
}