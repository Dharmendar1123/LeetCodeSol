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
    
    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int leftSum = left[0];
        int leftCount = left[1];
        
        int rightSum = right[0];
        int rightCount = right[1];
        
        int totalSum = root.val + leftSum + rightSum;
        int totalCount = 1 + leftCount + rightCount;
        
        if (totalSum/totalCount == root.val) {
            result++;
        }
        
        return new int[]{totalSum, totalCount};
    }
    
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}