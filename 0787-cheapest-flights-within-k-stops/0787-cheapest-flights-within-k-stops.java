// class Solution {
//     public class Pair implements Comparable<Pair>{
//         int node;
//         int cost;
//         Pair(int node, int cost){
//             this.node = node;
//             this.cost = cost;
//         }
        
//         public int compareTo(Pair p){
//             return Integer.compare(this.cost, p.cost);
//         }
//     }

//     public class Triplet implements Comparable<Triplet>{
//         int node;
//         int cost;
//         int stops;
//         Triplet(int node, int cost, int stops){
//             this.node = node;
//             this.cost = cost;
//             this.stops = stops;
//         }
        
//         public int compareTo(Triplet p){
//             if(this.stops == p.stops) return Integer.compare(this.cost, p.cost);
//             return Integer.compare(this.stops, p.stops);
//         }
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         PriorityQueue<Triplet> pq = new PriorityQueue<>();
//         List<List<Pair>> adj = new ArrayList<>();
//         for(int  i = 0; i<n; i++) adj.add(new ArrayList<>());

//         for(int i = 0; i<flights.length; i++){
//             int source = flights[i][0];
//             int dest = flights[i][1];
//             int cost = flights[i][2];
//             adj.get(source).add(new Pair(dest, cost));
//         }

//         int[] cost = new int[n];
//         cost[src] = 0;
//         Arrays.fill(cost, Integer.MAX_VALUE);
//         pq.add(new Triplet(src,0,0));

//         while(!pq.isEmpty()){
//             Triplet top = pq.remove();
//             int sorce = top.node;
//             int initialCost = top.cost;
//             int initialStops = top.stops;
//             if(initialStops >= k+1) continue;
//             for(Pair ele : adj.get(sorce)){
//                 int totalCost = initialCost + ele.cost;
//                 if(totalCost < cost[ele.node]){
//                     cost[ele.node] = totalCost;
//                   pq.add(new Triplet(ele.node, totalCost, initialStops+1));
//                 }
//             }
//         }
//         if(cost[dst] == Integer.MAX_VALUE) return -1;
//         return cost[dst];
//     }
// }




// class Solution {
//     public class Pair implements Comparable<Pair>{
//         int node;
//         int cost;
//         Pair(int node, int cost){
//             this.node = node;
//             this.cost = cost;
//         }
        
//         public int compareTo(Pair p){
//             return Integer.compare(this.cost, p.cost);
//         }
//     }

//     public class Triplet implements Comparable<Triplet>{
//         int node;
//         int cost;
//         int stops;
//         Triplet(int node, int cost, int stops){
//             this.node = node;
//             this.cost = cost;
//             this.stops = stops;
//         }
        
//         public int compareTo(Triplet p){
//             if(this.stops == p.stops) return Integer.compare(this.cost, p.cost);
//             return Integer.compare(this.stops, p.stops);
//         }
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         PriorityQueue<Triplet> pq = new PriorityQueue<>();
//         List<List<Pair>> adj = new ArrayList<>();
//         for(int  i = 0; i<n; i++) adj.add(new ArrayList<>());

//         for(int i = 0; i<flights.length; i++){
//             int source = flights[i][0];
//             int dest = flights[i][1];
//             int cost = flights[i][2];
//             adj.get(source).add(new Pair(dest, cost));
//         }

//         int[] cost = new int[n];
//         cost[src] = 0;
//         Arrays.fill(cost, Integer.MAX_VALUE);
//         pq.add(new Triplet(src,0,0));

//         while(!pq.isEmpty()){
//             Triplet top = pq.remove();
//             int sorce = top.node;
//             int initialCost = top.cost;
//             int initialStops = top.stops;
//             if(initialStops >= k+1) continue;
//             for(Pair ele : adj.get(sorce)){
//                 int totalCost = initialCost + ele.cost;
//                 if(totalCost < cost[ele.node]){
//                     cost[ele.node] = totalCost;
//                   pq.add(new Triplet(ele.node, totalCost, initialStops+1));
//                 }
//             }
//         }
//         if(cost[dst] == Integer.MAX_VALUE) return -1;
//         return cost[dst];
//     }
// }





// class Solution {
//     public class Pair{
//         int node;
//         int cost;
//         Pair(int node, int cost){
//             this.node = node;
//             this.cost = cost;
//         }
//     }

//     public class Triplet{
//         int node;
//         int cost;
//         int stops;
//         Triplet(int node, int cost, int stops){
//             this.node = node;
//             this.cost = cost;
//             this.stops = stops;
//         }
        
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         Queue<Triplet> pq = new LinkedList<>();
//         List<List<Pair>> adj = new ArrayList<>();
//         for(int  i = 0; i<n; i++) adj.add(new ArrayList<>());

//         for(int i = 0; i<flights.length; i++){
//             int source = flights[i][0];
//             int dest = flights[i][1];
//             int cost = flights[i][2];
//             adj.get(source).add(new Pair(dest, cost));
//         }

//         int[] cost = new int[n];
//         cost[src] = 0;
//         Arrays.fill(cost, Integer.MAX_VALUE);
//         pq.add(new Triplet(src,0,0));

//         while(!pq.isEmpty()){
//             Triplet top = pq.remove();
//             int sorce = top.node;
//             int initialCost = top.cost;
//             int initialStops = top.stops;
//             if(initialStops >= k+1) continue;
//             for(Pair ele : adj.get(sorce)){
//                 int totalCost = initialCost + ele.cost;
//                 if(totalCost < cost[ele.node]){
//                     cost[ele.node] = totalCost;
//                   pq.add(new Triplet(ele.node, totalCost, initialStops+1));
//                 }
//             }
//         }
//         if(cost[dst] == Integer.MAX_VALUE) return -1;
//         return cost[dst];
//     }
// }





class Solution {
    public class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public void BFS(List<List<Pair>> adj, int[] cost, int src, int k){
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(src,0));
       int steps = 0;

        while(!q.isEmpty() && steps <= k){
            int N = q.size();

            while(N>0){
               Pair top = q.remove();
               int source = top.node;
               int initialCost = top.cost;
               N--;
               
               for(Pair ele : adj.get(source)){
                int finalCost = initialCost+ele.cost;

                if(cost[ele.node] > finalCost){
                    q.add(new Pair(ele.node, finalCost));
                    cost[ele.node] = finalCost;
                }
               }

            }
            steps++;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int  i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i<flights.length; i++){
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            adj.get(source).add(new Pair(dest, cost));
        }

        int[] cost = new int[n];
        cost[src] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);
        BFS(adj, cost, src, k);
        if(cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}