// class Solution {
//     public int lastStoneWeight(int[] stones) {
//        ArrayList<Integer> list = new ArrayList<>();
//         for(int ele : stones){
//             list.add(ele);
//         }////O(n)

//         while(list.size() > 1){
//             Collections.sort(list);
//             int y = list.remove(list.size() -1);
//             int x = list.remove(list.size() -1);
//             if(y != x){
//                 y = y - x;
//                 list.add(y);
//             }
//         } //// almost O(n2log(n));
//         if(list.size() == 0) return 0;
//         return list.remove(0);
//     }
// }////TC = O(n) + O(n2log(n));



class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size() > 1){
            int x = pq.remove();
            int y = pq.remove();
            if(x>y) pq.add(x-y);
            else if(x<y) pq.add(y-x);
        } 
        if(pq.size() == 0) return 0;
        return pq.remove();
    }
}