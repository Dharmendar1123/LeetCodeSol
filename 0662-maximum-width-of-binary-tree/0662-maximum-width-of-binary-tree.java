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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Deque<Pair<TreeNode, Integer>> que = new LinkedList<>();
        que.add(new Pair<>(root, 0));
        int maxWidth = 0;
        
        while (!que.isEmpty()) {
            int n = que.size();
            int f = que.peekFirst().getValue();
            int l = que.peekLast().getValue();
            maxWidth = Math.max(maxWidth, l - f + 1);
            while (n-- > 0) {
                Pair<TreeNode, Integer> curr = que.poll();
                TreeNode node = curr.getKey();
                int idx = curr.getValue();
                
                if (node.left != null) {
                    que.add(new Pair<>(node.left, 2 * idx + 1));
                }
                
                if (node.right != null) {
                    que.add(new Pair<>(node.right, 2 * idx + 2));
                }
            }
        }
        return maxWidth;
    }
}