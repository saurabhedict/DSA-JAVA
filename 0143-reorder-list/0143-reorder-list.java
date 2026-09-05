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
    public int ListSize(ListNode head){
       ListNode temp = head;
       int size = 0;
       while(temp != null){
         size++;
         temp = temp.next;
       }
       return size;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode[] split(ListNode head){
       int size = ListSize(head);
       if(size%2 == 0) size = size/2;
       else size = (size/2) + 1;

       ListNode temp = head;
       for(int i = 1; i<size; i++){
            temp = temp.next;
       }
       ListNode head2 = temp.next;
       temp.next = null;

       return new ListNode[]{head, head2};
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode[] arr = split(head);
        ListNode head2 = reverse(arr[1]);
        ListNode temp1 = arr[0];
        ListNode temp2 = head2;
        while(temp1 != null && temp2 != null){
           ListNode curr1 = temp1.next;
           ListNode curr2 = temp2.next;
           temp1.next = temp2;
           temp2.next = curr1;
           temp1 = curr1;
           temp2 = curr2;
        }
    }
}