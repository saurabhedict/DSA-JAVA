/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      HashMap<Node, Node> map = new HashMap<>();
      Node dummy = new Node(-1);
      Node curr1 = head;
      Node curr2 = dummy;
      while(curr1 != null){
        Node temp = new Node(curr1.val);
        temp.next = curr1.next;
        curr2.next = temp;
        curr2 = curr2.next;
        curr2.next = null;
        map.put(curr1, temp);
        curr1 = curr1.next;
      }
      curr1 = head;
      curr2 = dummy.next;
      while(curr1 != null && curr2 != null){
        if(curr1.random == null){
            curr2.random = null;
        }
        else{
            curr2.random = map.get(curr1.random);
        }
        curr1 = curr1.next;
        curr2 = curr2.next;
      }
      return dummy.next;
    }
}