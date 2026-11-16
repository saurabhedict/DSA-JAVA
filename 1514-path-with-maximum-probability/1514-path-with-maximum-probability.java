// class Solution {
//    public class Pair implements Comparable<Pair> {
//      int node;
//      double prob;

//      Pair(int node, double prob) {
//         this.node = node;
//         this.prob = prob;
//      }

//      @Override
//      public int compareTo(Pair p) {
//         return Double.compare(this.prob, p.prob); // Min Heap
//      }
//     }
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         List<List<Pair>> adj = new ArrayList<>();
//         double[] dist = new double[n];
//         for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
//         for(int i = 0 ; i<edges.length; i++){
//             int initial = edges[i][0];
//             int destination = edges[i][1];
//             double prob = succProb[i];
//             adj.get(initial).add(new Pair(destination, prob));
//             adj.get(destination).add(new Pair(initial, prob));
//         }
//         pq.add(new Pair(start_node, 1));
//         Arrays.fill(dist, 0.0);
//         dist[start_node] = 1;

//         while(!pq.isEmpty()){
//            Pair top = pq.remove();
//            for(Pair ele : adj.get(top.node)){
//               double totalprob = top.prob*ele.prob;
//               if(dist[ele.node] < totalprob){
//                 dist[ele.node] = totalprob;
//                 pq.add(new Pair(ele.node, totalprob));
//               }
              
//            }
//         }
//         return dist[end_node];

//     }
// }


// class Solution {
//    public class Pair implements Comparable<Pair> {
//      int node;
//      double prob;

//      Pair(int node, double prob) {
//         this.node = node;
//         this.prob = prob;
//      }

//      @Override
//      public int compareTo(Pair p) {
//         return Double.compare(p.prob, this.prob); // Max Heap
//      }
//     }
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         List<List<Pair>> adj = new ArrayList<>();
//         double[] dist = new double[n];
//         for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
//         for(int i = 0 ; i<edges.length; i++){
//             int initial = edges[i][0];
//             int destination = edges[i][1];
//             double prob = succProb[i];
//             adj.get(initial).add(new Pair(destination, prob));
//             adj.get(destination).add(new Pair(initial, prob));
//         }
//         pq.add(new Pair(start_node, 1));
//         Arrays.fill(dist, 0.0);
//         dist[start_node] = 1;

//         while(!pq.isEmpty()){
//            Pair top = pq.remove();
//            for(Pair ele : adj.get(top.node)){
//               double totalprob = top.prob*ele.prob;
//               if(dist[ele.node] < totalprob){
//                 dist[ele.node] = totalprob;
//                 pq.add(new Pair(ele.node, totalprob));
//               }
              
//            }
//         }
//         return dist[end_node];

//     }
// }



class Solution {
   public class Pair implements Comparable<Pair> {
     int node;
     double prob;

     Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
     }

     @Override
     public int compareTo(Pair p) {
        return Double.compare(this.prob, p.prob); 
     }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        List<List<Pair>> adj = new ArrayList<>();
        double[] dist = new double[n];
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i<edges.length; i++){
            int initial = edges[i][0];
            int destination = edges[i][1];
            double prob = succProb[i];
            adj.get(initial).add(new Pair(destination, prob));
            adj.get(destination).add(new Pair(initial, prob));
        }
        pq.add(new Pair(start_node, 1));
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1;

        while(!pq.isEmpty()){
           Pair top = pq.remove();
           for(Pair ele : adj.get(top.node)){
              double totalprob = top.prob*ele.prob;
              if(dist[ele.node] < totalprob){
                dist[ele.node] = totalprob;
                pq.add(new Pair(ele.node, totalprob));
              }
              
           }
        }
        return dist[end_node];

    }
}