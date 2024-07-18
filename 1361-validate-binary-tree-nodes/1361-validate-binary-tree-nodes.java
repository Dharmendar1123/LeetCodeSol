class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> childToParent = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            int node = i;
            int leftC = leftChild[i];
            int rightC = rightChild[i];
            
            if (leftC != -1) {
                adj.computeIfAbsent(node, k -> new ArrayList<>()).add(leftC);
                if (childToParent.containsKey(leftC)) {
                    return false;
                }else {
                    childToParent.put(leftC, node);
                }
            }
            
            if (rightC != -1) {
                adj.computeIfAbsent(node, k -> new ArrayList<>()).add(rightC);
                if (childToParent.containsKey(rightC)) {
                    return false;
                }else {
                    childToParent.put(rightC, node);
                }
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) {
                    return false;
                }else {
                    root = i;
                }
            }
        }
        
        if (root == -1) {
            return false;
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        int count = 1;
        que.offer(root);
        visited[root] = true;
        
        while (!que.isEmpty()) {
            int node = que.poll();
            
            for (int child : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited[child]) {
                    que.offer(child);
                    visited[child] = true;
                    count++;
                }
            }
        }
        return count == n;
    }
}