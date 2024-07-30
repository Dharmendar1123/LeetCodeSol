class Solution {
    
    private boolean topologicalSort(int numCourses, Map<Integer, List<Integer>> adj, int[] inDegree) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                que.offer(i);
                count++;
            }
        }
        
        while (!que.isEmpty()) {
            int u = que.poll();
            
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    que.offer(v);
                    count++;
                }
            }
        }
        return count == numCourses ? true : false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        for (int[] row : prerequisites) {
            int a = row[0];
            int b = row[1];
            
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            inDegree[a]++;
        }
        
        return topologicalSort(numCourses, adj, inDegree);
    }
}