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
        while(temp!= null){
           size++;
           temp = temp.next;
        }
        return size;
    }
    public int[] ListToArray(ListNode head){
        int size = ListSize(head);
        int[] arr = new int[size];
        ListNode temp = head;
        for(int i = 0; i<size; i++){
           arr[i] = temp.val;
           temp = temp.next;
        }
        return arr;
    }

    public int[] prefixSum(int[] arr) {

    int n = arr.length;

    int[] prefixSum = new int[n + 1];

    prefixSum[0] = 0;

    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = arr[i] + prefixSum[i];
    }

    return prefixSum;
}
    public int[] firstDuplicateIndex(int[] arr){ //find the first repeating numbers indexes
       HashMap<Integer, Integer> map = new HashMap<>();
       int n = arr.length;
       int[] ans = new int[2];
       boolean flag = false;
       for(int i = 0; i<n; i++){
        if(map.containsKey(arr[i])){
             ans[0] = map.get(arr[i]);
             ans[1] = i;
             flag = true;
             return ans;
        }
        map.put(arr[i], i);
       }
       if(flag == false){
        ans[0] = -1;
        ans[1] = -1;
        return ans;
       }
       return ans;
    }
    public int[] subArray(int[] arr, int x, int y){
        int n = arr.length;
        int l = y-x;
        int m = n - l;
        int[] ans = new int[m];
        for(int i = 0; i<x; i++){
            ans[i] = arr[i];
        }
        for(int i = y; i<n; i++){
           ans[i-l] = arr[i];
        }
        return ans;
    }
    public ListNode ArrayToList(int[] arr){
        int n = arr.length;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i = 0; i<n; i++){
            ListNode temp = new ListNode(arr[i]);
            curr.next = temp;
            curr = curr.next;

        }
        return dummy.next;
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head != null && head.next == null && head.val == 0) return null;
        if(head == null || head.next == null) return head;
        int size = ListSize(head);
        int[] arr = ListToArray(head);
        while (true) {

         int[] prefixSum = prefixSum(arr);
         int[] indexes = firstDuplicateIndex(prefixSum);

         // No duplicate prefix sum
          if (indexes[0] == -1) {
              break;
            }

         // Remove zero-sum subarray
         arr = subArray(arr, indexes[0], indexes[1]);

         // If array becomes empty
         if (arr.length == 0) {
           return null;
        }
        }
        return ArrayToList(arr);
    }
} //Most Disgusting Code ever : but logic is simple : List -> Array -> prefixSum -> findDuplicates -> Remove all Duplicates -> List -> Handle edge cases -> return 