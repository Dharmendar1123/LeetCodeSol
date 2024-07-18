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
    
    public void dfs(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) {
            return;
        }
        
        if (map.containsKey(level)) {
            map.put(level, Math.max(map.get(level), root.val));
        }else {
            map.put(level, root.val);
        }
        
        
        dfs(root.left, map, level+1);
        dfs(root.right, map, level+1);
    }
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}