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
    
    public void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        
        if (level == result.size()) {
            result.add(root.val);
        }else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        
        
        dfs(root.left, result, level+1);
        dfs(root.right, result, level+1);
    }
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(root, result, 0);
        
        return result;
    }
}