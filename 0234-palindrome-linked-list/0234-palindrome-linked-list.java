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
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i< arr.length; i++){
            arr[i] = list.get(i);
        }

        int k = 0;
        int l = arr.length-1;
        while(k <= l){
           if(arr[k] != arr[l]) return false;
           else{
            k++;
            l--;
           }

        }
        return true;
    }
}