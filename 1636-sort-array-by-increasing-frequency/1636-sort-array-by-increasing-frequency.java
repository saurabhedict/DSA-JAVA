// class Solution {
//     public class Pair implements Comparable<Pair>{
//         int key;
//         int val;
//         Pair(int key, int val){
//             this.key = key;
//             this.val = val;
//         }
//         public int compareTo(Pair p) {
//             if (this.val != p.val) {
//                return this.val - p.val;      // smaller frequency first
//             }
//             return p.key - this.key;          // bigger key first
//         }
//     }
//     public int[] frequencySort(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int ele : nums){
//             if(map.containsKey(ele)){
//                 int freq = map.get(ele);
//                 map.put(ele, freq+1);
//             }
//             else map.put(ele, 1);
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
        
//         for(int ele : map.keySet()){
//             pq.add(new Pair(ele, map.get(ele)));
//         }
        
//         int n = pq.size();
//         int idx = 0;
//         for(int i = 0; i<n; i++){
//            Pair p = pq.remove();
//            int key = p.key;
//            int freq = p.val;
//            for(int j = 0; j<freq; j++){
//                nums[idx] = key;
//                idx++;
//            }

//         }
//         return nums;
        
//     }
// }





class Solution {
    public class Pair implements Comparable<Pair>{
        int key;
        int val;
        Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
        public int compareTo(Pair p) {
            if (this.val != p.val) {
               return this.val - p.val;      // smaller frequency first
            }
            return p.key - this.key;          // bigger key first
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
            else map.put(ele, 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int ele : map.keySet()){
            pq.add(new Pair(ele, map.get(ele)));
        }
        

        int idx = 0;
        while(!pq.isEmpty()){
           Pair p = pq.remove();
           int key = p.key;
           int freq = p.val;
           for(int j = 0; j<freq; j++){
               nums[idx] = key;
               idx++;
           }

        }
        return nums;
        
    }
}
