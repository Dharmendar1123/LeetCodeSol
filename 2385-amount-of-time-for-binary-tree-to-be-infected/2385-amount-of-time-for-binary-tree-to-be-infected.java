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
    TreeNode startNode;
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, int start) {
        if (root == null) {
            return;
        }
        
        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }
        
        if (start == root.val) {
            startNode = root;
        }
        
        makeGraph(root.left, root, adj, start);
        makeGraph(root.right, root, adj, start);
        
    }
    
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        startNode = null;
        makeGraph(root, null, adj, start);
        
        Queue<TreeNode> que = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        que.offer(startNode);
        visited.add(startNode);
        int time = 0;
        
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                TreeNode node = que.poll();
                
                for (TreeNode neigh : adj.getOrDefault(node, new ArrayList<>())) {
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