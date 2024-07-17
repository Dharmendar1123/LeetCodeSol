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
    int minDepth = Integer.MAX_VALUE;
    public void solve(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, level);
        }
        
        solve(root.left, level+1);
        solve(root.right, level+1);
    }
    public int minDepth(TreeNode root) {
        int level = 1;
        solve(root, level);
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }
}