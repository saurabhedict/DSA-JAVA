// class Solution {
//     public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
//         if(h1 == null) {
//            return h2;
//         }
//         if(h2 == null) {
//             return h1;
//         }
//         ListNode ans;
//         if(h1.val < h2.val){
//             ans = h1;
//              ans.next = mergeTwoLists(h1.next, h2);
//         }
//         else{
//             ans = h2;
//             ans.next = mergeTwoLists(h1, h2.next);
//         }
        
//         return ans;
//     }
// }




class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        ListNode ans = null;
        ListNode temp2 = ans;
        
        while(h1 != null || h2 != null){

            if(h1.val <= h2.val){
             if(ans == null){ 
                ListNode temp = h1;
                h1 = h1.next;
                temp.next = null;
                ans = temp;
                temp2 = ans;
             }
             else {
                ListNode temp = h1;
                h1 = h1.next;
                temp.next = null;
                temp2.next = temp;
                temp2 = temp2.next;
             }
             if(h1 == null){
                temp2.next = h2;
                return ans;
             }
            }

            else{
                if(ans == null) {
                    ListNode temp = h2;
                    h2 = h2.next;
                    temp.next = null;
                    ans = temp;
                    temp2 =  ans;
                }
                else {
                    ListNode temp = h2;
                    h2 = h2.next;
                    temp.next = null;
                    temp2.next = temp;
                    temp2 = temp2.next;
                }
                if(h2 == null){
                temp2.next = h1;
                return ans;
             }
            }
        }
        return ans;
    }
} //worst solution