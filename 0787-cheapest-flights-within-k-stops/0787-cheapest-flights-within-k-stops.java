class Solution {
    public class Triplet implements Comparable<Triplet>{
        int node;
        int cost;
        int stops;
        Triplet(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        public int compareTo(Triplet p){
            return Integer.compare(this.stops, p.stops);
        }
    }
    public class Pair {
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i<flights.length; i++){
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            adj.get(source).add(new Pair(dest, cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Triplet(src, 0, 0));

        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            if(top.stops >= k+1) continue;
            for(Pair ele : adj.get(top.node)){
                int totalCost = top.cost + ele.cost;
                if(dist[ele.node] > totalCost){
                    dist[ele.node] = totalCost;
                   pq.add(new Triplet(ele.node, totalCost, top.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}