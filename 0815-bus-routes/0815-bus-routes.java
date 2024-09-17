class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int stop : routes[i]) {
                adj.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[501];
        
        for (int val : adj.getOrDefault(source, new ArrayList<>())) {
            que.offer(val);
            visited[val] = true;
        }
        
        int busCount = 1;
        
        while (!que.isEmpty()) {
            int size = que.size();
            
            while (size-- > 0) {
                int top = que.poll();
                
                for (int stop : routes[top]) {
                    if (stop == target) {
                        return busCount;
                    }
                    
                    for (int nextRoute : adj.getOrDefault(stop, new ArrayList<>())) {
                        if (!visited[nextRoute]) {
                            visited[nextRoute] = true;
                            que.offer(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}