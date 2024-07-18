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
    int result;
    
    public int findSum(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }
        
        count[0]++;
        
        int leftSum = findSum(root.left, count);
        int rightSum = findSum(root.right, count);
        
        return root.val + leftSum + rightSum;
    }
    
    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        
        int[] count = {0};
        int sum = findSum(root, count);
        if (sum/count[0] == root.val) {
            result++;
        }
        
        solve(root.left);
        solve(root.right);
    }
    
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}