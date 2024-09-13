class Solution {
    private Map<String, PriorityQueue<String>> adj = new HashMap<>();
    private List<String> result = new ArrayList<>();

    private void dfs(String u) {
        PriorityQueue<String> edges = adj.get(u);
        
        while (edges != null && !edges.isEmpty()) {
            String v = edges.poll(); 
            dfs(v);
        }
        result.add(u);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> e : tickets) {
            adj.computeIfAbsent(e.get(0), k -> new PriorityQueue<>()).add(e.get(1));
        }

        dfs("JFK");
        
        Collections.reverse(result);
        return result;
    }
}