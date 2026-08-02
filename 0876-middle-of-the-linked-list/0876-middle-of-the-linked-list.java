// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode temp = head;
//         int size = 0;
//         while(temp != null){
//             size++;
//             temp = temp.next;
//         }
//         size = size/2;
//         size++;
//         temp = head;
//         for(int i = 1; i<size; i++){
//             temp = temp.next;
//         }
//         return temp;
//     }
// }




class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode temp1 = head;
       ListNode temp2 = head;
       while(temp2 != null && temp2.next != null){
          temp1 = temp1.next;
          temp2 = temp2.next.next;
        }
        return temp1;
}
}