/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            parent.put(root.left, root);
        }
        inOrder(root.left);
        
        if (root.right != null) {
            parent.put(root.right, root);
        }
        inOrder(root.right);
    }
    
    public void bfs(TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(target);
        
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        
        while (!que.isEmpty()) {
            int n = que.size();
            if (k == 0) {
                break;
            }
            
            while (n-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null && !set.contains(node.left.val)) {
                    que.offer(node.left);
                    set.add(node.left.val);
                }
                
                if (node.right != null && !set.contains(node.right.val)) {
                    que.offer(node.right);
                    set.add(node.right.val);
                }
                
                if (parent.containsKey(node) && !set.contains(parent.get(node).val)) {
                    que.offer(parent.get(node));
                    set.add(parent.get(node).val);
                }
            }
            k--;
        }
        
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            result.add(temp.val);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        
        inOrder(root);
        
        bfs(target, k, result);
        
        return result;
    }
}