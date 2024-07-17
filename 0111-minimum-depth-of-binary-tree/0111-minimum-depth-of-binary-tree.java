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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 1;
        
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                TreeNode node =  que.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            level++;
        }
        
        return level;
    }
}