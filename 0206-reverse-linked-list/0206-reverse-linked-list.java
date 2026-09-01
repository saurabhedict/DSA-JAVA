class Solution {
    public ListNode Recursive(ListNode temp, ListNode last){
        if(temp.next == null) {
            last = temp;
            return last;
        }
        last = Recursive(temp.next, last);
        temp.next.next = temp;
        temp.next = null;
        return last;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return Recursive(head, null);
    }
} //very imp : revise