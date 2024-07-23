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
        Queue<Pair<TreeNode, StringBuilder>> que = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        que.offer(new Pair<>(root, new StringBuilder().append((char)(root.val + 'a'))));
        
        while (!que.isEmpty()) {
            Pair<TreeNode, StringBuilder> pair = que.poll();
            TreeNode node = pair.getKey();
            StringBuilder curr = pair.getValue();
            
            if (node.left == null && node.right == null) {
                String currStr = curr.toString();
                if (result.length() == 0 || result.toString().compareTo(currStr) > 0) {
                    result.setLength(0);
                    result.append(currStr);
                }
            }
            
            if (node.left != null) {
                que.offer(new Pair<>(node.left, new StringBuilder(curr).insert(0, (char)(node.left.val + 'a'))));
            }
            
            if (node.right != null) {
                que.offer(new Pair<>(node.right, new StringBuilder(curr).insert(0, (char)(node.right.val + 'a'))));
            }
        }
        
        return result.toString();
    }
}