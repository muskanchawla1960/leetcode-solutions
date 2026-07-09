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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        ListNode[] nodes = new ListNode[right - left + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = curr;
            curr = curr.next;
        }
        
        prev.next = nodes[nodes.length - 1];
        for (int i = nodes.length - 1; i > 0; i--) {
            nodes[i].next = nodes[i - 1];
        }
        nodes[0].next = curr;
        
        return dummy.next;

        
    }
}