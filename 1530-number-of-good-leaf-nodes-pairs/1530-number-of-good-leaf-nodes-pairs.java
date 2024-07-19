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
    
    public List<Integer> solve(TreeNode root, int dis, int[] goodLeaf) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        if (root.left == null && root.right == null) {
            List<Integer> leaf = new ArrayList<>();
            leaf.add(1);
            return leaf;
        }
        
        List<Integer> leftDis = solve(root.left, dis, goodLeaf);
        List<Integer> rightDis = solve(root.right, dis, goodLeaf);
        
        for (int l : leftDis) {
            for (int r : rightDis) {
                if (l+r <= dis) {
                    goodLeaf[0]++;
                }
            }
        }
        
        List<Integer> currentDis = new ArrayList<>();
        for (int ld : leftDis) {
            if (ld + 1 < dis) {
                currentDis.add(ld+1);
            }
        }
        
        for (int rd : rightDis) {
            if (rd + 1 < dis) {
                currentDis.add(rd+1);
            }
        }
        
        return currentDis;
    }
    
    public int countPairs(TreeNode root, int distance) {
        int[] goodLeaf = new int[1];
        solve(root, distance, goodLeaf);
        return goodLeaf[0];
    }
}