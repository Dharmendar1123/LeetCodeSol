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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        int level = 1;
        
        while (!que.isEmpty()) {
            int n = que.size();
            int sum = 0;
            while (n-- > 0) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (sum > maxSum) {
                    maxSum = sum;
                    ans = level;
            }
            level++;
        }
        return ans;
    }
}