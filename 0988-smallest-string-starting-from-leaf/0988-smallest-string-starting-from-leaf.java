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
    String result;
    
    private void solve(TreeNode root, StringBuilder curr) {
        if (root == null) {
            return; 
        }
        
        curr.insert(0, (char)(root.val + 'a'));
        
        if (root.left == null && root.right == null) {
            if (result.equals("") || result.compareTo(curr.toString()) > 0) {
                result = curr.toString();
            }
            
        }
        
        solve(root.left, curr);
        solve(root.right, curr);
        
        curr.deleteCharAt(0);
    }
    
    public String smallestFromLeaf(TreeNode root) {
        result = "";
        solve(root, new StringBuilder());
        return result;
    }
}