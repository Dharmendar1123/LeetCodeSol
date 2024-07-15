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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        // Set<Integer> childSet = new HashSet<>();
        
        for (int[] node : descriptions) {
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];
            
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            
            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }
            
            if (isLeft == 1) {
                map.get(parent).left = map.get(child);
            }else {
                map.get(parent).right = map.get(child);
            }
            
            // childSet.add(child);
        }
        
        for (int[] node : descriptions) {
            map.remove(node[1]);
        }
        
        Optional<TreeNode> op= map.values().stream().findFirst();
        return op.get();
    }
}