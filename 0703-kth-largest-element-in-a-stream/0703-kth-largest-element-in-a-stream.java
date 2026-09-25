// class KthLargest {
//     PriorityQueue<Integer> pq1 = new PriorityQueue<>();
//     PriorityQueue<Integer> pq2 = new PriorityQueue<>();
//     int m;
//     public KthLargest(int k, int[] nums) {
//        for(int ele : nums){
//         pq1.add(ele);
//        }
//        m = k;
//     }

//     public void solve(int val, int k){
//      for(int ele : pq1){
//         pq2.add(ele);
//         if(pq2.size() > k) pq2.remove();
//        }
//     }
    
//     public int add(int val) {
//         pq1.add(val);
//         solve(val, m);
//         int ans =  pq2.peek();
//         pq2.clear();
//         return ans;
        
//     }
// }//TLE




// class KthLargest {
//     PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
//     PriorityQueue<Integer> pq2 = new PriorityQueue<>();
//     int m;
//     public KthLargest(int k, int[] nums) {
//        for(int ele : nums){
//         pq1.add(ele);
//        }
//        m = k;
//     }

//     public void solve(int k){
//      ArrayList<Integer> ans = new ArrayList<>();
//      for(int i = 0; i<k; i++){
//         int x = pq1.remove();
//         ans.add(x);
//         pq2.add(x);
//      }
//      while(ans.size() > 0){
//         pq1.add(ans.remove(ans.size() - 1));
//      }
//     }
    
//     public int add(int val) {
//         pq1.add(val);
//         solve(m);
//         int ans =  pq2.peek();
//         pq2.clear();
//         return ans;
        
//     }
// }//TLE






class KthLargest {
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    int m;
    public KthLargest(int k, int[] nums) {
       for(int ele : nums){
        pq1.add(ele);
        if(pq1.size() > k) pq1.remove();
       }
       m = k;
    }

    public void solve(int k){
     if(pq1.size() > k) pq1.remove();
    }
    
    public int add(int val) {
        pq1.add(val);
        solve(m);
        int result =  pq1.peek();
        return result;
        
    }
}//TLE
