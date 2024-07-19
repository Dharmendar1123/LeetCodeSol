/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
1 - [5, 3]
5 - [1, 4]
4 - [5, 9, 2]
9 - [4]
2 - [4]
3 - [1, 10, 6]
10 - [3]
6 - [3]
1, 10, 6/ 5/ 4/ 9, 2/
*/
class Solution {
    public void makeGraph(TreeNode root, TreeNode prev, Map<Integer, List<Integer>> adj) {
        if (root == null) {
            return;
        }
        
        if (prev != null) {
            adj.computeIfAbsent(root.val, k -> new ArrayList<>()).add(prev.val);
            adj.computeIfAbsent(prev.val, k -> new ArrayList<>()).add(root.val);
        }
        
        makeGraph(root.left, root, adj);
        makeGraph(root.right, root, adj);
        
    }
    
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        makeGraph(root, null, adj);
        
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        que.offer(start);
        visited.add(start);
        int time = 0;
        
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                int node = que.poll();
                
                for (int neigh : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neigh)) {
                        que.offer(neigh);
                        visited.add(neigh);
                    }
                }
            }
            time++;
        }
        
        return time-1;
    }
}