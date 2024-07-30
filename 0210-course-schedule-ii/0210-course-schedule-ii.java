class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        for (int[] row : prerequisites) {
            int a = row[0];
            int b = row[1];
            
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            inDegree[a]++;
        }
        
        int[] result = new int[numCourses];
        
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                que.offer(i);
                count++;
            }
        }
        int i = 0;
        
        while (!que.isEmpty()) {
            int u = que.poll();
            result[i++] = u;
            
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                inDegree[v]--;
                
                if (inDegree[v] == 0) {
                    que.offer(v);
                    count++;
                }
            }
        }
        
        return count == numCourses ? result : new int[] {};
    }
}