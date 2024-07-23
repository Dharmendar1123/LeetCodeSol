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
    public String smallestFromLeaf(TreeNode root) {
        Queue<Pair<TreeNode, String>> que = new LinkedList<>();
        String result = "";
        que.offer(new Pair<>(root, String.valueOf((char)(root.val + 'a'))));
        
        while (!que.isEmpty()) {
            Pair<TreeNode, String> pair = que.poll();
            TreeNode node = pair.getKey();
            String curr = pair.getValue();
            
            if (node.left == null && node.right == null) {
                if (result.equals("") || result.compareTo(curr) > 0) {
                    result = curr;
                }
            }
            
            if (node.left != null) {
                que.offer(new Pair<>(node.left, (char)(node.left.val + 'a') + curr));
            }
            
            if (node.right != null) {
                que.offer(new Pair<>(node.right, (char)(node.right.val + 'a') + curr));
            }
        }
        return result;
    }
}