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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)  return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = p1.next;

        while(p2!= null && p2.next != null){
            p1.next = p2.next;
            p2.next = p2.next.next;
            p1.next.next = p2;
            p1 = p2;
            p2 = p2.next;
        }
        
        return dummy.next;
    }
}