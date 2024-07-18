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
    
    public Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        
        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);
        
        int leftSum = left.getKey();
        int leftCount = left.getValue();
        
        int rightSum = right.getKey();
        int rightCount = right.getValue();
        
        int totalSum = root.val + leftSum + rightSum;
        int totalCount = 1 + leftCount + rightCount;
        
        if (totalSum/totalCount == root.val) {
            result++;
        }
        
        return new Pair<>(totalSum, totalCount);
    }
    
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}