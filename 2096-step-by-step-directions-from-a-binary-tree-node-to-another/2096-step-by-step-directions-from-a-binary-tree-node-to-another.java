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
        
        StringBuilder toStart = new StringBuilder();
        StringBuilder toDest = new StringBuilder();
        
        findPath(root, startValue, toStart);
        findPath(root, destValue, toDest);
        
        int l = 0;
        while (l < toStart.length() && l < toDest.length() && toStart.charAt(l) == toDest.charAt(l)) {
            l++;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < toStart.length() - l; ++i) {
            result.append('U');
        }
        
        for (int i = l; i < toDest.length(); ++i) {
            result.append(toDest.charAt(i));
        }
        
        return result.toString();
    }
}