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
    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode nextNode = null;

        while (curr != null) {

            nextNode = curr.next;

            curr.next = prev;

            prev = curr;

            curr = nextNode;
        }

        ListNode first = head;
        ListNode second = prev;
        boolean palindrome = true;

        while (second != null && palindrome) {

            if (first.val != second.val) {
                palindrome = false;
            }

            first = first.next;
            second = second.next;
        }

        return palindrome;
        
    }
}