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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
         head = reverse(head);
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            if(!st.isEmpty() && st.peek().val > temp.val){
                temp = temp.next;
                 continue;
            }
            st.push(temp);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        temp = dummy;
        while(!st.isEmpty()){
          temp.next = st.pop();
          temp = temp.next;
          temp.next = null;
        }
        return dummy.next;
    }
}