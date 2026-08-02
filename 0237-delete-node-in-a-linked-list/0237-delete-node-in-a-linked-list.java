class Solution {
    public void deleteNode(ListNode node) {
        while(node != null){
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}