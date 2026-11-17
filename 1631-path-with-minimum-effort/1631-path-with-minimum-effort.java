// class Solution {
//     public class Pair implements Comparable<Pair>{
//         int node;
//         int diff;
//         Pair(int node, int diff){
//             this.node = node;
//             this.diff = diff;
//         }

//         @Override
//         public int compareTo(Pair p){
//             return Integer.compare(this.diff, p.diff);
//         }
//     }
//     public int minimumEffortPath(int[][] height) {
//         int row = height.length;
//         int col = height[0].length;
//         ArrayList<List<Pair>> adj =  new ArrayList<>();
//         for(int i = 0; i< row*col; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         //when you move vertically column changes that's why : count-col and count+col
//         //Because moving vertically changes the flattened index by the number of columns.
//         int count = 0;
//         for(int i = 0; i<row; i++){
//             for(int j = 0; j<col; j++){
//                 if(i > 0)adj.get(count).add(new Pair(count-col, Math.abs(height[i][j]-height[i-1][j])));//up
//                 if(i < row-1)adj.get(count).add(new Pair(count+col, Math.abs(height[i][j]-height[i+1][j])));//down
//                 if(j > 0)adj.get(count).add(new Pair(count-1, Math.abs(height[i][j]-height[i][j-1])));//left
//                 if(j < col-1)adj.get(count).add(new Pair(count+1, Math.abs(height[i][j]-height[i][j+1])));//right
//                 count++;
//             }
//         }

//         int n =  row*col;
//         int[] dist = new int[n]; // 0 ---> n-1
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[0] = 0;
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>(); //min heap
//         pq.add(new Pair(0, 0));

//         while(!pq.isEmpty()){
//             Pair top = pq.remove();
//             int nodeTop = top.node;
//             int initialEffort = top.diff;

//             for(Pair ele : adj.get(nodeTop)){
//                 int eleNode = ele.node;
//                 int MovingEffort = ele.diff;
//                 int totalEffort = Math.max(initialEffort,MovingEffort);
//                 if(dist[eleNode] > totalEffort){
//                     dist[eleNode] = totalEffort;
//                     pq.add(new Pair(eleNode, totalEffort));
//                 }
                
//             }
//         }
//         return dist[n-1];
//     }
// }



class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int diff;
        Pair(int node, int diff){
            this.node = node;
            this.diff = diff;
        }

        @Override
        public int compareTo(Pair p){
            return Integer.compare(this.diff, p.diff);
        }
    }
    public int minimumEffortPath(int[][] height) {
        int row = height.length;
        int col = height[0].length;
        ArrayList<List<Pair>> adj =  new ArrayList<>();
        for(int i = 0; i< row*col; i++){
            adj.add(new ArrayList<>());
        }
        
        //when you move vertically column changes that's why : count-col and count+col
        //Because moving vertically changes the flattened index by the number of columns.
        int count = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(i > 0)adj.get(count).add(new Pair(count-col, Math.abs(height[i][j]-height[i-1][j])));//up
                if(i < row-1)adj.get(count).add(new Pair(count+col, Math.abs(height[i][j]-height[i+1][j])));//down
                if(j > 0)adj.get(count).add(new Pair(count-1, Math.abs(height[i][j]-height[i][j-1])));//left
                if(j < col-1)adj.get(count).add(new Pair(count+1, Math.abs(height[i][j]-height[i][j+1])));//right
                count++;
            }
        }

        int n =  row*col;
        int[] dist = new int[n]; // 0 ---> n-1
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //min heap
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int nodeTop = top.node;
            int initialEffort = top.diff;
            if(initialEffort > dist[nodeTop]) continue;

            for(Pair ele : adj.get(nodeTop)){
                int eleNode = ele.node;
                int MovingEffort = ele.diff;
                int totalEffort = Math.max(initialEffort,MovingEffort);
                if(dist[eleNode] > totalEffort){
                    dist[eleNode] = totalEffort;
                    pq.add(new Pair(eleNode, totalEffort));
                }
                
            }
        }
        return dist[n-1];
    }
}