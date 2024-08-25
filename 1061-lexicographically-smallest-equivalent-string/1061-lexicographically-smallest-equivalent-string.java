class Solution {
    
    private char dfsFindMinChar(char ch, Map<Character, List<Character>> adj, int[] visited) {
        visited[ch - 'a'] = 1;
        
        char minChar = ch;
        
        for (char v : adj.getOrDefault(ch, new ArrayList<>())) {
            
            if (visited[v - 'a'] == 0) {
                minChar = (char)Math.min(minChar, dfsFindMinChar(v, adj, visited));
            }
        }
        return minChar;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();
        
        Map<Character, List<Character>> adj = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; ++i) {
            char ch = baseStr.charAt(i);
            
            int[] visited = new int[26];
            
            char minChar = dfsFindMinChar(ch, adj, visited);
            
            sb.append(minChar);
        }
        
        return sb.toString();
    }
}