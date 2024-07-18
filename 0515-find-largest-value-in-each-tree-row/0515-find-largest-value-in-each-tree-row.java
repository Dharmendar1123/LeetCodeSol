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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while(!que.isEmpty()) {
            int n = que.size();
            int maxEle = Integer.MIN_VALUE;
            while (n-- > 0) {
                TreeNode node = que.poll();
                maxEle = Math.max(maxEle, node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            result.add(maxEle);
        }
        return result;
    }
}