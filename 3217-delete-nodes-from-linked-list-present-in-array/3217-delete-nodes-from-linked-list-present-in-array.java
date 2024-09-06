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
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        ListNode p1 = null;
        ListNode p2 = head;
        
        while (p2 != null) {
            if (set.contains(p2.val) && p1 == null) {
                p2 = p2.next;
                head = p2;
            }else if (set.contains(p2.val) && p1 != null) {
                p2 = p2.next;
                p1.next = p2;
            }else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }
}