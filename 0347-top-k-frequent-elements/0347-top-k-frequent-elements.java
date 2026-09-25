class Solution {
    public class Pair implements Comparable<Pair>{
        int key;
        int val;
        Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
        public int compareTo(Pair p){
            return this.val - p.val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
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
            if(pq.size() > k){
                pq.remove();
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = pq.remove().key;
        }
        return ans;
    }
} //TC : O(n) + O(nlog(k)) = O(nlog(k)) && auxilary space = O(n)+O(k) = O(n)