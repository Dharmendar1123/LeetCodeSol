class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        
        int allVisited = (1 << n) - 1;
        
        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[n][allVisited + 1];
        
        for (int i = 0; i < n; ++i) {
            
            int maskValue = (1 << i);
            que.offer(new int[] {i, maskValue});
            visited[i][maskValue] = 1;
            
        }
        
        int path = 0;
        
        while (!que.isEmpty()) {
            int size = que.size();
            path++;
            
            while (size-- > 0) {
                
                int[] curr = que.poll();
                
                int currNode = curr[0];
                int currMask = curr[1];
                
                for (int next : graph[currNode]) {
                    
                    int nextMask = currMask | (1 << next);
                    
                    if (visited[next][nextMask] == 1) {
                        continue;
                    }
                    
                    if (nextMask == allVisited) {
                        return path;
                    }
                    
                    visited[next][nextMask] = 1;
                    que.offer(new int[] {next, nextMask});
                }
            }
        }
        return -1;
    }
}