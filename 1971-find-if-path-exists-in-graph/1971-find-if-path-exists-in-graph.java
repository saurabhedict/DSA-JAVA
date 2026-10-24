// class Solution {
//     public void BFS(int n, int source, int[][] adj, boolean[] visited){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(source);
//         visited[source] = true;
//         while(!q.isEmpty()){ 
//             int front = q.remove();
//             for(int j = 0; j<n; j++){
//                 if(adj[front][j] == 1 && visited[j] != true){
//                     q.add(j);
//                     visited[j] = true;
//                 }
                   
//             }
//         }
//     }
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         boolean[] visited = new boolean[n];
//         int[][] adj = new int[n][n];
//         for(int i = 0; i<edges.length; i++){
//             int row = edges[i][0];
//             int col = edges[i][1];
//             adj[row][col] = 1;
//             adj[col][row] = 1;
//         }
//         BFS(n, source, adj, visited);
//         return visited[destination];
//     }
// }




class Solution {
    public void BFS(int n, int source, List<List<Integer>> adj, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()){ 
            int front = q.remove();

            for(int ele : adj.get(front)){
                if(visited[ele] == false){
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }          
            
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i<edges.length; i++){
            int first = edges[i][0];
            int second = edges[i][1];
            adj.get(first).add(second);
            adj.get(second).add(first);
        }
        BFS(n, source, adj, visited);
        return visited[destination];
    }
}
