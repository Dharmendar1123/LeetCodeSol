class Solution {
    
    private void dfs(int node, List<List<Integer>> result, int[][] graph, List<Integer> temp) {
        temp.add(node);
        
        if (node == graph.length-1) {
            result.add(new ArrayList<>(temp));
        }
        
        for (int v : graph[node]) {
            dfs(v, result, graph, temp);
        }
        
        temp.remove(temp.size() - 1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        
        dfs(0, result, graph, temp);
        
        return result;
    }
}