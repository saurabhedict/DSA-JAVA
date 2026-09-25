class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }//O(n)
        while(pq.size() > 1){
            int x = pq.remove();
            int y = pq.remove();
            if(x>y) pq.add(x-y);
            else if(x<y) pq.add(y-x);
        } // almost O(n2log(n));
        if(pq.size() == 0) return 0;
        return pq.remove();
    }
}//TC = O(n) + O(n2log(n));