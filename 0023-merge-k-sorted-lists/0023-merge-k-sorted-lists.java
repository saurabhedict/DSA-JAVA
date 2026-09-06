class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> heap = new PriorityQueue<>( //min heap
        (a, b) -> a.val - b.val
        );
      for(int i = 0; i<lists.length; i++){
         ListNode temp = lists[i];
         while(temp != null){
            heap.add(temp);
            temp = temp.next;
         }
      }
      ListNode dummy = new ListNode(-1);
      ListNode temp = dummy;
      while(!heap.isEmpty()){
        temp.next = heap.poll();
        temp = temp.next;
        temp.next  = null;
      }
      return dummy.next;
    } 
}