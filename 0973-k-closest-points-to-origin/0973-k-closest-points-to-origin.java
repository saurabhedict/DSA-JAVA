// class Solution {
//     public class Pair{
//         int x;
//         int y;
//         Pair(int x, int y){
//             this.x = x;
//             this.y = y;
//         }
        
//     }
//     public int dist(int[] arr){
//         return arr[0]*arr[0] + arr[1]*arr[1];
//     }
//     public int[][] kClosest(int[][] points, int k) {
//         HashMap<Integer, Pair> map = new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         int[][] ans = new int[k][2];

//         for(int[] ele : points){
//             int dist = dist(ele);
//             map.put(dist, new Pair(ele[0], ele[1]));
//         }
        
//         for(int ele : map.keySet()){
//             pq.add(ele);
//             if(pq.size()>k) pq.remove();
//         }

//         for(int i = 0; i<k; i++){
//             int num = pq.remove();
//             ans[i][0] = map.get(num).x;
//             ans[i][1] = map.get(num).y;
//         }
//         return ans;
//     }
// }






class Solution {
    public class Triplet implements Comparable<Triplet>{
        int d;
        int x;
        int y;
        Triplet(int d, int x, int y){
            this.d = d;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Triplet t){
            return this.d - t.d;
        }
        
    }
    public int dist(int[] arr){
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] ele : points){
            int dist = dist(ele);
            pq.add(new Triplet(dist, ele[0], ele[1]));
            if(pq.size() > k) pq.remove();
        }
        for(int i = 0; i<k; i++){
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }
        return ans;
    }
}
