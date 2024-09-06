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
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] seen = new boolean[100001];
        
        for (int num : nums) {
            seen[num] = true;
        }
        
        while (head != null && seen[head.val]) {
            head = head.next;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            if (!seen[curr.val]) {
                prev = curr;
                curr = curr.next;
            }else {
                if (prev != null) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
        }
        return head;
    }
}