class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int time;

        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p){
            return this.time - p.time; //min heap
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n+1; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i<times.length; i++){
            int initial = times[i][0];
            int destination = times[i][1];
            int time = times[i][2];
            adj.get(initial).add(new Pair(destination, time));
        }

        int[] dist = new int[n+1];
        pq.add(new Pair(k, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()){
           Pair top = pq.remove();
           for(Pair ele : adj.get(top.node)){
              int totalTime = top.time+ele.time;
              if(dist[ele.node] > totalTime){
                dist[ele.node] = totalTime;
                pq.add(new Pair(ele.node, totalTime));
              }
              
           }
        }

        int ans = -1;
        for(int i = 1; i<n+1; i++){
            ans = Math.max(ans, dist[i]);
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
       
    }
}