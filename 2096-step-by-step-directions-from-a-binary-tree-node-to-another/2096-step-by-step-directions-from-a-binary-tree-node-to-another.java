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
    
    public TreeNode lowestCommonAncestor(TreeNode root, int s, int d) {
        if (root == null) {
            return null;
        }
        
        if (root.val == s || root.val == d) {
            return root;
        }
        
        TreeNode l = lowestCommonAncestor(root.left, s, d);
        TreeNode r = lowestCommonAncestor(root.right, s, d);
        
        if (l != null && r != null) {
            return root;
        }
        
        if  (l != null) {
            return l;
        }
        return r;
    }
    
    public boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }
        
        if (node.val == target) {
            return true;
        }
        
        path.append('L');
        if (findPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length()-1);
        
        path.append('R');
        if (findPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length()-1);
        
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder toStart = new StringBuilder();
        StringBuilder toDest = new StringBuilder();
        
        findPath(lca, startValue, toStart);
        findPath(lca, destValue, toDest);
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < toStart.length(); ++i) {
            result.append('U');
        }
        
        result.append(toDest);
        
        return result.toString();
    }
}