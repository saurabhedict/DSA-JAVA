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

// class Solution {
//     public Node copyRandomList(Node head) {
//       HashMap<Node, Node> map = new HashMap<>(); //O(n)
//       Node dummy = new Node(-1);
//       Node curr1 = head;
//       Node curr2 = dummy;
//       while(curr1 != null){
//         Node temp = new Node(curr1.val);
//         temp.next = curr1.next;
//         curr2.next = temp;
//         curr2 = curr2.next;
//         curr2.next = null;
//         map.put(curr1, temp);
//         curr1 = curr1.next;
//       }
//       curr1 = head;
//       curr2 = dummy.next;
//       while(curr1 != null && curr2 != null){
//         if(curr1.random == null){
//             curr2.random = null;
//         }
//         else{
//             curr2.random = map.get(curr1.random);
//         }
//         curr1 = curr1.next;
//         curr2 = curr2.next;
//       }
//       return dummy.next;
//     }
// }



class Solution {
    public Node copyRandomList(Node head) {
      HashMap<Node, Node> map = new HashMap<>();
      
      Node temp1 = head;
      Node dummy = new Node(-1);
      Node temp2 = dummy;

      while(temp1 != null){ //dry run on pen paper
        Node temp = new Node(temp1.val);
        map.put(temp1, temp);
        temp2.next = temp;
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      temp1 = head;
      temp2 = dummy.next;
      
      while(temp1 != null){ //dry run on pen paper
        temp2.random = map.get(temp1.random); //main logic
        temp1 = temp1.next;
        temp2 = temp2.next;
      }

      return dummy.next;
    }
}