class Solution {
    
    private List<Integer> topoSort(List<Integer>[] adj, int[] indegree) {
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!que.isEmpty()) {
            int top = que.poll();
            result.add(top);
            
            for (int v : adj[top]) {
                indegree[v]--;
                
                if (indegree[v] == 0) {
                    que.offer(v);
                }
            }
        }
        // Check cycle
        return result.size() == adj.length ? result : new ArrayList<>();
    }
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        
        List<Integer>[] itemGraph = new List[n];
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph[i] = new ArrayList<>();
        }
        
        List<Integer>[] groupGraph = new List[m];
        int[] groupIndegree = new int[m];
        for (int i = 0; i < m; ++i) {
            groupGraph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; ++i) {
            for (int prev : beforeItems.get(i)) {
                
                itemGraph[prev].add(i);
                itemIndegree[i]++;
                
                if (group[i] != group[prev]) {
                    int prevGroup = group[prev];
                    int currGroup = group[i];
                    
                    groupGraph[prevGroup].add(currGroup);
                    groupIndegree[currGroup]++;
                }
            }
        }
        
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        
        List<Integer>[] groupToItem = new List[m];
        for (int i = 0; i < m; ++i) {
            groupToItem[i] = new ArrayList<>();
        }
        
        for (int item : itemOrder) {
            int itemGroup = group[item];
            groupToItem[itemGroup].add(item);
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(groupToItem[groupIndex]);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}