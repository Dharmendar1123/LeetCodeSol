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
class Solution {
    
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> st) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            st.add(root);
        }
        
        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }
        
        makeGraph(root.left, root, adj, st);
        makeGraph(root.right, root, adj, st);
    }
    
    public int countPairs(TreeNode root, int distance) {
        
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Set<TreeNode> st = new HashSet<>();
        
        makeGraph(root, null, adj, st);
        
        int count = 0;
        
        for(TreeNode leaf : st) {
            Queue<TreeNode> que = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            que.offer(leaf);
            visited.add(leaf);
            
            for (int i = 0; i <= distance; ++i) {
                int n = que.size();
                while (n-- > 0) {
                    TreeNode node = que.poll();
                    
                    if (node != leaf && st.contains(node)) {
                        count++;
                    }
                    
                    for (TreeNode neigh : adj.getOrDefault(node, new ArrayList<>())) {
                        if (!visited.contains(neigh)) {
                            que.offer(neigh);
                            visited.add(neigh);
                        }
                    }
                }
            }
        }
        return count/2;
    }
}