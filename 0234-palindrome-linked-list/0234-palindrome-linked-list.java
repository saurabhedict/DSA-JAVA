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
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ArrayList<Integer> list = new ArrayList<>();
//         ListNode temp = head;
//         while(temp != null){
//             list.add(temp.val);
//             temp = temp.next;
//         }
//         int[] arr = new int[list.size()];
//         for(int i = 0; i< arr.length; i++){
//             arr[i] = list.get(i);
//         }

//         int k = 0;
//         int l = arr.length-1;
//         while(k <= l){
//            if(arr[k] != arr[l]) return false;
//            else{
//             k++;
//             l--;
//            }

//         }
//         return true;
//     }
// }




// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         int count = 0;
//         ListNode temp = head;
//         while(temp != null){
//             count++;
//             temp = temp.next;
//         }
//         temp = head;
//         int[] arr = new int[count];
//         for(int i = 0; i< arr.length; i++){
//             arr[i] = temp.val;
//             temp = temp.next;
//         }

//         int k = 0;
//         int l = arr.length-1;
//         while(k <= l){
//            if(arr[k] != arr[l]) return false;
//            else{
//             k++;
//             l--;
//            }

//         }
//         return true;
//     }
// }




class Solution{
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
    public boolean isPalindrome(ListNode head) {
       int size = ListSize(head);
       if(size%2 == 0) size = size/2;
       else size = (size/2) + 1;

       ListNode temp = head;
       for(int i = 1; i<size; i++){
            temp = temp.next;
       }
       ListNode head2 = temp.next;
       temp.next = null;

       temp = head;
       ListNode temp2 = head2;
       temp2 = reverse(head2);

       while(temp != null && temp2 != null){
        if(temp.val != temp2.val) return false;
        else{
            temp = temp.next;
            temp2 = temp2.next;
        }
       }
       return true;
    }
}