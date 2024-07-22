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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 0;
        
        while (!que.isEmpty()) {
            int n = que.size();
            int prevOdd = -1;
            int prevEven = -1;
            while (n-- > 0) {
                TreeNode node = que.poll();
                
                
                if (level % 2 != 0) {
                    if (prevOdd != -1) {
                        if (node.val % 2 == 0) {
                            if (prevOdd > node.val) {
                                prevOdd = node.val;
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }else {
                        if (node.val % 2 == 0) {
                            prevOdd = node.val;
                        }else {
                            return false;
                        }
                    }
                }
                
                
                if (level % 2 == 0) {
                    if (prevEven != -1) {
                        if (node.val % 2 != 0) {
                            if (prevEven < node.val) {
                                prevEven = node.val;
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }else {
                        if (node.val % 2 != 0) {
                            prevEven = node.val;
                        }else {
                            return false;
                        }
                    }
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
        return true;
    }
}