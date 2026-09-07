// class Solution {
//     public ListNode reverse(ListNode head){
//         ListNode prev = null;
//         ListNode curr = head;
//         while(curr != null){
//             ListNode nextNode = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = nextNode;
//         }
//         return prev;
//     }
//     public void fillStack(ListNode head, Stack<ListNode> st){
//          ListNode temp = head;
//          while(temp != null){
//             st.push(temp);
//             temp = temp.next;
//         }
//     }
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Stack<ListNode> st1 = new Stack<>();
//         Stack<ListNode> st2 = new Stack<>();
        
//         fillStack(l1, st1);
//         fillStack(l2, st2);

//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         int carry = 0;

//         while(!st1.isEmpty() || !st2.isEmpty()){
//             int x = 0;
//             int y = 0;

//             if(!st1.isEmpty()) x = st1.pop().val;
//             if(!st2.isEmpty()) y = st2.pop().val;

//             int sum = x + y + carry;
//             ListNode temp1 = new ListNode(0);

//             if(sum <= 9) carry = 0;

//             else if(sum == 10){
//               carry = 1;
//               sum = 0;
//              }
//             else{
//                 carry = 1;
//                 sum = sum%10;
//             }
//             temp1.val = sum;
//             curr.next = temp1;
//             curr = curr.next;
//             curr.next = null;
//         }
//         if(carry != 0){
//             ListNode carryNode = new ListNode(carry);
//             ListNode start = reverse(dummy.next);
//             carryNode.next = start;
//             return carryNode;
            
//         }
//         return reverse(dummy.next);
//     }
// }






class Solution {
    public ListNode reverse(ListNode head){
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
    public void fillStack(ListNode head, Stack<ListNode> st){
         ListNode temp = head;
         while(temp != null){
            st.push(temp);
            temp = temp.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        
        fillStack(l1, st1);
        fillStack(l2, st2);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while(!st1.isEmpty() || !st2.isEmpty()){
            int x = 0;
            int y = 0;

            if(!st1.isEmpty()) x = st1.pop().val;
            if(!st2.isEmpty()) y = st2.pop().val;

            int sum = x + y + carry;
            ListNode temp1 = new ListNode(0);

            carry = sum / 10;
            sum = sum % 10;

            temp1.val = sum;
            curr.next = temp1;
            curr = curr.next;
        }
        if(carry != 0){
            ListNode carryNode = new ListNode(carry);
            ListNode start = reverse(dummy.next);
            carryNode.next = start;
            return carryNode;
            
        }
        return reverse(dummy.next);
    }
}