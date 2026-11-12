// class Solution {
//     public void BFS(List<List<Integer>> adj, List<Integer> topological, int[] incoming){
//         int n = incoming.length;
//         Queue<Integer> que = new LinkedList<>();

//         for(int i = 0; i<n; i++){
//           if(incoming[i] == 0) que.add(i);
//         }
//         while(!que.isEmpty()){
//             int front = que.remove();
//             topological.add(front);
//             List<Integer> all = adj.get(front);
//             for(int i = 0; i<all.size(); i++){
//                 int ele = all.get(i);
//                 incoming[ele]--;
//                 if(incoming[ele] == 0) que.add(ele);
//             }
//         }
//     }
//     public boolean canFinish(int n, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             ArrayList<Integer> al = new ArrayList<>();
//             adj.add(al);
//         }

//         for(int i = 0; i<prerequisites.length; i++){
//             int course = prerequisites[i][0];
//             int req = prerequisites[i][1];
//             adj.get(req).add(course);
//         }

//         List<Integer> topological = new ArrayList<>();
//         int[] incoming = new int[n];

//         for(int i = 0; i<n; i++){
//             List<Integer> all = adj.get(i);
//             for(int j = 0; j<all.size(); j++){
//                 int idx = adj.get(i).get(j);
//                 incoming[idx]++;
//             }
//         }

//         BFS(adj, topological, incoming);

//         if(topological.size() != n) return false;
//         return true;
//     }
// }



class Solution {
    public void BFS(List<List<Integer>> adj, List<Integer> topological, int[] incoming){
        int n = incoming.length;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<n; i++) if(incoming[i] == 0) que.add(i);
        
        while(!que.isEmpty()){
            int front = que.remove();
            topological.add(front);
            List<Integer> all = adj.get(front);
            for(int i = 0; i<all.size(); i++){
                int ele = all.get(i);
                incoming[ele]--;
                if(incoming[ele] == 0) que.add(ele);
            }
        }
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add( new ArrayList<>());
        int[] incoming = new int[n];
        for(int i = 0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int req = prerequisites[i][1];
            adj.get(req).add(course);
            incoming[course]++;
        }
        List<Integer> topological = new ArrayList<>();
        BFS(adj, topological, incoming);
        return (topological.size() == n);
    }
}