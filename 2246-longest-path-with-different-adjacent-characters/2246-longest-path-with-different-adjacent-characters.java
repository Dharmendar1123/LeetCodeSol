class Solution {
    int result;
    
    private int dfs(int curr, List<Integer>[] adj, String s) {
        
        int longest = 0;
        int secondLongest = 0;
        
        for (int child : adj[curr]) {
            
            int childLongest = dfs(child, adj, s);
            
            if (s.charAt(child) != s.charAt(curr)) {
                if (childLongest > secondLongest) {
                    secondLongest = childLongest;
                }
            
                if (secondLongest > longest) {
                    int temp = longest;
                    longest = secondLongest;
                    secondLongest = temp;
                }
            }
        }
        
        int eitherGood = Math.max(longest, secondLongest) + 1;
        
        int rootGood = 1;
        
        int downGood = 1 + longest + secondLongest;
        
        result = Math.max(result, Math.max(eitherGood, Math.max(rootGood, downGood)));
        
        return Math.max(eitherGood, rootGood);
    }
    
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n+1];
        
        result = 0;
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < n; ++i) {
            int u = i;
            int v = parent[i];
            
            adj[v].add(u);
        }
        
        dfs(0, adj, s);
        
        return result;
    }
}