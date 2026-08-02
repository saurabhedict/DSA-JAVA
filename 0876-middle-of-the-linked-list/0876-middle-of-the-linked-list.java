class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        size = size/2;
        size++;
        temp = head;
        for(int i = 1; i<size; i++){
            temp = temp.next;
        }
        return temp;
    }
}