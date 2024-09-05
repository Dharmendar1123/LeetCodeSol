class Solution {
    
    private void dfs(String src, String dst, Map<String, List<Pair<String, Double>>> adj, Set<String> visited, double product, double[] ans) {
        
        if (visited.contains(src)) {
            return;
        }
        
        visited.add(src);
        
        if (src.equals(dst)) {
            ans[0] = product;
            return;
        }
        
        for (Pair<String, Double> p : adj.getOrDefault(src, new ArrayList<>())) {
            String v = p.getKey();
            double val = p.getValue();
            
            dfs(v, dst, adj, visited, product*val, ans);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, val));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0/val));
        }
        
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); ++i) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            
            double[] ans = {-1.0};
            double product = 1.0;
            
            if (adj.containsKey(src)) {
                
                Set<String> visited = new HashSet<>();;
                dfs(src, dst, adj, visited, product, ans);
            }
            result[i] = ans[0];
        }
        return result;
    }
}