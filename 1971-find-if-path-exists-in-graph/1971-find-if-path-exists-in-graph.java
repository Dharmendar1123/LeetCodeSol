class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        } 
        for (int i = 0; i < edges.length; ++i) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) {
                return true;
            }

            for (int val : adj[node]) {
                if (!visited[val]) {
                    q.offer(val);
                    visited[val] = true;
                }
            }
        }
        return false;
    }
}