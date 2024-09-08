/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int bucketNodes = len / k;
        int remainderNodes = len % k;
        
        ListNode[] result = new ListNode[k];
        
        curr = head;
        ListNode prev = null;
        
        for (int i = 0; i < k; ++i) {
            
            result[i] = curr;
            
            for (int count = 1; count <= bucketNodes + (remainderNodes > 0 ? 1 : 0); ++count) {
                
                prev = curr;
                curr = curr.next;
            }
            
            if (prev != null) {
                prev.next = null;
            }
            
            remainderNodes--;
        }
        return result;
    }
}