// class Solution {
//     public ListNode Recursive(ListNode temp, ListNode last){
//         if(temp.next == null) {
//             last = temp;
//             return last;
//         }
//         last = Recursive(temp.next, last);
//         temp.next.next = temp;
//         temp.next = null;
//         return last;
//     }
//     public ListNode reverseList(ListNode head) {
//         if(head == null ||  head.next == null) return head;
//         return Recursive(head, null);
//     }
// } //very imp : revise 


class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next; // save next node
            curr.next = prev;          // reverse the link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev;
    }
}