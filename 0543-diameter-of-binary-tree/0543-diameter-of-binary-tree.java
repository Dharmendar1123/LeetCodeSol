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
    int ans = 0;
    
    public int solve(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        
        int l = solve(root.left, level+1);
        int r = solve(root.right, level+1);
        
        ans = Math.max(ans, l+r);
        return Math.max(l, r) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        solve(root, 0);
        return ans;
    }
}