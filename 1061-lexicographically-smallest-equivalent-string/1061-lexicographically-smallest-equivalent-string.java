class Solution {
    
    private char dfsFindMinChar(int ch, List<Integer>[] adj, int[] visited) {
        visited[ch] = 1;
        
        char minChar = (char)(ch + 'a');
        
        for (int v : adj[ch]) {
            
            if (visited[v] == 0) {
                minChar = (char)Math.min(minChar, dfsFindMinChar(v, adj, visited));
            }
        }
        return minChar;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();
        
        List<Integer>[] adj = new ArrayList[26];
        
        for (int i = 0; i < 26; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; ++i) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; ++i) {
            int ch = baseStr.charAt(i) - 'a';
            
            int[] visited = new int[26];
            
            char minChar = dfsFindMinChar(ch, adj, visited);
            
            sb.append(minChar);
        }
        
        return sb.toString();
    }
}